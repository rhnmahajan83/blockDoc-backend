package com.blockdock.datajpa.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.blockdock.datajpa.user.model.File;

public interface FileRepository extends JpaRepository<File, Long> {
	File findById(@Param("id") int id);
	List<File> findAllBySenderId(@Param("senderId") Long senderId);
	List<File> findAllByReceiverId(@Param("receiverId") Long receiverId);
	List<File> findAllByOwnerId(@Param("ownerId") Long ownerId);
	List<File> findByFileName(@Param("fileName") String fileName);
}