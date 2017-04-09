/*q2
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import java.util.Vector;
import jxl.read.biff.BiffException;
/**
 * <h2>Calculates the happiness of different girls from the couples formed</h2>
 * 
 */

public class girl{
    String gname;
    int attrc;
    int m_cost;
    int intl;
    int criteria; // 1 for richness    2 for intelligence    3 for attractiveness
    int natureg;   // 1 for choosy      2 for normal          3 for desperate
    private jxl.Workbook gdata, bdata, cdata,giftdata;
    
     boy bu;giftingnew gft=new giftingnew();
    // public Vector hapig;
     /**
      * Read the data from Excel Sheets for girls,boys,couples formed and gifts and calculates the happiness of girls accordingly
      * @param costrec
      * @param valrec
      * @param luxrec
      * @param hapig
      * @throws IOException
      * @throws BiffException 
      */
     public void ghapp(Vector costrec,Vector valrec,Vector luxrec,Vector hapig) throws IOException, BiffException{
       // hapig=new Vector();
         bu=new boy();
         int hap;
        // gft.totalcost();
        int i,j,z;
        String n;
        jxl.Sheet girll, boy, couple,giftsheet;
        gdata=null; bdata =null;cdata=null;giftdata=null;
        jxl.Cell g,b,c,gift; 
        gdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\gdata.xls"));
        bdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
        cdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
        giftdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\giftdata.xls"));
        girll = gdata.getSheet(0);
        boy = bdata.getSheet(0);
        couple = cdata.getSheet(0);
        giftsheet = giftdata.getSheet(0);
        z=1;
        for( i=0;i<couple.getRows()-1;i++,z++){
           c=couple.getCell(0,z);//getting girl name from couple data
           gname=c.getContents();
           for(j=1;j<=girll.getRows();j++){//finding that name in girl data
                g=girll.getCell(0,j);
                n=g.getContents();
                if(gname.equals(n)){
                    break;
                }
            }
            g=girll.getCell(5,j);//getting nature of girl
            natureg= new Integer(Integer.parseInt(g.getContents()));
            g=girll.getCell(2,j);//getting budget of girl
            m_cost=new Integer(Integer.parseInt(g.getContents()));
           
            if(natureg==1){
                hap=(int) (Math.log10((int) costrec.elementAt(i)-m_cost)+2*((int)luxrec.elementAt(i)));
               // System.out.println(hap  + "n=1");
            }
            else if(natureg==2){
                hap=Math.abs((int)costrec.elementAt(i)- (int)valrec.elementAt(i)- m_cost);
               // System.out.println(hap  + "n=2");
            }
            else{
              //  System.out.println("bu_costrec= " + (int)bu.costrec.elementAt(i));
               // System.out.println("m_cost= " + m_cost);
                int now;
                if(Math.exp( (int)costrec.elementAt(i) - m_cost ) > 10000)
                    now = 10000;
                else 
                    now = (int) Math.exp( (int)costrec.elementAt(i) - m_cost );
                hap=now;
           // System.out.println(hap + "n=3");
            }
            hapig.add(hap);
          //  System.out.println("hiii");
            
        }
    }
}
    

