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
    public Vector costrec,valrec,luxrec,hapib;
    girl gi=new girl();
    
   /**
    * runs the ghapp function of class girl
    * @throws FileNotFoundException
    * @throws IOException
    * @throws BiffException 
    */
    public void runt()throws FileNotFoundException, IOException, BiffException{
       gi.ghapp();
       
    }
    /**
     * <h2>Calculates the total cost of gifts bought by different boys for their gfs</h2>
     * Checks the nature of bfs and thus stores the cost and value of the gifts bought.Also stores if the boy has bought luxury gift or not
     * @throws IOException
     * @throws BiffException 
     */        
    public void totalcost() throws IOException, BiffException{
       
        valrec=new Vector();
        costrec=new Vector();
        luxrec=new Vector();
        int j,i,k=0,z,tot_cost,tot_val,li,lg,gp,gv,g_cost;
        gdata=null; bdata =null;cdata=null;giftdata=null;
        String n,nameg;
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
        int[] p = new int[giftsheet.getRows()+100];
        int[] v = new int[giftsheet.getRows()+100];
        for(int l=1;l<giftsheet.getRows();l++){                
                g=giftsheet.getCell(0,l);
                gp= new Integer(Integer.parseInt(g.getContents()));
                p[k]=gp;      //making array of price
                g=giftsheet.getCell(1,l);
                gv= new Integer(Integer.parseInt(g.getContents()));
                v[k++]=gv;       //making array of value 
        }
        for(i=0;i<k;i++){//sorting gift price and value
            for(j=0;j<k;j++){           
                if(p[j]>p[j+1]){
                    int temp=p[j];
                    p[j]=p[j+1];
                    p[j+1]=temp;
                    temp=v[j];
                    v[j]=v[j+1];
                    v[j+1]=temp;
                }
            }
        }
        z=1;
        for(i=0;i<couple.getRows()-1;i++,z++){    //GIFT DECIDING
            li=0;tot_cost=0;tot_val=0;        
            c=couple.getCell(1,z);              //getting boy name from couple data
            name=c.getContents();
            for( j=1;j<boy.getRows();j++){     //finding that name in boy data
                b=boy.getCell(0,j);
                n=b.getContents();
                if(name.equals(n)){
                    break;
                }
            }
            int luxury =0;
            b=boy.getCell(4,j); //getting nature of boy
            natureb= new Integer(Integer.parseInt(b.getContents()));
            b=boy.getCell(2,j); //getting budget of boy
            m_bud=new Integer(Integer.parseInt(b.getContents()));
            c=couple.getCell(0,z);  //getting girl name from couple data
            name=c.getContents();
             for( j=1;j<girll.getRows();j++){//for finding committed girls data
                g=girll.getCell(0,j);
                n=g.getContents();
                if(name.equals(n)){
                    break;
                }
            }  
             g=girll.getCell(2,j);//girls m_cost
             g_cost= new Integer(Integer.parseInt(g.getContents()));
            if(natureb==1){     
                while(tot_cost<=g_cost){
                tot_cost+=p[li];
                tot_val+=v[li];
                if(p[li]>1500){
                    luxury+=v[li];
                    luxrec.add(luxury);
                }
                else luxrec.add(0);
                
                li++;
                }
              
            }
            else if(natureb==2 ){
                while(tot_cost<=m_bud){
                tot_cost+=p[li];  
                tot_val+=v[li];
                if(p[li]>1500){
                    luxury+=v[li];
                    luxrec.add(luxury);
                }
                else luxrec.add(0);
                li++;
                }  
                
            }
            else{    
                while(tot_cost<=g_cost){
                tot_cost+=p[li];  
                tot_val+=v[li];
                if(p[li]>1500){
                    luxury+=v[li];
                    luxrec.add(luxury);
                }
                else luxrec.add(0);
                li++;
                }    
                if(m_bud>tot_cost){
                    while(p[li]<1500 && li < giftsheet.getRows())
                        li++;
                    luxury+=v[li];}
                     else luxrec.add(0);
        }
            costrec.add(tot_cost);
            //System.out.println(tot_cost);
            valrec.add(tot_val);
            //System.out.println(tot_val);
         
        }     
    }
    /**
     * <h2>Calculates the happiness of boys and stores it in a vector</h2>
     * @throws IOException
     * @throws BiffException 
     */
     public void bhapp() throws IOException, BiffException{
         int j,i,z,k=0;
        
       //  gi.hapig=new Vector();
       hapib = new Vector();
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
              hapb=(int)(gi.hapig.elementAt(i));
          }
   
         hapib.add(hapb);
      
     }      
     }   
    }
   
        
        

    
    

