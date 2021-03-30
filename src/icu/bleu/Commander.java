package icu.bleu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commander {

    public static final String FFMPEG = "D:\\Tools\\ffmpeg-4.3.2-2021-02-27-full_build\\bin\\ffmpeg.exe";
    public static final String Y = "-y";
    public static final String INPUT = "-i";
    public static final String C = "-c";
    public static final String COPY = "copy";
    public static final String TO = "-to";
    public static final String T = "-t";
    public static final String F = "-f";
    public static final String S = "-s";
    public static final String SS = "-ss";
    public static final String CV = "-c:v";
    public static final String CA = "-c:a";
    public static final String STRICT = "-strict";
    public static final String VF = "-vf";
    public static final String THREADS = "-threads";


    public Commander() {

    }

    public Map<Integer, List<String>> getCutter(String inputVideo,
                                                String outputVideo,
                                                List<String> timeStamps) {
        Map<Integer, List<String>> scripts = new HashMap<>();
        for (int i = 0; i < timeStamps.size() / 2; i++) {
            List<String> commands = new ArrayList<>();
            commands.add(FFMPEG);
            commands.add(INPUT);
            commands.add(inputVideo);
            commands.add(SS);
            commands.add(Utils.ms2hms(Integer.parseInt(timeStamps.get(2 * i))));
            commands.add(C);
            commands.add(COPY);
            commands.add(TO);
            commands.add(Utils.ms2hms(Integer.parseInt(timeStamps.get(2 * i + 1))));
            commands.add(outputVideo + "-" + i + ".mp4");
            scripts.put(i, commands);
        }

        return scripts;
    }

}
