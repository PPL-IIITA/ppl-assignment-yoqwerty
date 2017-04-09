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
 *Class having main function of the question
 * @author supreet
 */
public class q3 {
    /**
     * Main function 
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
         couples co=new couples();
         co.read();
         dataa d=new dataa();
         System.out.println("value of k? ");
         Scanner s=new Scanner(System.in);
         int k = s.nextInt();
         d.run(k);
        
    }
}
