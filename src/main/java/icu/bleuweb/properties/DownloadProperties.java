package icu.bleuweb.properties;

import icu.bleuweb.properties.types.OperatingSystemType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

@Component
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "ytbdl")
public class DownloadProperties {
    //命令名
    private static final String YOUTUBE_DL = "youtube-dl";
    //系统信息
    private OperatingSystemType operationSystemType;
    //需要下载的url
    private URL url;
    //用户根目录
    private File rootDir;
    //下载目录 默认当前路径
    private File downloadDir;
    //下载文件名
    private String downloadFilename;
    //下载的相对路径 相对当前位置
    private String fullPath;

    DownloadProperties() {
    }

    public void setOperationSystemType() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("linux") >= 0)
            this.operationSystemType = OperatingSystemType.LINUX;
        else if (os.indexOf("mac") >= 0 && os.indexOf("os") > 0)
            this.operationSystemType = OperatingSystemType.MAC_OS;
        else if (os.indexOf("win") >= 0)
            this.operationSystemType = OperatingSystemType.WINDOWS;
        else
            this.operationSystemType = OperatingSystemType.OTHER;
    }


    public void setRootDir() {
        this.rootDir = new File(System.getProperty("user.home"));
    }
}
