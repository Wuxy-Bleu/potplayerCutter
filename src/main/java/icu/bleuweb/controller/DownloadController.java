package icu.bleuweb.controller;

import icu.bleuweb.vo.DownloadProperties;
import icu.bleuweb.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DownloadController {

    DownloadService downloadService;
    DownloadProperties downloadProperties;

    @Autowired
    public DownloadController(DownloadService downloadService, DownloadProperties downloadProperties) {
        this.downloadService = downloadService;
        this.downloadProperties = downloadProperties;
        downloadProperties.setRootDir();
        downloadProperties.setOperationSystemType();
    }

    @RequestMapping("/download")
    public Map<String, String> download(@RequestParam URL url) {
        this.downloadProperties.setUrl(url);

        downloadService.download(downloadProperties);

        Map<String, String> test = new HashMap<>();
        test.put("download properties", this.downloadProperties.toString());
        return test;
    }
}