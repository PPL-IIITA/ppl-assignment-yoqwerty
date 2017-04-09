import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import jxl.read.biff.BiffException;
/**
 * class having main function for the question
 * @author supreet
 */
public class q7{
    /**
     * main function
     * @param args
     * @throws IOException
     * @throws BiffException 
     */
    public static void main(String args[]) throws IOException, BiffException{
        randomgenerator ri=new randomgenerator();
         couples_1 cop=new couples_1();
        int i;
         ri.writegirl();
         ri.writeboy();
         ri.writegift();
        array a=new array();sortedarr so=new sortedarr();hash h=new hash();
         jxl.Workbook book2;
        book2 =null;
        System.out.println("couples formed are");
        cop.read();
        System.out.println();
       // book= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\coupledata.xls"));
        book2= jxl.Workbook.getWorkbook(new File(System.getProperty("user.dir").toString()+"\\bdata.xls"));
       // jxl.Sheet s1 = book.getSheet(0);
        jxl.Sheet s2 = book2.getSheet(0);
        jxl.Cell cell1;
        Random r=new Random();
        int l=0; int hi=3;
        for(i=0;i<s2.getRows();i++){
            cell1 = s2.getCell(0, i);
            String s=cell1.getContents();
            
            int no=r.nextInt(hi-l)+l;
            if(no==0)
            a.test(s);
            else if(no==1)
            so.sortedarrds(s);
            else
            h.hashds(s);    
        } 
    }
}
