package cn.hust.cstravel.test;

import cn.hust.cstravel.util.HttpUtils;
import org.apache.http.HttpResponse;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Weather_test {
    public static void main(String[] args) {
        String host = "http://iweather.market.alicloudapi.com";
        String path = "/history";
        String method = "GET";
        String appcode = "099ea36c00574ff382a165c6608fff92";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("area", "余杭");
        querys.put("city", "杭州");
        querys.put("date", "202001");
        querys.put("prov", "浙江");


        try {

            URL url = new URL("http://iweather.market.alicloudapi.com/history?APPCODE="+appcode+"&city=长沙&date=202001&prov=湖南");

            // 通过URL类的对象url的打开网络连接的功能,来打开网络连接.  并得到一个URLConnection(连接)的对象 conn
            URLConnection con = url.openConnection();
			con.connect();
            //通过连接对象con , 得到用于读取网页内容的 字节输入流 is.
            InputStream is = con.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

			String text = br.readLine();

			System.out.println(text);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
