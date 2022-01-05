package com.pink.forum.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v3")
public class UploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
    @PostMapping("/upload")
    public Map<String,Object> fileupload(MultipartFile file, HttpServletRequest req) {
        Map<String, Object> result = new HashMap<>();
        System.out.println(result);
        String originName = file.getOriginalFilename();
        if (!originName.endsWith(".jpg")){
            result.put("status","error");
            result.put("msg","文件类型不对");
            return result;
        }

        String format = sdf.format(new Date());
        String realPath = System.getProperty("user.dir") + "/src/main/resources/image";
        System.out.println(realPath);
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + format + newName;
            result.put("status", "OK");
            result.put("name", oldName);
            result.put("url", url);
        } catch (IOException e) {
            result.put("status", "ERROR");
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
