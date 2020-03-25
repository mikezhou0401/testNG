
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelReader {
    public static void excelAction(String filePath){
        File file=new File(filePath);
        try{
            FileInputStream in=new FileInputStream(file);
           // Workbook workBook = Workbook.create(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
