
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
/**
 * Abstract girl class with abstract method of calculating happiness of girls
 * @author supreet
 */
abstract public class girl {
    String gname;
    int att;int hap;
    int intg;
    int mc;
    int criteria;
    int nat; 
    /**
     * Abstract method to calculate happiness of girl
     * @param boyob boy object
     * 
     *
     */
    abstract public void ghapp(boy boyob,int m_c );
}
