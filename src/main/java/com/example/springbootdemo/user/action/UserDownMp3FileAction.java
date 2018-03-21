package com.example.springbootdemo.user.action;

import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/user/down")
public class UserDownMp3FileAction {
	
	
	@RequestMapping(value = "/media", method = RequestMethod.GET)  
    public ResponseEntity<InputStreamResource> downloadFile( Long id)  
            throws IOException {  
        String filePath = "D:/speech/result.mp3";  
        FileSystemResource file = new FileSystemResource(filePath);  
        HttpHeaders headers = new HttpHeaders();  
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));  
        headers.add("Pragma", "no-cache");  
        headers.add("Expires", "0");  
  
        return ResponseEntity  
                .ok()  
                .headers(headers)  
                .contentLength(file.contentLength())  
                .contentType(MediaType.parseMediaType("application/octet-stream"))  
                .body(new InputStreamResource(file.getInputStream()));  
    }  

}
