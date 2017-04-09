import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
/**
 * <h2> It inherits the girl class and override its abstract ghapp() function </h2>
 * @author supreet
 */
    public class choosy_g extends girl {
	/**
         * It calculates girl's happiness by overriding ghapp() function of girl class 
         * @param boyob boy object
         * 
         * 
         */
    public void ghapp(boy boyob,int m_cost) {
        int  happ=(int) (Math.log10((int) boyob.costrec-m_cost)+2*boyob.luxrec);
        hap=happ;
}
}
