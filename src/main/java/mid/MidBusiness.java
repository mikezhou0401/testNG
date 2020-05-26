package mid;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static interFace.HttpClientTest.post;
import static mid.GetFile.getJsonFile;

public class MidBusiness {
    final String url = "http://10.22.1.130:8011/businessTrigger/create";

    @BeforeTest
    public void before() {
        String json2 = getJsonFile(Parameter.A1_B1.getName());
        String json1 = getJsonFile(Parameter.A1_B2.getName());
        String json3 = getJsonFile(Parameter.A2_B1.getName());
        String json4 = getJsonFile(Parameter.A2_B2.getName());
        post(url, json1);
        post(url, json2);
        post(url, json3);
        post(url, json4);

        String json5 = getJsonFile(Parameter.B1_C1.getName());
        String json6 = getJsonFile(Parameter.B1_C2.getName());
        String json7 = getJsonFile(Parameter.B2_C1.getName());
        String json8 = getJsonFile(Parameter.B2_C2.getName());
        post(url, json5);
        post(url, json6);
        post(url, json7);
        post(url, json8);
    }

    @Test()
    public void testA1_A1() throws IOException {
        String json = getJsonFile(Parameter.A1_A1.getName());
        CloseableHttpResponse response = post(url, json);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));

    }

    @Test()
    public void testA2_A2() throws IOException {
        String json = getJsonFile(Parameter.A2_A2.getName());
        CloseableHttpResponse response = post(url, json);

        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }


    @Test()
    public void testA2_A1() throws IOException {
        String json = getJsonFile(Parameter.A2_A1.getName());
        CloseableHttpResponse response = post(url, json);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertTrue(entity.contains("0000"));
    }

    @Test()
    public void testA1_A2() throws IOException {
        String json = getJsonFile(Parameter.A1_A2.getName());
        CloseableHttpResponse response = post(url, json);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertTrue(entity.contains("000000"));
    }

    @Test()
    public void testTWO1() throws IOException {
        String json2 = getJsonFile(Parameter.B1_A1.getName());
        CloseableHttpResponse response = post(url, json2);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }

    @Test()
    public void testTWO2() throws IOException {
        String json2 = getJsonFile(Parameter.B2_A2.getName());
        CloseableHttpResponse response = post(url, json2);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }

    @Test()
    public void testTWO3() throws IOException {
        String json2 = getJsonFile(Parameter.B2_A1.getName());
        CloseableHttpResponse response = post(url, json2);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }

    @Test()
    public void testTWO4() throws IOException {
        String json2 = getJsonFile(Parameter.B1_A2.getName());
        CloseableHttpResponse response = post(url, json2);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }


    @Test()
    public void testC1_A1() throws IOException {
        String json = getJsonFile(Parameter.C1_A1.getName());
        post(url, json);
        CloseableHttpResponse response = post(url, json);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }

    @Test()
    public void testC1_A2() throws IOException {
        String json = getJsonFile(Parameter.C1_A2.getName());
        post(url, json);
        CloseableHttpResponse response = post(url, json);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }

    @Test()
    public void testC2_A1() throws IOException {
        String json = getJsonFile(Parameter.C2_A1.getName());
        post(url, json);
        CloseableHttpResponse response = post(url, json);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }

    @Test()
    public void testC2_A2() throws IOException {
        String json = getJsonFile(Parameter.C2_A2.getName());
        post(url, json);
        CloseableHttpResponse response = post(url, json);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertFalse(entity.contains("000000"));
    }
}



