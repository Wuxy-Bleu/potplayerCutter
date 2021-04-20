package icu.bleuweb.service;

import icu.bleuweb.properties.DownloadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadService {

    DownloadProperties downloadProperties;

    @Autowired
    public DownloadService(DownloadProperties properties) {
        this.downloadProperties = properties;
    }

    @Override
    public String toString() {
        return "DownloadService{" +
                "downloadProperties=" + downloadProperties +
                '}';
    }
}
