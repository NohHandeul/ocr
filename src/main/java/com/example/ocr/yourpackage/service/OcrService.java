package com.example.ocr.yourpackage.service;

import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class OcrService {
    public String doOcr(File imageFile) {
        ITesseract instance = new Tesseract();

        // Tesseract 데이터 파일 경로 설정
        instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

        try {
            return instance.doOCR(imageFile);
        } catch (TesseractException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
