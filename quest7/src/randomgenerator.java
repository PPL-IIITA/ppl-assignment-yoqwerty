//q5
import java.security.SecureRandom;
import java.math.BigInteger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import java.util.stream.IntStream;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 *<h2>Generates the data randomly and store in the current working directory of user</h2>
 * 
 */
public class randomgenerator {
    /**
     * Generates data for girls randomly and stores it in Excel Sheet named "gdata" in the current working directory of the user
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writegirl() throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        CreationHelper ch = wb.getCreationHelper();
        Sheet s = wb.createSheet("gdata");
        Row row = null;
        Cell cell = null;
        Column c = null;
        row = s.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("gname");
        cell = row.createCell(1);
        cell.setCellValue("attrct");
        cell = row.createCell(2);
        cell.setCellValue("m_cost");
        cell = row.createCell(3);
        cell.setCellValue("intl");
        cell = row.createCell(4);
        cell.setCellValue("criteria");
        cell = row.createCell(5);
        cell.setCellValue("nature");
        Random r=new Random();
        Vector v = new Vector();
        int no;
         String s1;
        for(int i =1; i<=30; i++){
            row = s.createRow(i);
            cell = row.createCell(0); //name           
            while(true){
                s1 = nextSessionId();
                if(!v.contains(s1)){
                    cell.setCellValue(s1);
                    v.add(s1);
                    break;
                }
            }
            cell=row.createCell(1);//attractive level
            int l=1; int h=11;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);           
            cell=row.createCell(2);//m_cost
             l=50; h=1001;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
            cell=row.createCell(3);//intelligence level
             l=1; h=11;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
            cell=row.createCell(4);//criteria
            l=1; h=4;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
            cell=row.createCell(5);//nature
            l=1;h=4;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
        } 
       // FileOutputStream f=new FileOutputStream("D:\\gdata.xls");
         FileOutputStream f=new FileOutputStream(System.getProperty("user.dir")+"\\gdata.xls");
        // System.out.println(System.getProperty("user.dir")+"\\gdata.xls");
        wb.write(f);
        f.close();
        
    }
    /**
     *  Generates data for boys randomly and stores it in Excel Sheet named "bdata" in the current working directory of the user
     * @throws FileNotFoundException
     * @throws IOException 
     */
     public void writeboy() throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        CreationHelper ch = wb.getCreationHelper();
        Sheet s = wb.createSheet("bdata");
        Row row = null;
        Cell cell = null;
        Column c = null;
       // c = s.
        row = s.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("bname");
        cell = row.createCell(1);
        cell.setCellValue("attrct");
        cell = row.createCell(2);
        cell.setCellValue("m_budet");
        cell = row.createCell(3);
        cell.setCellValue("intl");
        cell = row.createCell(4);
       // cell.setCellValue("criteria");
        //cell = row.createCell(5);
        cell.setCellValue("nature");
        cell = row.createCell(5);
        cell.setCellValue("req_attrct");
        Random r=new Random();
        Vector v = new Vector();
        int no;
        for(int i =1; i<=100; i++){
            row = s.createRow(i);
            cell = row.createCell(0);
            String s1;
            while(true){
                s1 = nextSessionId();
                if(!v.contains(s1)){
                    cell.setCellValue(s1);
                    v.add(s1);
                    break;
                }
            }
            cell=row.createCell(1);//attractive level
            int l=1; int h=11;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);             
            cell=row.createCell(2);//m_budget
             l=100; h=1500;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
            cell=row.createCell(3);//intelligence level
             l=1; h=11;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
           /* cell=row.createCell(4);//criteria
            l=1; h=4;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);*/
            cell=row.createCell(4);//nature
           // l=1; h=4;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
             cell=row.createCell(5);//reqd_
           // l=1; h=4;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no);
            
        }
        // FileOutputStream f=new FileOutputStream("D:\\bdata.xls");
         FileOutputStream f=new FileOutputStream(System.getProperty("user.dir").toString()+"\\bdata.xls");
        
         wb.write(f);
         f.close();
    }
     /**
      * Generates data for gifts randomly and stores it in Excel Sheet named "giftdata" in the current working directory of the user
      * @throws FileNotFoundException
      * @throws IOException 
      */
      public void writegift() throws FileNotFoundException, IOException{
         int i;
         Random r=new Random();
        Workbook wb = new HSSFWorkbook();
        CreationHelper ch = wb.getCreationHelper();
        Sheet s = wb.createSheet("giftdata");
        Row row = null;
        Cell cell = null;
        Column c = null;
        int no;
        row = s.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("price");
        // row = s.createRow(0);
        cell = row.createCell(1);
        cell.setCellValue("value");
        for(i=1;i<=30;i++){
            row=s.createRow(i);
            
            cell = row.createCell(0);
            int l=50; int h=1001;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no); 
            
            cell = row.createCell(1);
            l=10;  h=1001;
            no=r.nextInt(h-l)+l;
            cell.setCellValue(no); 
        
        } 
      //  FileOutputStream f=new FileOutputStream("D:\\giftdata.xls");
       FileOutputStream f=new FileOutputStream(System.getProperty("user.dir").toString()+"\\giftdata.xls");
         wb.write(f);
         f.close();
            
    }       
 
     private SecureRandom random = new SecureRandom();

       public String nextSessionId() {
        return new BigInteger(30, random).toString(32);
       }
  
}
        
    

