
import java.io.* ;

public class Copy3{
    final static String ReadFile = "./readfile" ;
    final static String WriteFile = "./writefile" ;
    final static int BufSize = 1024 * 1024 ;
    public static void main(String[] args) {
        int n = 0 ;
        try {
            FileInputStream fis = new FileInputStream(ReadFile) ;
            FileOutputStream fos = new FileOutputStream(WriteFile) ;
            byte[] bs = new byte[BufSize] ;

            while( ( n = fis.read(bs)) != 1){
                fos.write(bs, 0, n) ;
            }

            fis.close() ;
            fos.close() ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
}