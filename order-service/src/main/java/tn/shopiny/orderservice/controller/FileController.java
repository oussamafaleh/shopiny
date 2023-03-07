package tn.shopiny.orderservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tn.shopiny.orderservice.service.FilesStorageService;

import org.springframework.core.io.Resource;
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FilesStorageService storageService;


    @PostMapping("/")
    public ResponseEntity<String> uploadFiles(@RequestParam("file")MultipartFile file , RedirectAttributes redirectAttributes){
        String message = "";
        try {
            storageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getLocalizedMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }
    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> uploadFiles(@PathVariable("fileName")String fileName ){
        Resource file = storageService.load(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);

    }
}
