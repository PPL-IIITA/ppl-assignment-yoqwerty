
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import jxl.read.biff.BiffException;
 /**
 * <h2> It inherits the boy class and override its abstract bhapp() function and tot_cost() function </h2>
 * @author supreet
 */
public class miser_b extends boy { 
        /**
         * It calculates boy's happiness by overriding bhapp() function of boy class 
         * 
         * @param g girl object
         * @param m_bud budget of boy
         * @throws IOException
         * @throws BiffException 
         */
   
    public void bhapp(girl g,int m_bud) throws IOException, BiffException{
        
        happ=(int)m_bud-(int)costrec;
        
    }
    /**
     * It calculates total money spent on gifts for their gf
     * 
     * @param g girl object
     * @param gft gift object
     */
    public void tot_cost(girl g,gift gft){
        int tc=0;
        int luxury=0;
        while(tc<=g.mc){
                tc+=gft.price;
                valrec+=gft.val;
                if(gft.type==3){
                luxury+=gft.val;
               luxrec=luxury;
                }
                else luxrec=0;
                
                }
        }
}   
    

