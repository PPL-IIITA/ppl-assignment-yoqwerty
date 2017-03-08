
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
 *<h2>Class having the main function for q2</h2>
 * @author supreet
 */
public class q2 {
  
    girl g1;boy b1;
  /**
   * main function using functions of classes:randomgenerator,happinesscompat and couples to calculate k happiest and the most compatible couples
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
         hg.run();
         System.out.println("Enter the value of k");
         Scanner s=new Scanner(System.in);
         int k = s.nextInt();
         hg.hapcomp(k);        
     }
}
