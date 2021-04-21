package icu.bleuweb.vo;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class VoTest {

    @Test
    public void testURL() {
        URL url = null;
        try {
            url = new URL("https://www.youtube.com/watch?v=T1ng-uoiJjY");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(url.toString());
    }
}
