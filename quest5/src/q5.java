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
 *<h2>Class having the main function for q5</h2>
 * @author supreet
 */
public class q5 {
  
    girl g1;boy b1;
  /**
   * main function using functions of classes:randomgenerator,happinesscompat and couples to calculate k happiest couples.
   * Gives choice to user to choose the new allocating method(alternatively choosing by boys and girls)
   * @param args
   * @throws FileNotFoundException
   * @throws IOException
   * @throws BiffException 
   */
     public static void main(String[] args) throws FileNotFoundException, IOException, BiffException{
       
         randomgenerator ri=new randomgenerator();
         couples cop=new couples();
         couples_1 cop1=new couples_1();
         ri.writegirl();
         ri.writeboy();
         ri.writegift();
         Random r=new Random();
        // happinesscompat hg=new happinesscompat();
         happinesscompat h=new happinesscompat();
         //hg.run();
        /* System.out.println("Enter the value of k");
         Scanner s=new Scanner(System.in);
         int k = s.nextInt();*/
        int l=1; int hi=3;
        int c=r.nextInt(hi-l)+l;
         System.out.println(" 1 for old algo 2 for new algo");
        /* Scanner s1=new Scanner(System.in);
         int c = s1.nextInt();*/
         System.out.println("couples formed are ");
         System.out.println("choosen option "+c +" randomly");
         if(c==2)
             cop.read();
         else 
             cop1.read();
           h.run();
           h.hapcomp(5);  
    }
         
}        
