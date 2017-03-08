/*
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

public class happinesscompat {
    int m_bud,attrc,intel,m_cost,attrcg,intelg;
    girl g1;boy b1;
    jxl.Sheet girl, boy, couple,giftsheet;
    private jxl.Workbook gdata, bdata, cdata,giftdata;
    public Vector totalhap; public Vector compat;  
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
      * It calculates the happiness and compatibility of couples and prints names of k happiest and the most compatible couples
      * @param k 
      * @throws IOException
      * @throws BiffException 
      */
    public void hapcomp(int k) throws IOException, BiffException{
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
        z=1;
        for( i=0;i<couple.getRows()-1;i++){
           //System.out.println(b1.hapib.elementAt(i));
            h=(int) g1.hapig.elementAt(i) + (int) b1.hapib.elementAt(i);
            totalhap.add(h);
        }
        System.out.println("happiest couples ");
        Object obj;
        for(i=0;i<k;i++){
            obj=Collections.max(totalhap);
            int ind=totalhap.indexOf(obj);
            c=couple.getCell(0,z);
            c2=couple.getCell(1,z);
            System.out.print("girl=  "+c.getContents()+"  ");
            System.out.print("boy=   "+c2.getContents()+"  ");
            totalhap.add(ind,0);
            System.out.println();
            z++;
        }
        System.out.println();
        System.out.println();
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
        for(i=0;i<k;i++,z++){
            
            obj=Collections.max(compat);
            int ind=compat.indexOf(obj);
            c=couple.getCell(0,z);
            c2=couple.getCell(1,z);
            System.out.print("girl=   "+c.getContents()+"  ");
            System.out.print("boy=    "+c2.getContents()+"  ");
            System.out.print("  ");
            compat.add(ind,0);  
            System.out.println();
        }
    }
}
