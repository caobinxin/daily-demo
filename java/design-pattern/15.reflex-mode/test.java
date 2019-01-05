import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class test{
    public static void main(String[] args) {

        new Persion();

        try {
            Class clazz = Class.forName("Persion");
            System.out.println("" + clazz.toString());

            Constructor constructor = clazz.getConstructor();
            System.out.println(constructor.toString());

            Constructor constructor2 = clazz.getConstructor(new Class[]{String.class, int.class});
            System.out.println(constructor2.toString());
            
            Persion persion = (Persion) constructor.newInstance();
            persion.setName("caobinxin");
            System.out.println(persion.getName()); 

            Persion persion2 = (Persion) constructor2.newInstance("曹斌鑫", 20);
            System.out.println(persion2.getName()); 

            showAllMethod("Persion");

            getAppointMethod("Persion", "testParam", String.class, int.class);


            runPrivateMethod("Persion", "testPrivate", int.class);

            runStaticMethod("Persion", "testStaticMethod", int.class);

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("" + e);
        }
        
        
    }


    public static void showAllMethod(String className) throws Exception{
        Class clazz = Class.forName(className);
        
        Method[] methods = clazz.getMethods();//获取的是该类中所有的公有方法，包含继承和实现的方法
        System.out.println("获取的是该类中所有的公有方法，包含继承和实现的方法");
        for (Method method : methods) {
            System.out.println(method);
        }

        methods = clazz.getDeclaredMethods();// 获取的是该类中的所有方法，包含私有方法，但不包含继承的方法
        System.out.println("获取的是该类中的所有方法，包含私有方法，但不包含继承的方法");
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 获得指定的方法
     */
    public static void getAppointMethod(String className, String methodName, Class paramType1, Class paramType2){
        System.out.println("获得指定的方法，并且调用");
        try {
            Class clazz = Class.forName(className);

            Method method = clazz.getMethod(methodName, paramType1, paramType2);

            Object object = clazz.newInstance();
            method.invoke(object, "曹", 40);//执行这个方法

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("" + e.getMessage());
        }
    }

    public static void runPrivateMethod(String className, String privateMethodName, Class paramType1) throws Exception{
        System.out.println("访问私有方法");
        Class clazz = Class.forName(className);

        Method method = clazz.getDeclaredMethod(privateMethodName, paramType1);

        // 私有方法不能直接访问，因为权限不够，非要访问，可以通过暴力的方式
        method.setAccessible(true);//一般很少用，因为私有就是隐藏起来，所以尽量不要

        method.invoke(clazz.newInstance(),20);
    }

    public static void runStaticMethod(String className, String staticMethodName, Class paramType1)throws Exception{

        System.out.println("调用静态方法");
        Class clazz = Class.forName(className);
        Method method = clazz.getMethod(staticMethodName, paramType1);
        method.invoke(clazz.newInstance(), 30);
    }

    
}