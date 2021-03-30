package icu.bleu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    //毫秒转时分秒 ffmpeg命令中会用到 -ss后面
    public static String ms2hms(long ms) {
        int hour = (int) (ms / (1000 * 60 * 60));
        int min = (int) ((ms % (1000 * 60 * 60)) / (1000 * 60));
        int sec = (int) ((ms - hour * 1000 * 60 * 60 - min * 1000 * 60) / 1000);
        int last = (int) (ms - hour * 1000 * 60 * 60 - min * 1000 * 60 - sec * 1000);
        String time = String.valueOf(hour) + ":"
                + String.valueOf(min) + ":"
                + String.valueOf(sec) + "."
                + String.valueOf(last);
        return time;
    }

    //找到所有的pbf文件 未实现
    public static void allPbf(String addr) {
        File file = new File(addr);
        if (file.isFile() && file.exists()) {

        }
    }

    //解析pbf,提取出所有的书签的毫秒数
    public static List<String> parsePbf(String mp4) {
        String pbf = mp4.substring(0, mp4.lastIndexOf(".")) + ".pbf";
        File file = new File(pbf);

        if (file.isFile() && file.exists()) {

            FileReader fileReader = null;
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //获取流
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<String> commandArgs = new ArrayList<String>();
            String str = null;
            //正则表达式 用正则来截取字符串太fuck了，暂时不用吧
//            Pattern p = Pattern.compile("=.*/*");
            while (true) {
                try {
                    if ((str = bufferedReader.readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (str.trim().length() > 50) {
                    commandArgs.add(str.substring(
                            str.indexOf('=') + 1, str.indexOf('*'))
                            .trim().replaceAll("[\u0000]", ""));
                }
            }

//            for (String marks : commandArgs) {
//                System.out.println(marks);
//            }
            return commandArgs;
        } else {
            System.out.println(file.getName() + " does not exist");
            return null;
        }
    }


}
