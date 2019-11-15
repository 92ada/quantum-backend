package com.techncat.quantum.app.file_server;

import com.techncat.quantum.app.file_server.service.StorageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class FileController {

    private StorageService storageService;

    FileController(@Autowired StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/api/upload")
    @ResponseBody
    public ResponseEntity upload(MultipartFile file) {
        String fileName = storageService.store(file);
        Map<String, String> map = new HashMap<>();
        map.put("fileName", fileName);
        map.put("fileOriginName", file.getOriginalFilename());
        map.put("fileUrl", "/file/" + fileName);
        return ResponseEntity.status(201).body(map);
    }

    @GetMapping("/file/{filename:.+}")
    @ResponseBody
    public void fetch(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
//        MediaType mediaType = getTypeByName(filename);
//        response.setContentType(mediaType.getType());
        IOUtils.copy(storageService.loadAsResource(filename).getInputStream(), response.getOutputStream());
    }

    private MediaType getTypeByName(String name) {
        int index = name.lastIndexOf(".");
        String type = name.substring(index).toLowerCase();
        switch (type) {
            case "jpeg":
            case "jpg":
                return MediaType.IMAGE_JPEG;
            case "png":
                return MediaType.IMAGE_PNG;
            case "gif":
                return MediaType.IMAGE_GIF;
            case "pdf":
                return MediaType.APPLICATION_PDF;
            default:
                return MediaType.ALL;
        }
    }
}
