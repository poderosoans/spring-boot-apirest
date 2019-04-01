package com.entel.springboot.backend.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService{
	
	private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);
	private final static String DIRECTORY_UPLOAD = "uploads";
	
	@Override
	public Resource show(String fileName) throws MalformedURLException {
		Path fileRoute = getPath(fileName);
		log.info(fileRoute.toString());
		
		Resource resource = new UrlResource(fileRoute.toUri());
		
		if(!resource.exists() && !resource.isReadable()) {
			fileRoute = Paths.get("src/main/resources/static/images").resolve("no-user.png").toAbsolutePath();
			resource = new UrlResource(fileRoute.toUri());
			
			log.error("Error no se pudo cargar la imagen: "+ fileName);
		}
		return resource;
	}

	@Override
	public String upload(MultipartFile file) throws IOException {
		
		String fileName = UUID.randomUUID().toString() +"_"+ file.getOriginalFilename().replace(" ", "");
		Path fileRoute = getPath(fileName);
		log.info(fileRoute.toString());
		
		Files.copy(file.getInputStream(), fileRoute);
		
		return fileName;
	}

	@Override
	public boolean remove(String fileName) {
		if(fileName != null && fileName.length() > 0) {
			Path previousfileRoute = Paths.get("uploads").resolve(fileName).toAbsolutePath();
			File previousImage = previousfileRoute.toFile();
			if(previousImage.exists() && previousImage.canRead()) {
				previousImage.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String fileName) {
		return Paths.get(DIRECTORY_UPLOAD).resolve(fileName).toAbsolutePath();
	}

}
