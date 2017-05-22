package com.niit.CollaborationBackEnd.dao;

import com.niit.CollaborationBackEnd.model.FileUpload;

public interface FileUploadDao 
{

	void save(FileUpload fileUpload);
	FileUpload getFile(String username);
}
