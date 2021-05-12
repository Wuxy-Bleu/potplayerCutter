package icu.bleuweb.service;

import icu.bleuweb.runner.ProcessRunner;
import icu.bleuweb.vo.DownloadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadService {

    ProcessRunner runner = new ProcessRunner();

    @Autowired
    public DownloadService(ProcessRunner runner) {
        this.runner = runner;
    }

    public void download(DownloadProperties downloadProperties) {
//        runner.executeFormat(downloadProperties);
//        runner.executeEdit();
//        runner.downloadBest(downloadProperties);
//        runner.whichShell(downloadProperties);
//        runner.pwd();
//        runner.ps();
//        runner.whichUser();
        runner.basicDownload();

    }


}
