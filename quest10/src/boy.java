import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import jxl.read.biff.BiffException;

/**
 * calculates the total money spent by different types of boys on gifting 
 * @author supreet
 */

     public class boy {
         String bname;
         int attr;
	 int intel;
	 int bud;
	 int reqd_at;
         int nat;
         int happ; 
         int commit;
         int luxrec,valrec,costrec;
        /**
         * calculates the total money spent on gifting
         * 
         * @param g object of type girl
         * @param gft object of type gift
         */   
        public void tot_cost(girl g,gift gft){
        int tc=0;
        int luxury=0;
        if(nat==1){
        while(tc<=bud){
                tc+=gft.price;
                valrec+=gft.val;
                if(gft.type==3){
                luxury+=gft.val;
                luxrec=luxury;
                }
                else luxrec=0;
                
                }
        }
        else if(nat==2){
        while(tc<=bud){
                tc+=gft.price;
                valrec+=gft.val;
                if(gft.type==3){
                luxury+=gft.val;
                luxrec=luxury;
                }
                else luxrec=0;
                
                }
        
        }
        else{
            while(tc<=bud){
                tc+=gft.price;
                valrec+=gft.val;
                if(gft.type==3){
                luxury+=gft.val;
                luxrec=luxury;
                }
                else luxrec=0;
                
        }
        
        luxury+=gft.val;
        luxrec=luxury;
    }
        
  }
}   
    
    
        
    

