package com.blockdock.Interface;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blockdock.datajpa.user.model.File;

public interface FileInterface {

	 public List<File> getAllUserFiles(Long userId);
	 public List<File> getAllSentFilesForUser(Long userId);
	 public List<File> getAllReceviedFilesForUser(Long userId);
	 public File getFileById(int id);
	 public Boolean saveFile(File file);
	 public Boolean deleteFile(File file);
	 public Boolean sendFile(File file);
}
