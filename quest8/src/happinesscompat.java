 /*q8
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 * <h2>Calculates k happiest and the most compatible couples</h2>
 * 
 * @author supreet
 */

public class happinesscompat  {
    int m_bud,attrc,intel,m_cost,attrcg,intelg;
    girl g1=new girl();boy b1=new boy();giftingnew gft=new giftingnew();gifting gft1=new gifting();
    jxl.Sheet girl, boy, couple,giftsheet;
    private jxl.Workbook gdata, bdata, cdata,giftdata;
    public Vector hapig=new Vector();public Vector hapib=new Vector(); 
    public Vector totalhap; public Vector compat; public Vector costrec=new Vector();public Vector valrec=new Vector();public Vector luxrec=new Vector();  
    /**
     * <h2>Runs the old and new method of gift allocation depending upon the randomly generated number</h2>
     * @param k (as mentioned in the que)
     * @param c number generated randomly in main function to choose from old and new method of allocation
     * @throws IOException
     * @throws BiffException 
     */
     public void run(int k,int c) throws IOException, BiffException{
        
       
        if(c==0)
        gft.totalcost( costrec,valrec,luxrec);
        else
        gft1.totalcost(costrec, valrec, luxrec);
       
        g1.ghapp(costrec,valrec,luxrec,hapig);
        b1.bhapp(costrec,hapig,hapib);
       
        hapcomp(k,hapig,hapib);
    }
     /**
      * It calculates the happiness and compatibility of couples and prints names of k happiest and the most compatible couples
      * @param k (as mentioned in que: k happiest couples)
      * @param hapig vector storing happiness of girls 
      * @param hapib vector storing happiness of boys
      * @throws IOException
      * @throws BiffException 
      */
    public void hapcomp(int k,Vector hapig,Vector hapib) throws IOException, BiffException{
        String name,n;
        int i,j,h;
        int comp=0,z,y;
       // g1=new girl(); b1=new boy();
       // g1.ghapp(); b1.bhapp();
        totalhap=new Vector();compat=new Vector();
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
       // z=1;
        for( i=0;i<couple.getRows()-1;i++){
          // System.out.println("hapib "+hapib.size()+" couplerow "+ couple.getRows());
            h=(int) hapig.elementAt(i) + (int)hapib.elementAt(i);
            totalhap.add(h);
        }
        System.out.println("happiest couples ");
      
        Vector count = new Vector();
        int l,zh,zi=0;
        for(i=0;i<k && i<totalhap.size();i++){
             zh =0;
        for(l=0;l<totalhap.size();l++){
            if(zh<(int)totalhap.elementAt(l) && !count.contains(l) ){
                zi=l;
                zh=(int)totalhap.elementAt(l);
            } 
        }
           count.add(zi);
            c=couple.getCell(0,zi+1);
            c2=couple.getCell(1,zi+1);
            System.out.print("girl=  "+c.getContents()+"  ");
            System.out.print("boy=   "+c2.getContents()+"  ");
            System.out.println();
         
        }
        z=1;
        for( i=0;i<couple.getRows()-1;i++,z++){
            c=couple.getCell(1,z);//getting boy name from couple data
            name=c.getContents();
            for( j=1;j<=boy.getRows();j++){//finding that name in boy data
                b=boy.getCell(0,j);
                n=b.getContents();
                if(name.equals(n)){
                    break;
                }
            }
            b=boy.getCell(1,j);//getting  of boy
            attrc=new Integer(Integer.parseInt(b.getContents()));
            b=boy.getCell(2,j);//getting budget of boy
            m_bud=new Integer(Integer.parseInt(b.getContents()));
            b=boy.getCell(3,j);
            intel=new Integer(Integer.parseInt(b.getContents()));
            
            c=couple.getCell(0,z);//getting boy name from couple data
            name=c.getContents();
             for( j=1;j<=girl.getRows();j++){//for finding committed girls data
                g=girl.getCell(0,j);
                n=g.getContents();
                if(name.equals(n)){
                    break;
                }
            }
             g=girl.getCell(1,j);//getting  of boy
            attrcg=new Integer(Integer.parseInt(g.getContents()));
            g=girl.getCell(2,j);//getting budget of boy
            m_cost=new Integer(Integer.parseInt(g.getContents()));
            g=girl.getCell(3,j);
            intelg=new Integer(Integer.parseInt(g.getContents()));
            comp=m_bud-m_cost +Math.abs(attrc-attrcg)+Math.abs(intelg-intel);
            compat.add(comp);
            
        }
        z=1;
        System.out.println("compatible couples");
      
         Vector count1 = new Vector();
       // int l1,zh
       zi=0;
        //System.out.println(totalhap.size()+" "+couple.getRows());
        for(i=0;i<k && i<compat.size();i++){
             zh =0;
        for(l=0;l<compat.size();l++){
            if(zh<(int)compat.elementAt(l) && !count1.contains(l) ){
                zi=l;
                zh=(int)compat.elementAt(l);
            } 
        }
       // System.out.println("z "+z+" "+zh);
           count1.add(zi);
            c=couple.getCell(0,zi+1);
            c2=couple.getCell(1,zi+1);
            System.out.print("girl=  "+c.getContents()+"  ");
            //ngirl.add(c.getContents());
            System.out.print("boy=   "+c2.getContents()+"  ");
            //nboy.add(c2.getContents());
            //totalhap.add(z,9999);
            System.out.println();
           // z++;
        }
    }
}
