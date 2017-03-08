import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * Class having main function for q1
 * @author supreet
 */
public class q1 {
    /**
     * main function for q1.Uses different functions of classes couples and randomgenerator
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     * @throws BiffException 
     */
     public static void main(String[] args) throws FileNotFoundException, IOException, BiffException{
        
       
         randomgenerator r= new randomgenerator();
        
         couples c=new couples();
         String name,name2;
         r.writeboy();
         r.writegirl();
         c.read();
        jxl.Workbook bookc=jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
        jxl.Sheet co = bookc.getSheet(0);jxl.Cell cell;
         System.out.println("Formed couples are:");
         for(int i=1;i<co.getRows();i++){
             cell = co.getCell(0, i);
             name=cell.getContents();
             cell=co.getCell(1,i);
             name2=cell.getContents();
             System.out.println("girl= " + name+"    boy= "+ name2);
         }
         
     }
}

