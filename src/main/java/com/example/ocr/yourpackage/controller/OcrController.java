package com.example.ocr.yourpackage.controller;

import com.example.ocr.yourpackage.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Controller
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/doOcr")
    public String doOcr(@RequestParam("file") MultipartFile file, Model model) {
        try {
            File tempFile = File.createTempFile("upload", ".png");
            file.transferTo(tempFile);
            String result = ocrService.doOcr(tempFile);
            model.addAttribute("ocrResult", result);
        } catch (IOException e) {
            model.addAttribute("errorMessage", "Failed to process file");
        }
        return "result";
    }
}
