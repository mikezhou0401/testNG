package interFace;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.scene.shape.HLineTo;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpClientTest {
    public String get(String url) {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpGet != null) {
                    httpClient.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String post(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            List<NameValuePair> ps = new ArrayList<NameValuePair>();
            for (String pKey : params.keySet()) {
                ps.add(new BasicNameValuePair(pKey, params.get(pKey)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(ps));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity, "utf-8");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpPost != null) {
                    httpPost.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public CloseableHttpResponse post(String url, String body) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new StringEntity(body));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getJsonFile(File f) {
        File file = f;

        if (!file.exists()) {
            return null;
        }
        String result = null;
        try {
            FileReader fis = new FileReader(file);
            BufferedReader br = new BufferedReader(fis);
            while (true) {
                String line = br.readLine();
                if (null == line) {
                    break;
                }
                if (result == null) {
                    result = line;
                } else result = result.concat(line);
            }
            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void test() {
        String url = "http://192.168.1.233:8011/platform/business-triggers/create";
        File f = new File("E:\\附件\\覆盖黄色场景.txt");
        HttpClientTest httpClientTest = new HttpClientTest();
        String json = httpClientTest.getJsonFile(f);
        CloseableHttpResponse response = httpClientTest.post(url, json);
        HttpEntity httpEntity = response.getEntity();
        int code=response.getStatusLine().getStatusCode();
    }
}
