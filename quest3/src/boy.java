
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import jxl.read.biff.BiffException;

/**
 *<h2> It is an abstract class consisting of abstract method to find happiness of boys </h2>
 * 
 */
    abstract public class boy {
         String bname; //boy name
         int attr; //attractiveness
	 int intel; //intelligence
	 int bud; //budget of boy
	 int reqd_at; //required attractiveness
         int nat; //nature
         int happ; //happiness
         int luxrec,valrec,costrec;
    /**
     * <h2> Abstract method to calculate happiness of boy </h2>
     * 
     * @param g girl object
     * @param m maintenance cost of girl
     * @throws IOException
     * @throws BiffException 
     */     
        abstract public void bhapp(girl g,int m) throws IOException, BiffException;
    /**
     * <h2> Abstract method to calculate total money spent on gifts by boys for their girlfriends </h2>
     * 
     * @param g girl object
     * @param gft object of type gift
     */
        abstract public void tot_cost(girl g,gift gft);
}
