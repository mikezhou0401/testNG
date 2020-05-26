package interFace;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.Asserts;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.*;

public class Trigger {
    String body;

    @Test
    public void test() throws TestException {
        File f = new File("E:\\附件\\业务触发\\全表单.txt");
        if (f.exists() && f.length() != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                while (true) {
                    String line = br.readLine();
                    if (null == line) {
                        break;
                    }
                    if (body == null) {
                        body = line;
                    } else body = body.concat(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else throw new TestException("触发器不能为空");

        String url = "http://10.22.1.130:8102/form/define/domain-entity";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(2000).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setEntity(new StringEntity(body));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int result = response.getStatusLine().getStatusCode();
            String rs = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(rs);
            JSONObject js = JSON.parseObject(rs);
            String ja = js.getString("code");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
