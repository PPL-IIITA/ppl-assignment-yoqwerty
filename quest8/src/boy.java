//q8
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
 * <h2>Calculates happiness of different boys and total cost of gifts bought by them for their gfs</h2>
 * @author supreet
 */
public class boy{
    
    String name;
    int attrc,m_bud,intl,natureb,hapb=0;// 1=miser  2=geek  3=generous
    private jxl.Workbook gdata, bdata, cdata,giftdata;
    //public Vector hapib;
    girl gi=new girl();
 
   /**
    * <h2>Calculates the happiness of boys and stores it in a vector</h2>
    * @param costrec vector:stores the total money spent on buying gifts
    * 
    * @param hapib vector:stores the happiness of girls
    * @throws IOException
    * @throws BiffException 
    */
     public void bhapp(Vector costrec,Vector hapig,Vector hapib) throws IOException, BiffException{
         int j,i,z,k=0;
        gdata=null; bdata =null;cdata=null;giftdata=null;
        String n;
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
         z=1;
         for( i=0;i<couple.getRows()-1;i++,z++){    //GIFT DECIDING
           
            c=couple.getCell(1,z);//getting boy name from couple data
            name=c.getContents();
            for( j=1;j<=boy.getRows();j++){//finding that name in boy data
                b=boy.getCell(0,j);
                n=b.getContents();
                if(name.equals(n)){
                    break;
                }
            }
          
            b=boy.getCell(4,j);//getting nature of boy
            natureb= new Integer(Integer.parseInt(b.getContents()));
            b=boy.getCell(2,j);//getting budget of boy
            m_bud=new Integer(Integer.parseInt(b.getContents()));
            
            c=couple.getCell(0,z);//getting girl name from couple data
            name=c.getContents();
             for( j=1;j<=girll.getRows();j++){//for finding committed girls data
                g=girll.getCell(0,j);
                n=g.getContents();
                if(name.equals(n)){
                    break;
                }
            }
           g=girll.getCell(3,j);//girls intelligence
           int intelg= new Integer(Integer.parseInt(b.getContents()));
          if(natureb==1){
              
              hapb=(int)m_bud-(int)costrec.elementAt(i);
             
          }
          else if(natureb==2){
              hapb=intelg;
              
          }
          else{
              //System.out.println("nullo"+gi.hapig.elementAt(i));
              hapb=(int)(hapig.elementAt(i));
          }
   
         hapib.add(hapb);
         
     }
        // System.out.println("hapib_"+hapib.size());
     }   
    }
   
        
        

    
    

