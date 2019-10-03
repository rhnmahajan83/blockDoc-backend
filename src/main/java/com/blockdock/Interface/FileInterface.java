package com.blockdock.Interface;

import java.util.List;

import com.blockdock.datajpa.user.model.FileDetails;

public interface FileInterface {

	 public List<FileDetails> getAllUserFiles(Long userId);
	 public List<FileDetails> getAllSentFilesForUser(Long userId);
	 public List<FileDetails> getAllReceviedFilesForUser(Long userId);
	 public FileDetails getFileById(int id);
	 public Boolean saveFile(FileDetails file);
	 public Boolean deleteFile(FileDetails file);
	 public Boolean sendFile(FileDetails file);
}
