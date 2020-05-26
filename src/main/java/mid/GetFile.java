package mid;

import java.io.*;

public class GetFile {
    public GetFile() {

    }

    public static String getJsonFile(String f) {
        String f2 = "E:\\附件\\业务触发\\" + f;
        File file = new File(f2);
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
