package icu.bleuweb.controller;

import icu.bleuweb.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DownloadController {

    DownloadService downloadService;

    @Autowired
    public DownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @RequestMapping("/download")
    public Map<String, String> download(@RequestParam URL url) {


        Map<String, String> test = new HashMap<>();
        test.put("url", url.toString());
        test.put("download properties", downloadService.toString());
        return test;
    }
}
