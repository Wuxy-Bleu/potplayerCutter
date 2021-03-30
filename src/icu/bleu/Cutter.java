package icu.bleu;

import java.util.Arrays;
import java.util.List;

public class Cutter {

    public static void main(String[] args) {
        String videoAddr =
                "D:\\Files\\我的天才女友.My.Brilliant.Friend.S01E01.中英字幕.WEB.1080p-人人影视.mp4";
        List<String> timeStamps = Utils.parsePbf(videoAddr);
        List<String> command = Command.getCutter(videoAddr, "D:\\output.mp4", timeStamps);
        Utils.runFFFmpeg(videoAddr,command);
        System.out.println(command);
//        System.out.println(timeStamps.get(0));
//        System.out.println(timeStamps.get(0).length());
    }

}
