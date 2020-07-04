package cn.hust.cstravel.service.implement;

import cn.hust.cstravel.service.WeatherService;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherServiceI implements WeatherService{
    @Override
    public String weather() {
        String text = null;
        try {

            URL url = new URL("https://free-api.heweather.net/s6/weather/now?location=changsha&key=adb1f28f92af417ba0d60dc3edfb02b4");

            // 通过URL类的对象url的打开网络连接的功能,来打开网络连接.  并得到一个URLConnection(连接)的对象 conn
            URLConnection con = url.openConnection();
            con.connect();
            //通过连接对象con , 得到用于读取网页内容的 字节输入流 is.
            InputStream is = con.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            text = br.readLine();

            //System.out.println(text);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
