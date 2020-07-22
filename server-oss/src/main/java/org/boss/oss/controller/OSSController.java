package org.boss.oss.controller;

import org.boss.oss.common.adapter.DownloadAdapter;
import org.boss.oss.common.adapter.UploadAdapter;
import org.boss.oss.common.adapter.concrete.ConcreteDownloadAdapter;
import org.boss.oss.common.adapter.concrete.ConcreteUploadAdapter;
import org.boss.oss.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OSSController {

    @Autowired
    private OSSService service;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(){
        UploadAdapter adapter = new ConcreteUploadAdapter();
        service.update(null, "", adapter);
        return "========文件上传=======";
    }

    @PostMapping("/download")
    @ResponseBody
    public String download(){
        DownloadAdapter adapter = new ConcreteDownloadAdapter();
        service.download(null, "", adapter);
        return "========文件下载=======";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(){
        service.delete(null, "");
        return "========文件删除=======";
    }
}
