package com.blockdock.datajpa.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blockdock.Interface.FileInterface;
import com.blockdock.datajpa.user.model.File;
import com.blockdock.datajpa.user.repository.FileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FileService implements FileInterface {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public List<File> getAllUserFiles(Long userId) {
		return fileRepository.findAllByOwnerId(userId);
	}

	@Override
	public List<File> getAllSentFilesForUser(Long senderId) {
		return fileRepository.findAllBySenderId(senderId);
	}

	@Override
	public List<File> getAllReceviedFilesForUser(Long receiverId) {
		return fileRepository.findAllByReceiverId(receiverId);
	}

	@Override
	public File getFileById(int id) {
		return fileRepository.findById(id);
	}

	@Override
	public Boolean saveFile(File file) {
		if(fileRepository.save(file) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteFile(File file) {
		try {
			//Delete File details
			fileRepository.delete(file);
			
			// Delete File
			//Path fileToDeletePath = Paths.get(Constants.FILE_DIRECTORY);
			//Files.delete(fileToDeletePath);
			return true;
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean sendFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

}
