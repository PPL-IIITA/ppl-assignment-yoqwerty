/**
 * generic class 
 * @author supreet
 * @param <T> 
 */
public class gener <T>{
    /**
     * Generic method to find best 'k' valued items
     * @param <T> Class type
     * @param obj Object of class type 'T'
     * @param a Array to contain values on whose basis sorting is done
     * 
     */
    public <T> void get(int[] a,T[] obj){
       int tmp;T tmp1;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(a[j]>a[j+1]){
                    tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    tmp1=obj[j];
                    obj[j]=obj[j+1];
                    obj[j+1]=tmp1;                   
                }  
            }  
        }
    }
}
