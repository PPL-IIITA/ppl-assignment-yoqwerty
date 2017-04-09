import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import jxl.read.biff.BiffException;
import java.util.Collection;
import java.util.Collections;
/**
 * Inherits data class in which the information about couples from Excel sheet is extracted
 * Stores the committed boys in sorted array and performs binary search to find his gf
 * @author supreet
 */
public class sortedarr extends data{
    /**
     * Stores the committed boys in sorted array and performs binary search to find his gf
     * @param n boy name whose gf is to be searched 
     * @throws IOException
     * @throws BiffException 
     */
    public void sortedarrd(String n) throws IOException, BiffException{
        read();
        
        array a=new array();
        a.test(n);
        
        String[] g=new String[gi.size()];
        String[] b=new String[bi.size()];
        String temp;
       
        for(int i=0;i<bi.size();i++){
            g[i]=(String)gi.elementAt(i);
            b[i]=(String)bi.elementAt(i);
        }
        for (int i = 0; i < bi.size(); i++) 
        {
            for (int j = i + 1; j <bi.size(); j++) 
            {
                if (b[i].compareTo(b[j])>0) 
                {
                   temp = b[i];
                   b[i] = b[j];
                   b[j] = temp;
                   temp = g[i];
                   g[i] = g[j];
                   g[j] = temp;
                }
            }
        }
       /* for(int i=0;i<gi.size();i++){
            if(n.equals(b[i])){
                System.out.println("boy- "+n+" 's gf- "+g[i]);
                break;
            }
            System.out.println("no gf");
        }*/
       binse bn=new binse();
       int index = bn.bsearch(n,b,0, b.length);
		if(index < 0) {
			System.out.println("not found");
		} else {
			System.out.println("found at index " + index);
		}
    }
    void sortedarrds(String s)  throws IOException, BiffException{
        array a =new array();
        a.test(s);
    }
}
