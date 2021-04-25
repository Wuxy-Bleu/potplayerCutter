package icu.bleuweb.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * 构建各种command
 */
public class Command {
    private static List<String> commands = new ArrayList<>();

    public static final String URL_TEST = "https://www.youtube.com/watch?v=UJce1TRbmxY";

    private static final String YOUTUBE_DL = "youtube-dl";
    private static final String LIST_FORMAT = "--list-formats";
    private static final String BEST_VIDEO_AND_AUDIO = "bestvideo+bestaudio";
    private static final String FORMAT = "-f";
    private static final String OUTPUT = "-o";
    private static final String DEFAULT_OUTPUT_LOCATION = "\'/download/%(title)s.%(ext)s\'";


    /**
     * 获取youtube视频所有格式
     *
     * @return
     */
    public static List<String> ListFormat() {
        commands.clear();
        commands.add(YOUTUBE_DL);
        commands.add(LIST_FORMAT);
        return commands;
    }

    /**
     * win下利用jvm启动notepad
     *
     * @return
     */
    public static List<String> editTxt() {
        commands.clear();
        commands.add("notepad");
        return commands;
    }

    public static List<String> downloadBest() {
        commands.clear();
        commands.add(YOUTUBE_DL);
        commands.add(FORMAT);
        commands.add(BEST_VIDEO_AND_AUDIO);
        commands.add(OUTPUT);
        commands.add(DEFAULT_OUTPUT_LOCATION);

        return commands;
    }


}
