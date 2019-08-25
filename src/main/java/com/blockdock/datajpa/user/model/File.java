package com.blockdock.datajpa.user.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="File_Details")
//@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class File {
	
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Id
	private int id;
	
	@Basic
    @Column
	private String fileName;
	
	@Basic
    @Column
	private String fileType;
	
	@Basic
    @Column
	private int fileSize;
	
	@Basic
    @Column
	private Long senderId;
	
	@Basic
    @Column
	private Long receiverId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

}
