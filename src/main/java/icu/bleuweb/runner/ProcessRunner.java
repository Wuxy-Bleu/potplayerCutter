package icu.bleuweb.runner;

import icu.bleuweb.vo.Command;
import icu.bleuweb.vo.DownloadProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProcessRunner {

    public void execute(DownloadProperties properties) {
        List<String> command = Command.ListFormat();
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

    public void executeEdit() {
        List<String> command = Command.editTxt();
        ProcessBuilder builder = new ProcessBuilder(command);
        log.info(builder.command().toString());
        try {
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
