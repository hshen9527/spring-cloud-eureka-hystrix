package org.boss.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    @GetMapping("/hi")
    @ResponseBody
    public String fileTest(){
        return "hi, welcome to here";
    }

}
