import java.io.*;
public class RandomFileDemo{
    private static final String rwFileName = "./employee.txt" ;
    public static void main(String[] args) {
        
        Employee e1 = new Employee("zhangsan", 23) ;
        Employee e2 = new Employee("lisi", 24) ;
        Employee e3 = new Employee("wangwu", 25) ;

        try {
            RandomAccessFile ra = new RandomAccessFile(rwFileName, "rw") ;
        
            ra.write(e1.name.getBytes());
            ra.writeInt(e1.age);
    
            ra.write(e2.name.getBytes());
            ra.writeInt(e2.age);
    
            ra.write(e3.name.getBytes());
            ra.writeInt(e3.age);
    
            ra.close();
    
            RandomAccessFile raf = new RandomAccessFile(rwFileName, "r") ;
            int len = 8 ;
    
            raf.skipBytes(12) ; //跳过第一个员工的信息，姓名8自己， 年龄4字节
            System.out.println("第二个员工的信息");
            String str = "" ;
    
            for( int i = 0; i < len; i++){
                str = str + raf.readByte() ;
            }
    
            System.out.println("name :" + str);
            System.out.println("age :" + raf.readInt()) ;
    
            System.out.println("第一个员工的信息") ;
            raf.seek(0); // 移动文件指针到文件的开始处
    
            str = "" ;
    
            for( int i = 0; i < len; i++){
                str = str +  (char)raf.readByte() ;
            }
    
            System.out.println("name :" + str);
            System.out.println("age :" + raf.readInt()) ;
    
            System.out.println("第三个员工的信息") ;
            raf.seek(12);
    
            str = "" ;
    
            for( int i = 0; i < len; i++){
                str = str + raf.readByte() ;
            }
    
            System.out.println("name :" + str);
            System.out.println("age :" + raf.readInt()) ;
    
            raf.close();
        } catch (IOException e) {
            System.out.println("exception :" + e.getMessage());
        }

    }
}

class Employee{
    String name ;
    int age ;
    final static int LEN = 8 ;

    public Employee(String name, int age){
        if(name.length() > LEN){
            name = name.substring(0, 8);
        }else{
            while( name.length()< LEN){
                name += "\u0000" ;
            }
        }
        this.name = name ;
        this.age = age ;
    }
}