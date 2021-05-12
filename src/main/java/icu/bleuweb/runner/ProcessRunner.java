package icu.bleuweb.runner;

import icu.bleuweb.vo.Command;
import icu.bleuweb.vo.DownloadProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ProcessRunner {

    private List<String> command = null;

    public void executeFormat(DownloadProperties properties) {
        //生成command，最终加上youtube url地址
        this.command = Command.ListFormat();
        command.add(properties.getUrl().toString());
        //创建一个shell进程，用来执行command
        ProcessBuilder builder = new ProcessBuilder(command);
        //输出command
        log.info(builder.command().toString());
        //shell进程的输出重定向到jvm的控制条
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        //获取shell进程的环境变量
        Map<String, String> environment = builder.environment();
        log.info(environment.toString());
        //执行command
        try {
            final Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void executeEdit() {
        this.command = Command.editTxt();
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        try {
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadBest(DownloadProperties properties) {
        this.command = Command.downloadBest();
        command.add(properties.getUrl().toString());
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
            final Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void whichShell(DownloadProperties properties) {
        this.command = Command.whichShell();
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
            final Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pwd() {
        this.command = Command.pwd();
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
            final Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ps() {
        this.command = Command.ps();
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
            final Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void whichUser() {
        this.command = Command.whichUser();
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
            final Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void basicDownload() {
        this.command = Command.basicDownload();
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
            final Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
