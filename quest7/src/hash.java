import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
import jxl.read.biff.BiffException;
/**
 * it finds the the name of boy's gf by using hashing
 * @author supreet
 */
public class hash extends data{
    
    /**
     * hash function used for hashing
     * @param key name of the boy
     * @return 
     */
    public int hashf(String key){
    char[] keys=new char[20];
    keys=key.toCharArray();    
    int k = (int)key.length();
    int u = 0,n = 0;
    for (int i=0; i<k; i++)
    {
        n = (int)keys[i];
        u += 7*n%31;
    }
    return u%139;
    
    }
    /**
     * it finds the the name of boy's gf by using hashing
     * @param boy name of the boy whose gf is to be found
     * @throws IOException
     * @throws BiffException 
     */
    public void hashd(String boy) throws IOException, BiffException{
        read();
        
        String[] g=new String[gi.size()];
        String[] b=new String[bi.size()];
        String[] hasht=new String[5000];
        String[] girl=new String[5000];
        Arrays.fill(hasht, "-1");
        for(int i=0;i<bi.size();i++){
            System.out.println("gi "+bi.size());
        g[i]=(String)gi.elementAt(i);
        b[i]=(String)bi.elementAt(i);
        String key=b[i];
        int ind=hashf(key);
        System.out.println("in "+ind);
        
        
       // String[] g=new String[gi.size()];
        if(hasht[ind]!="-1"){
            while(hasht[ind]!="-1")
                ind++;
        }
        hasht[ind]=key;
        girl[ind]=g[i]; 
    }
      int k=hashf(boy);System.out.println("k "+k);
      while(boy!=hasht[k])
          k++;
      System.out.println("boy: "+boy+" has gf "+girl[k]);
    }
    void hashds(String s)  throws IOException, BiffException{
        array a =new array();
        a.test(s);
    }
}