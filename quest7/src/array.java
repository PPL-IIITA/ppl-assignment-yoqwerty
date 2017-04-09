import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import jxl.read.biff.BiffException;
/**
 * Inherits data class in which the information about couples from Excel sheet is extracted
 * Stores the committed boys in array and performs linear search to find his gf
 * @author supreet
 */
public class array extends data{
    /**
     * takes 
     * @param n name of the boy whose gf is to be found
     * @throws IOException
     * @throws BiffException 
     */
    public void test(String n) throws IOException, BiffException{
        read();
        int i;
        String[] g=new String[gi.size()];
        String[] b=new String[bi.size()];
        for( i=0;i<bi.size();i++){
            g[i]=(String)gi.elementAt(i);
            b[i]=(String)bi.elementAt(i);
        }
        for( i=0;i<gi.size();i++){
            if(n.equals(b[i])){
                System.out.println("boy- "+n+" 's gf- "+g[i]);
                break;
            }
            
        }
        if (i==gi.size())
        System.out.println(n+ " has "+" no gf ");
       
    }
}
