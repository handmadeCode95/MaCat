package com.macat.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.macat.dto.ImagesDTO;

import net.coobird.thumbnailator.Thumbnails;

public class FileUpload {
	
	public static String fileUpload(MultipartFile fileData, String path, String fileName) throws IOException {
		String originalFileName = fileData.getOriginalFilename();
		String contentType = fileData.getContentType();
		long fileSize = fileData.getSize();
		
		System.out.println("file Info");
		System.out.println("fileName " + fileName);
		System.out.println("originalFileName :" + originalFileName);
		System.out.println("contentType :" + contentType);
		System.out.println("fileSize :" + fileSize);
		
		InputStream is = null;
		OutputStream out = null;
		try {
			if (fileSize > 0) {
				is = fileData.getInputStream();
				File realUploadDir = new File(path);
				if (!realUploadDir.exists()) realUploadDir.mkdirs();
				out = new FileOutputStream(path +"/"+ fileName);
				FileCopyUtils.copy(is, out);
			}else{
				new IOException("잘못된 파일을 업로드 하셨습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			new IOException("파일 업로드에 실패하였습니다.");
		}finally{
			if(out != null) out.close();
			if(is != null) is.close();
		}
		
		return path +"/"+ fileName;
	}
	
}