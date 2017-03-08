
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 *<h2> Allocate boyfriends to all girls in the same order as given in the input</h2>
 * Stores their names in Excel sheet named coupledata
 */
public class couples {
     public int comp(int a,int b,int c){
        if(a>b&&a>c)
            return 3;
        else if(b>a&&b>c)
            return 1;
        else return 2;//1 for rich , 2 for intelligent 3 for attractive
    }
    /**
     * It reads the input from the Excel Sheets and allocates boyfriends to the girls in the order of randomly generated data in Excel Sheets.It stores the names of couples formed in the sheet named coupledata.xls in the current working directory of the user 
     * @throws IOException
     * @throws BiffException 
     */
    public void read() throws IOException, BiffException{
       jxl.Workbook book1,book2;
        Workbook wb = new HSSFWorkbook();
        CreationHelper ch = wb.getCreationHelper();
        Sheet s = wb.createSheet("coupledata");
        Row row = null;
        Cell cell = null;
        row = s.createRow(0);
        cell = row.createCell(0); 
        cell.setCellValue("girl");
        cell = row.createCell(1);
        cell.setCellValue("boy");
      int flag,t,f=-1;
      book1=null; book2 =null;
     // book1= jxl.Workbook.getWorkbook(new File("D:\\gdata.xls"));
      //book2= jxl.Workbook.getWorkbook(new File("D:\\bdata.xls"));
      book1= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\gdata.xls"));
      book2= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
      
      jxl.Sheet s1 = book1.getSheet(0);
      jxl.Sheet s2 = book2.getSheet(0);
      jxl.Cell cell1, cell2;
      Vector fl=new Vector();
      int k = 1;
      for(int i = 1; i<s1.getRows(); i++){
          cell1 = s1.getCell(2, i);
          flag=0;
          int v1 =new Integer(Integer.parseInt(cell1.getContents()));
        for(int j=1;j<s2.getRows();j++){
            if(j!=f){
                cell2 = s2.getCell(2,j);
                int v2 =new Integer(Integer.parseInt(cell2.getContents())); 
                if(v2>v1){
                    cell1 = s1.getCell(1, i);
                    int att = new Integer(Integer.parseInt(cell1.getContents()));
                    cell2 = s2.getCell(5, i);
                    int req_at = new Integer(Integer.parseInt(cell2.getContents()));
                    if(att>=req_at){
                        cell1 = s1.getCell(4, i);
                        int cr = new Integer(Integer.parseInt(cell1.getContents()));
                        cell2 = s2.getCell(1,j);
                        int a = new Integer(Integer.parseInt(cell2.getContents()));
                        cell2 = s2.getCell(2,j);
                        int r = new Integer(Integer.parseInt(cell2.getContents()))/250;
                        cell2 = s2.getCell(3,j);
                        int in = new Integer(Integer.parseInt(cell2.getContents()));
                        t=comp(a,r,i);
                        if(cr==1&&t==1)                           
                              flag=1;
                        if(cr==2&&t==2)
                                flag=1;
                        if(cr==3&&t==3)
                                flag=1;
                        if(flag==1){
                            if(fl.contains(j)){
                              flag=0;
                              continue;
                            }
                            cell1=s1.getCell(0,i);
                            cell2=s2.getCell(0,j);
                            row = s.createRow(k);
                            cell = row.createCell(0);
                            cell.setCellValue(cell1.getContents());
                            cell = row.createCell(1);
                            cell.setCellValue(cell2.getContents());
                            fl.add(j);
                            k++;
                            flag=0;
                            break;
                        }
                    }
                }
                  
            }
        }
            
    }
      //FileOutputStream fi=new FileOutputStream("D:\\coupledata.xls");
       FileOutputStream fi=new FileOutputStream(System.getProperty("user.dir").toString()+"\\coupledata.xls");
         wb.write(fi);
         fi.close(); 
    }
}


