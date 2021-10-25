package main.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class GetUpApp {

    public void getUp() {
        Thread thread = new Thread(() -> {
            while (true) {
                CloseableHttpClient httpClient = null;
                CloseableHttpResponse httpResponse = null;
                try {
                    Thread.sleep(1200000);
                    httpClient = HttpClients.createDefault();
                    HttpGet httpGet = new HttpGet("https://tochkaserver.herokuapp.com/admin/?login=admin&password=admin1");
                    httpResponse = httpClient.execute(httpGet);
                    HttpEntity httpEntity = httpResponse.getEntity();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        httpResponse.close();
                        httpClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
