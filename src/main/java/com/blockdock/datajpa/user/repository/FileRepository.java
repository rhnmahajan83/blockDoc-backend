package com.blockdock.datajpa.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.blockdock.datajpa.user.model.FileDetails;

public interface FileRepository extends JpaRepository<FileDetails, Long> {
	FileDetails findById(@Param("id") int id);
	List<FileDetails> findAllBySenderId(@Param("senderId") Long senderId);
	List<FileDetails> findAllByReceiverId(@Param("receiverId") Long receiverId);
	List<FileDetails> findAllByOwnerId(@Param("ownerId") Long ownerId);
	List<FileDetails> findByFileName(@Param("fileName") String fileName);
}