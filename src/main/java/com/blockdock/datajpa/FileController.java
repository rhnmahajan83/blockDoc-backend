package com.blockdock.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blockdock.datajpa.user.model.FileDetails;
import com.blockdock.datajpa.user.model.User;
import com.blockdock.datajpa.user.payload.ResponseStatus;
import com.blockdock.datajpa.user.payload.UploadFileResponse;
import com.blockdock.datajpa.user.service.FileService;
import com.blockdock.datajpa.user.service.FileStorageService;
import com.deswaef.spring.examples.datajpa.util.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private FileService fileService;
    
    @PostMapping("/uploadFile")
    public ResponseStatus uploadFile(@RequestParam("file") MultipartFile file,  @RequestParam("filedetails") String fileDetails) {
    	FileDetails newFile = null ;
    	String fileName = fileStorageService.storeFile(file);
    	if(fileName != "") {
    		ObjectMapper objMapper = new ObjectMapper();
            try {
    			 newFile= objMapper.readValue(fileDetails, FileDetails.class);
    		} catch (JsonParseException e) {
    			e.printStackTrace();
    		} catch (JsonMappingException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        
    	if(file !=null && fileDownloadUri != "") {
            newFile.setFileName(fileName);
            newFile.setFileSize(file.getSize());
            newFile.setFileType(file.getContentType());
            newFile.setFileURI(fileDownloadUri);
    	}
        
        if(fileService.saveFile(newFile)) {
        	return new ResponseStatus(Constants.FILEUPLOAD_SUCCESSFUL_, "File uploaded Successfully");
        }else {
        	return new ResponseStatus(Constants.FILEUPLOAD_FAILED, "File not uploaded");
        }
    }

	/*
	 * @PostMapping("/uploadMultipleFiles") public List<UploadFileResponse>
	 * uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) { return
	 * Arrays.asList(files) .stream() .map(file -> uploadFile(file))
	 * .collect(Collectors.toList()); }
	 */

    @GetMapping("/downloadFile/{fileId:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int fileId, HttpServletRequest request) {
    	
    	FileDetails  file = fileService.getFileById(fileId);
    	
    	if(file != null) {
    		// Load file as Resource
            Resource resource = fileStorageService.loadFileAsResource(file.getFileName());

            // Try to determine file's content type
            String contentType = null;
            try {
                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            } catch (IOException ex) {
                logger.info("Could not determine file type.");
            }

            // Fallback to the default content type if type could not be determined
            if(contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
    	}
		return null;
    }
    
    
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseStatus deletefile(@RequestBody FileDetails file) {
    	if(fileService.deleteFile(file)) {
    	return new ResponseStatus(Constants.FILE_DELETED_SUCCESSFULLY,"File deleted successfully");
    	}else {
    		return new ResponseStatus(Constants.FILE_DOES_NOT_EXIST,"Cant delete file, check if it exists");	
    	}
    	}
    
}