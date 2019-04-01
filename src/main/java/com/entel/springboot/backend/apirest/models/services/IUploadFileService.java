package com.entel.springboot.backend.apirest.models.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	
	public Resource show(String fileName) throws MalformedURLException;
	public String upload(MultipartFile file) throws IOException;
	public boolean remove(String fileName);
	public Path getPath(String fileName);
	
}
