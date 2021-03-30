package icu.bleu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cutter {

    private String videoAddr =
            "D:\\Files\\我的天才女友.My.Brilliant.Friend.S01E01.中英字幕.WEB.1080p-人人影视.mp4";
    private List<String> timeStamps = null;
    //命令生成器
    private Commander command = null;
    private ProcessBuilder builder = null;

    public Cutter() {
        this.command = new Commander();
    }

    public Cutter(String videoAddr) {
        this.videoAddr = videoAddr;
        this.command = new Commander();
    }

    public void cut() {
        timeStamps = Utils.parsePbf(videoAddr);
        //生成剪切视频的命令
        Map<Integer, List<String>> cutter = command.getCutter(videoAddr, "D:\\output", timeStamps);

        runFFFmpeg(videoAddr, cutter);
    }

    //跑命令 processBuilder
    public void runFFFmpeg(String videoAddr,
                           Map<Integer, List<String>> command) {
        for (int i = 0; i < command.size(); i++) {
            System.out.println(command.get(i));
            builder = new ProcessBuilder(command.get(i)).inheritIO();
            try {
                builder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Cutter cut = new Cutter();
        cut.cut();
    }

}
