package club.tacbin.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 文件工具
 *
 * @author 01401951
 * @version 1.0
 * @date 2021-02-05 15:14
 */
public class FileUtil {
    /**
     * 判断网络图片是否存在 posturl 图片地址链接
     */
    public static String isImagesTrue(String imgUrl) throws IOException {
        URL url = new URL(imgUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setRequestMethod("POST");
        urlCon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        if (urlCon.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println(HttpURLConnection.HTTP_OK + imgUrl + ":posted ok!");
            return "200";
        } else {
            System.out.println(urlCon.getResponseCode() + imgUrl + ":Bad post...");
            return "404";
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println(FileUtil.isImagesTrue("https://avatar.csdnimg.cn/7/1/2/3_u012641214.jpg"));
    }
}
