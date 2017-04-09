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
 *<h2>Class having the main function for q8</h2>
 * @author supreet
 */
public class q8 {
  
    girl g1;boy b1;
  /**
   * main function of q8.It randomly generates a number and accordingly chooses either new or the old method of allocation 
   * 
   * @param args
   * @throws FileNotFoundException
   * @throws IOException
   * @throws BiffException 
   */
     public static void main(String[] args) throws FileNotFoundException, IOException, BiffException{
       
         randomgenerator ri=new randomgenerator();
         couples cop=new couples();
         ri.writegirl();
         ri.writeboy();
         ri.writegift();
         cop.read();
         happinesscompat hg=new happinesscompat();
         Random r=new Random();
         int l=0; int h=2;
         int c=r.nextInt(h-l)+l; 
         if (c==0)
            System.out.println("using old method of allocation");
         else
            System.out.println("using new method of allocation");   
       
        if(c==0) 
            hg.run(5,0);
        else 
            hg.run(5, 1);
       
               
     }
}
