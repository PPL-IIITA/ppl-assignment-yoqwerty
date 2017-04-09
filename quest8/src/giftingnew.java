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
public class giftingnew{
    
    String name;
    int attrc,m_bud,intl,natureb,hapb=0;// 1=miser  2=geek  3=generous
    private jxl.Workbook gdata, bdata, cdata,giftdata;
    public Vector hapib;
    girl g;
    public Vector costrec=new Vector();public Vector valrec=new Vector();public Vector luxrec=new Vector();
   /**
     * It sort the gifts 
     * @param p1 array of price of gifts
     * @param v array of value of gifts
     * @param k (as mentioned in the question)
     */
    public void sort(int p1[],int v[],int k) throws IOException, BiffException{
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
    /**
     * <h2>Calculates the total cost of gifts bought by different boys for their gfs</h2>
     * Checks the nature of bfs and thus stores the cost and value of the gifts bought.Also stores if the boy has bought luxury gift or not
     * @param costrec vector storing money spent on buying gifts
     * @param valrec vector storing value of gifts bought
     * @param luxrec vector maintaining record about no of luxury gifts bought
     * @throws IOException
     * @throws BiffException 
     */        
    public void totalcost(Vector costrec,Vector valrec,Vector luxrec) throws IOException, BiffException{
       //System.out.println("in totalcost");
        //valrec=new Vector();
        //costrec=new Vector();
        //luxrec=new Vector();
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
                tot_cost+=p1[li]+p2[li]+p3[li];tot_val+=v1[li]+v2[li]+v3[li];
                luxury+=v3[li++];luxrec.add(luxury);
                while(tot_cost<=g_cost){
                tot_cost+=p1[li]; tot_val+=v2[li];
                if(tot_cost<=g_cost)
                    tot_cost+=p2[li]; tot_val+=v2[li];
                if(tot_cost<=g_cost){
                    tot_cost+=p3[li];tot_val+=v2[li];luxury+=v3[li];luxrec.add(luxury);
                }
                else luxrec.add(0);
                li++;
                }
            }
            else if(natureb==2 ){
                tot_cost+=p1[k]+p2[k]+p3[k];tot_val+=v1[k]+v2[k]+v3[k];
                luxury+=v3[k--];luxrec.add(luxury);
                while(tot_cost<=m_bud){
                    tot_cost+=p1[k]; tot_val+=v2[k];
                if(tot_cost<=m_bud)
                    tot_cost+=p2[k]; tot_val+=v2[k];
                if(tot_cost<=m_bud){
                    tot_cost+=p3[k];tot_val+=v2[k];luxury+=v3[k];luxrec.add(luxury);
                }
                else luxrec.add(0);
                k--;
                }  
            }
            else{    
                tot_cost+=p1[li]+p2[li]+p3[li];tot_val+=v1[li]+v2[li]+v3[li];
                luxury+=v3[li++];luxrec.add(luxury);
                while(tot_cost<=g_cost){
                tot_cost+=p1[li]; tot_val+=v2[li];
                if(tot_cost<=g_cost)
                    tot_cost+=p2[li]; tot_val+=v2[li];
                if(tot_cost<=g_cost){
                    tot_cost+=p3[li];tot_val+=v2[li];luxury+=v3[li];luxrec.add(luxury);
                }
                else luxrec.add(0);
                li++;
                }
            }
        
            costrec.add(tot_cost);
            //System.out.println(tot_cost);
            valrec.add(tot_val);
            //System.out.println(tot_val);
         
        }     
    }
}