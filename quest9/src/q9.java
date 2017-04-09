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
 * class having main function for q9
 * @author supreet
 */
public class q9{
    /**
     * main function
     * @param args 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws BiffException 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, BiffException{
       
         randomgenerator ri=new randomgenerator();
         ri.writegirl();
         ri.writeboy();
         ri.writegift();
         couples c=new couples();
         c.read();
         dataa d=new dataa();
         /*System.out.println("value of k? ");
         Scanner s=new Scanner(System.in);
         int k = s.nextInt();*/
         d.run(5);
        
    }
}
