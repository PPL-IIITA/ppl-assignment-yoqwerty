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
    jxl.Sheet s1,s2,c,s4;
    jxl.Workbook bdata,gdata,coupledata,giftdata;jxl.Cell cell;
    String sa,sb,couple ;int v1;
    
   boy[] boyob=new boy[100];
   girl[] girlob=new girl[100];
   gift[] gf=new gift[100];
    /**
     * Reads bdata Excel sheet and stores the boy's information in array of boy objects
     * @throws IOException
     * @throws BiffException 
     */
    void getdata_b() throws IOException, BiffException{
    bdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
    s1 = bdata.getSheet(0);
        for(int i = 1; i<s1.getRows(); i++){
          cell = s1.getCell(0, i);
          sa=cell.getContents();
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
    /**
     * Reads giftdata Excel sheet and stores the gift 's information in array of gift objects
     * @param gi vector 
     * @param val vector
     * @throws IOException
     * @throws BiffException 
     */
    void getdata_gi(Vector gi,Vector val) throws IOException, BiffException{
    giftdata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\giftdata.xls"));
    s4 = giftdata.getSheet(0);
     for(int i = 1; i<s4.getRows(); i++){
        cell = s4.getCell(1, i);
        v1=new Integer(Integer.parseInt(cell.getContents()));
        gf[i].price=v1;
        cell = s4.getCell(1, i);
        v1=new Integer(Integer.parseInt(cell.getContents()));
        gf[i].val=v1;
                    
        }
    }/**
     * It reads the coupledata Excel sheet formed after couple formation and store them into required vectors
     * @param cg vector name
     * @param cb vector name
     * @throws IOException
     * @throws BiffException 
     */
    void getdata_c(Vector cg,Vector cb) throws IOException, BiffException{
    coupledata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
     c= coupledata.getSheet(0);
     for(int i = 1; i<c.getRows(); i++){
        cell = c.getCell(0, i);
        couple=cell.getContents();
        cg.addElement(couple);
        cell = c.getCell(0, i);
        couple=cell.getContents();
        cb.addElement(couple); 
    }
  }
   
    public void run(int k) throws IOException, BiffException{
        dataa d =new dataa();
        d.out(k);
       // test(k);
    }
   
    public void out(int k) throws IOException, BiffException{
        System.out.println("k happiest couple ");
         coupledata= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
         c=coupledata.getSheet(0);
        int[] f=new int[k+1];Random r=new Random();
        int h=k+1;int l=1;
        for(int i=0;i<k+1;i++)
            f[i]=-1;
        for(int i=0;i<k;i++){
         int no=r.nextInt(h-l)+l;
        
            while(f[no]!=-1)
                no=r.nextInt(h-l)+l;
            
            cell=c.getCell(0,no);
            System.out.print("girl "+cell.getContents());
            cell=c.getCell(1,no);
            System.out.println(" boy "+cell.getContents());
            f[no]=999;
        }
    }
    /**
     * It is to run the required functions
     * @param k
     * @throws IOException
     * @throws BiffException 
     */
    public void test(int k) throws IOException, BiffException{
     gift gf=new gift(); int j,i;  String n;int ng,m_cost;
    gf.totalcost(boyob);
     for( i=1;i< c.getRows();i++){
          cell=s1.getCell(1,i);//getting boy name from couple data
            String name=cell.getContents();
            for( j=1;j<=s1.getRows();j++){//finding that name in boy data
                cell=s1.getCell(0,j);
                n=cell.getContents();
                if(name.equals(n)){
                    break;
                }
            }
            int bi=j;
           cell=c.getCell(0,i);//getting girl name from couple data
          String  gname=cell.getContents();
           for(j=1;j<=s2.getRows();j++){//finding that name in girl data
                cell=s2.getCell(0,j);
                n=cell.getContents();
                if(gname.equals(n)){
                    break;
                }
            }
        cell=s2.getCell(5,j);//getting nature of girl
        ng= new Integer(Integer.parseInt(cell.getContents()));
        cell=s2.getCell(2,j);//getting budget of girl
        m_cost=new Integer(Integer.parseInt(cell.getContents()));
        choosy_g ch=new choosy_g();  normal_g no=new normal_g(); desp_g dp=new desp_g();      
         if(ng==1)
            ch.ghapp(boyob[bi],m_cost);
         else if(ng==2)
             no.ghapp(boyob[bi], m_cost);
         else dp.ghapp(boyob[bi], m_cost);
    }
    
    
    for( i=1;i<c.getRows();i++){    //GIFT DECIDING
           
            cell=c.getCell(1,i);//getting boy name from couple data
            String name=cell.getContents();
            for( j=1;j<=s1.getRows();j++){//finding that name in boy data
                cell=s1.getCell(0,j);
                n=cell.getContents();
                if(name.equals(n)){
                    break;
                }
            }
          
            cell=s1.getCell(4,j);//getting nature of boy
           int nb= new Integer(Integer.parseInt(cell.getContents()));
            cell=s1.getCell(2,j);//getting budget of boy
           int m_bud=new Integer(Integer.parseInt(cell.getContents()));
            
            cell=c.getCell(0,i);//getting girl name from couple data
            name=cell.getContents();
             for( j=1;j<=s2.getRows();j++){//for finding committed girls data
                cell=s2.getCell(0,j);
                n=cell.getContents();
                if(name.equals(n)){
                    break;
                }
            }
           cell=s2.getCell(3,j);//girls intelligence
           int intelg= new Integer(Integer.parseInt(cell.getContents()));
           miser_b mb=new miser_b();geeky_b gk=new geeky_b();generous_b gn=new generous_b();
          if(nb==1){
              mb.bhapp(girlob[j],m_bud);
             
          }
          else if(nb==3){
              boyob[i].happ=intelg;  
          }
          else{
             gn.bhapp( girlob[j], m_bud);
             
          }
   
       }
    //happcomp hp=new happcomp();
   // hp.hapcomp(boyob, girlob, k);
    
    }
}


