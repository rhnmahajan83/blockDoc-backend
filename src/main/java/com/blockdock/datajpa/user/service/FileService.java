package com.blockdock.datajpa.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import com.blockdock.Interface.FileInterface;
import com.blockdock.datajpa.user.model.FileDetails;
import com.blockdock.datajpa.user.repository.FileRepository;
import com.deswaef.spring.examples.datajpa.util.Constants;

@Service
@Transactional
public class FileService implements FileInterface {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public List<FileDetails> getAllUserFiles(Long userId) {
		return fileRepository.findAllByOwnerId(userId);
	}

	@Override
	public List<FileDetails> getAllSentFilesForUser(Long senderId) {
		return fileRepository.findAllBySenderId(senderId);
	}

	@Override
	public List<FileDetails> getAllReceviedFilesForUser(Long receiverId) {
		return fileRepository.findAllByReceiverId(receiverId);
	}

	@Override
	public FileDetails getFileById(int id) {
		return fileRepository.findById(id);
	}

	@Override
	public Boolean saveFile(FileDetails file) {
		if(fileRepository.save(file) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteFile(FileDetails file) {
		try {
			String ftdName = Constants.FILE_DIRECTORY + "/" + file.getFileName();
			System.out.println(file.getFileName());
			System.out.println(Constants.FILE_DIRECTORY);
			System.out.println(ftdName);
			File fileToDelete = new File(ftdName);
			fileToDelete.delete();
			fileRepository.delete(file);
			return true;
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean sendFile(FileDetails file) {
		// TODO Auto-generated method stub
		return null;
	}

}
