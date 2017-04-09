import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * Extracts the information about couples from coupledata Excel sheet and store in appropriate data structure
 * @author supreet
 */
public class data{
    Vector gi=new Vector();
    Vector bi=new Vector();
    /**
     * Extracts the information about couples from coupledata Excel sheet and store in appropriate data structure
     * @throws IOException
     * @throws BiffException 
     */
    public void read() throws IOException, BiffException{
        jxl.Workbook book,book2;
        book=null; book2 =null;
        book= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
        book2= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
        jxl.Sheet s1 = book.getSheet(0);
         jxl.Sheet s2 = book2.getSheet(0);
        jxl.Cell cell1;
        
        for(int i = 1; i<s1.getRows(); i++){
            cell1 = s1.getCell(0, i);
            gi.add(cell1.getContents());
            cell1 = s1.getCell(1, i);
            bi.add(cell1.getContents());
        }
        
    }
}