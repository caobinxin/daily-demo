import java.io.*;
public class FileDemo{
    static String readFileName = "./test";

    public static void main(String[] args) {
        File f = new File(readFileName);
        if(f.exists()){
            f.delete();
        }else{
            try {
                f.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println(f.getName());
            System.out.println(f.getPath());
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getParent() + " 父目录");
            System.out.println(f.canWrite());
            System.out.println(f.canRead());
            System.out.println(f.isDirectory());
            System.out.println(f.isFile());
            System.out.println(f.isAbsolute()?"是绝对路径":"不是绝对路径");
            System.out.println(f.lastModified());
            System.out.println(f.length() + " Bytes");
           
        }

        
    }
}