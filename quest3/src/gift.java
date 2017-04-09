import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import jxl.read.biff.BiffException;
/**
 * <h2> Stores the gifts after sorting them according to their price and value </h2>
 * @author supreet
 */
public class gift{
    
    int type;
    int price;int val;
    int attrc,m_bud,intl,natureb,hapb=0;// 1=miser  2=geek  3=generous
    private jxl.Workbook gdata, bdata, cdata,giftdata;
    public Vector hapib;
    girl g;
   /**
    * Performs sorting of gift objects 
    * @param p1 array of price of gifts
    * @param v array of values of gifts
    * @param k value of k(as asked in que)
    */
    public void sort(int p1[],int v[],int k){
        int i,j;
        for(i=0;i<k;i++){//sorting gift price and value
            for(j=0;j<k;j++){           
                if(p1[j]>p1[j+1]){
                    int temp=p1[j];
                    p1[j]=p1[j+1];
                    p1[j+1]=temp;
                    temp=v[j];
                    v[j]=v[j+1];
                    v[j+1]=temp;
                }
            }
        }
    }
            
    public void totalcost(boy[] boyob) throws IOException, BiffException{
        int j, jj,i,k=0,z,tot_cost,tot_val,li,lg,gp,gv,g_cost;
        gdata=null; bdata =null;cdata=null;giftdata=null;
        String n,name;
        jxl.Sheet girll, boy, couple,giftsheet;
        jxl.Cell g,b,c,gift; 
        gdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\gdata.xls"));
        bdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
        cdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
        giftdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\giftdata.xls"));
        girll = gdata.getSheet(0);
        boy = bdata.getSheet(0);
        couple = cdata.getSheet(0);
        giftsheet = giftdata.getSheet(0);
        int[] p1 = new int[giftsheet.getRows()+100];
        int[] v1 = new int[giftsheet.getRows()+100];
        int[] p2 = new int[giftsheet.getRows()+100];
        int[] v2 = new int[giftsheet.getRows()+100];
        int[] p3 = new int[giftsheet.getRows()+100];
        int[] v3 = new int[giftsheet.getRows()+100];
        
        for(int l=1;l<giftsheet.getRows();l++){                
                g=giftsheet.getCell(0,l);
                gp= new Integer(Integer.parseInt(g.getContents()));
                p1[k]=gp;      //making array of price
                g=giftsheet.getCell(1,l);
                gv= new Integer(Integer.parseInt(g.getContents()));
                v1[k]=gv;       //making array of value
                g=giftsheet.getCell(2,l);
                gp= new Integer(Integer.parseInt(g.getContents()));
                p2[k]=gp;
                g=giftsheet.getCell(3,l);
                gv= new Integer(Integer.parseInt(g.getContents()));
                v2[k]=gv;       //making array of value
                g=giftsheet.getCell(4,l);
                gp= new Integer(Integer.parseInt(g.getContents()));
                p3[k]=gp;
                g=giftsheet.getCell(3,l);
                gv= new Integer(Integer.parseInt(g.getContents()));
                v3[k++]=gv;
        }
        sort(p1,v1,k);sort(p2,v2,k);sort(p3,v3,k);
    }
}
