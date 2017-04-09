import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
/**
 * calculates happiness of girls 
 * @author supreet
 */
public class girl {
    String gname;
    int att;int hap;
    int intg;
    int mc;
    int criteria;
    int commit;
    int nat; 
    /**
     * calculates happiness of girls according to their nature
     * @param boyob object of type boy
     * 
     */
    public void ghapp(boy boyob,int m_cost) {
        int happ;
        if(nat==1){
        happ=(int) (Math.log10((int) boyob.costrec-m_cost)+2*boyob.luxrec);
        hap=happ;
        }
        else if(nat==2){
            happ=Math.abs((int)boyob.costrec- (int)boyob.valrec- m_cost);
            hap=happ;
        }
        else{
             int now;
                if(Math.exp( (int)boyob.costrec - m_cost ) > 10000)
                    now = 10000;
                else 
                    now = (int) Math.exp( (int)boyob.costrec - m_cost );
                happ=now;
        hap=happ;
        }
    }
}
