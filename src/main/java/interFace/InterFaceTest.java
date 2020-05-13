package interFace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class InterFaceTest {
    public static final String url = "https://scm3.yunsom.com/api/view-board/position/1/content?id=1&dept_id=-1&filter_type=-1&app_id=1&t=1587107395962";

    public String get(String url) {
        HttpURLConnection conn = null;
        BufferedReader rd = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        String response = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setUseCaches(false);
            conn.connect();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = rd.readLine()) != null) {
                sb.append(line);//获取响应正文
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rd != null) {
                    rd.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    public String post(String url, Map<String, String> form) {
        HttpURLConnection conn = null;
        PrintWriter pw = null;
        BufferedReader rd = null;
        StringBuilder out = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String line = null;
        String response = null;
        for (String key : form.keySet()) {
            if (out.length() != 0) {
                out.append("&");
            }
            out.append(key).append("=").append(form.get(key));
        }
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(20000);
            conn.setReadTimeout(20000);
            conn.setUseCaches(false);
            conn.connect();

            pw = new PrintWriter(conn.getOutputStream());
            pw.print(out.toString());
            pw.flush();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rd != null) {
                    rd.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    public String json(String url, String json) {
        HttpURLConnection conn = null;
        PrintWriter pw = null;
        BufferedReader rd = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        String response = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            pw = new PrintWriter(conn.getOutputStream());
            pw.print(json);
            pw.flush();
            rd = new BufferedReader(new
                    InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line=rd.readLine())!=null){
                sb.append(line);
            }
            response=sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rd != null) {
                    rd.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;

    }

    public static void main(String[] args) {
        InterFaceTest i = new InterFaceTest();

        System.out.println(i.get(url));
    }
}
