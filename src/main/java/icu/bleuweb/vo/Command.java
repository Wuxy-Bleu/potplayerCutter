package icu.bleuweb.vo;

import java.util.ArrayList;
import java.util.List;


//这个类用来构成参数
public class Command {
    private static final String YOUTUBE_DL = "youtube-dl";
    private static final String LIST_FORMAT = "--list-formats";

    public static List<String> ListFormat() {
        List<String> commands = new ArrayList<>();
//        commands.add("cmd.exe");
        commands.add(YOUTUBE_DL);
        commands.add(LIST_FORMAT);
        return commands;
    }

    public static List<String> editTxt() {
        List<String> command = new ArrayList<>();
        command.add("notepad");
        return command;
    }

}
