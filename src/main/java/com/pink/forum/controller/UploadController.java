package com.pink.forum.controller;

import com.pink.forum.message.Result;
import com.pink.forum.service.UserService;
import com.pink.forum.shiro.ShiroUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UploadController {

    final UserService userService;

    @PostMapping("/upload")
    public Result fileupload(MultipartFile file, HttpServletRequest req) {
        String originName = file.getOriginalFilename();
        String realPath = "/home/crush/image";
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = ShiroUtils.getUser().getId() + "avatar" + oldName.substring(oldName.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int res = userService.updateAvatar("http://localhost/" + newName);
        if (res == 0) {
            return Result.bad("修改失败");
        } else {
            return Result.ok();
        }
    }
}
