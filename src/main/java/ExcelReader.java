
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.*;

public class ExcelReader {
    public static void excelAction(String filePath) {
        File file = new File(filePath);
        try {
            FileInputStream in = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(in);
            Sheet sheet = workbook.getSheet(" app material follows v119");
            int numOfRows = sheet.getLastRowNum() + 1;
            Row row = sheet.getRow(4);
            int numOfColumn = row.getLastCellNum();
            System.out.println(numOfRows + "  " + numOfColumn);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);

                System.out.print(cell.getCellComment() + " ");
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExcelReader.excelAction("E:\\资料\\性能测试.xlsx");

    }
}
