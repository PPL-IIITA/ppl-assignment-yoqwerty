//q4
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import jxl.Cell;
import jxl.read.biff.BiffException;
/**
 * <h2>Calculates compatibility of couples formed</h2>
 * <h2>Calculates k least happy couples for breakup couples</h2>
 * 
 * @author supreet
 */

public class happinesscompat {
    int m_bud,attrc,intel,m_cost,attrcg,intelg;
    girl g1;boy b1;
    jxl.Sheet girl, boy, couple,giftsheet;
    private jxl.Workbook gdata, bdata, cdata,giftdata;
    public Vector totalhap; public Vector compat,ngirl,nboy;  
    /**
     * <h2>Runs functions ghapp of girl class and runt(),totalcost(),bhapp() of boy class</h2>
     * @throws IOException
     * @throws BiffException 
     */
     public void run() throws IOException, BiffException{
        g1 = new girl();
         g1.ghapp();
         b1 = new boy();
         b1.runt();
         b1.totalcost();
         b1.bhapp();
    }
     /**
      * It calculates the happiness and prints least k happy couples
      * @param k 
      * @throws IOException
      * @throws BiffException 
      */
    public void hapcomp(int k) throws IOException, BiffException{
        String name,n;
        int i,j,h;
        int comp=0,z = 0,y;
        ngirl=new Vector();
        nboy=new Vector();
        totalhap=new Vector();compat=new Vector();//ngirl=new Vector();nboy=new Vector();
        gdata=null; bdata =null;cdata=null;giftdata=null;
        jxl.Cell g,b,c,gift,c2; 
        gdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\gdata.xls"));
        bdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
        cdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
        giftdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\giftdata.xls"));
        girl = gdata.getSheet(0);
        boy = bdata.getSheet(0);
        couple = cdata.getSheet(0);
        giftsheet = giftdata.getSheet(0);
       int zh=99999; 
        for( i=0;i<couple.getRows()-1;i++){
           //System.out.println(b1.hapib.elementAt(i));
            h=(int) g1.hapig.elementAt(i) + (int) b1.hapib.elementAt(i);
            totalhap.add(h);
        }
     
        System.out.println("least t happiest couples now are as following ");
        Vector count = new Vector();
        int l;
      //  System.out.println(totalhap.size()+" "+couple.getRows());
        for(i=0;i<k && i<totalhap.size();i++){
             zh = 99999;
        for(l=0;l<totalhap.size();l++){
            if(zh>(int)totalhap.elementAt(l) && !count.contains(l) ){
                z=l;
                zh=(int)totalhap.elementAt(l);
            } 
        }
       // System.out.println("z "+z+" "+zh);
           count.add(z);
            c=couple.getCell(0,z+1);
            c2=couple.getCell(1,z+1);
            System.out.print("girl=  "+c.getContents()+"  ");
            ngirl.add(c.getContents());
            System.out.print("boy=   "+c2.getContents()+"  ");
            nboy.add(c2.getContents());
            //totalhap.add(z,9999);
            System.out.println();
           // z++;
        }
    }
}
