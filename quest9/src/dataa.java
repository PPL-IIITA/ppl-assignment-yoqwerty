import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import jxl.Cell;
import jxl.read.biff.BiffException;
/**
 * <h2> It reads the input from Excel Sheets and stores the details of girls and boys in array of boy objects and girl objects </h2>
 * @author supreet
 */
public class dataa {
    jxl.Sheet s1,s2,c,gg;
    jxl.Workbook bdata,gdata,coupledata,giftdata;jxl.Cell cell;
    String sa,sb,couple ;int v1;
     
    
    boy[] boyob=new boy[100];
    girl[] girlob=new girl[100];
  
     /**
     * Reads bdata Excel sheet and stores the boy's information in array of boy objects
     * @throws IOException
     * @throws BiffException 
     */
    void getdata_b() throws IOException, BiffException{
    bdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
    s1 = bdata.getSheet(0);
    System.out.println("size "+s1.getRows());
        for(int i = 1; i<s1.getRows(); i++){
          cell = s1.getCell(0, i);
          sa=cell.getContents();
          System.out.println(sa);
          boyob[i-1].bname=sa;
          cell = s1.getCell(1, i);
          v1 =new Integer(Integer.parseInt(cell.getContents()));
          boyob[i-1].attr=v1;
          cell = s1.getCell(2, i);
          v1 =new Integer(Integer.parseInt(cell.getContents()));
          boyob[i-1].bud=v1;
          cell = s1.getCell(3, i);
          v1 =new Integer(Integer.parseInt(cell.getContents()));
          boyob[i-1].intel=v1;
          cell = s1.getCell(4, i);
          v1 =new Integer(Integer.parseInt(cell.getContents()));
          boyob[i-1].nat=v1;
          cell = s1.getCell(5, i);
          v1 =new Integer(Integer.parseInt(cell.getContents()));
           boyob[i-1].reqd_at=v1;                  
        }
    }
    /**
     * Reads gdata Excel sheet and stores the girl's information in array of girl objects
     * @throws IOException
     * @throws BiffException 
     */
    void getdata_g() throws IOException, BiffException{
    gdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\gdata.xls"));
    s2 = gdata.getSheet(0);
     for(int i = 1; i<s2.getRows(); i++){
        cell = s2.getCell(0, i);
        sb=cell.getContents();
        girlob[i-1].gname=sb;
        cell = s2.getCell(1, i);
        v1=new Integer(Integer.parseInt(cell.getContents()));
        girlob[i-1].att=v1;
        cell = s2.getCell(2, i);
        v1=new Integer(Integer.parseInt(cell.getContents()));
        girlob[i-1].mc=v1;
        cell = s2.getCell(3, i);
        v1=new Integer(Integer.parseInt(cell.getContents()));
        girlob[i-1].intg=v1;
        
    }
    }
   
    public void run(int k) throws IOException, BiffException{
        //dataa d =new dataa(boyob,girlob);
        boy b=new boy();
        girl g=new girl();
        gift gft=new gift();
        data(k);
        b.tot_cost(g, gft);
        g.ghapp(b, k);
    }

    public void data(int k) throws IOException, BiffException{
        System.out.println("k happiest couples ");
         coupledata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
         giftdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\giftdata.xls"));
         c=coupledata.getSheet(0);
         gg=giftdata.getSheet(0);
        int[] f=new int[k+1];Random r=new Random();
        int h=k+1;int l=1;int l1=1;int h1=30;
        for(int i=0;i<k+1;i++)
            f[i]=-1;
        for(int i=0;i<k;i++){
        int no=r.nextInt(h-l)+l;
        int gf=r.nextInt(h1-l1)+l1;
            while(f[no]!=-1)
                no=r.nextInt(h-l)+l;
            
            cell=c.getCell(0,no);
            System.out.print("girl "+cell.getContents());
            cell=c.getCell(1,no);
            System.out.println(" boy "+cell.getContents());
            cell=gg.getCell(0,gf);
            int v =new Integer(Integer.parseInt(cell.getContents()));
            System.out.println(" gift the girl got are of total price "+v);
            f[no]=999;
            System.out.println();
        }
        System.exit(0);
    }
   
}


