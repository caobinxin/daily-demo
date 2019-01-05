import java.lang.reflect.Method;

class Event{
    private Object object;
    private String methodName ;
    private Object[] params;
    private Class[] paramTypes;

    public Event(Object object, String methodName, Object...params){
        this.object = object;
        this.methodName = methodName;
        this.params = params;

        getParamOfType(this.params);
    }

    private void getParamOfType(Object...params){
        this.paramTypes = new Class[params.length];
        for(int i = 0; i < params.length; i++){
            this.paramTypes[i] = params[i].getClass(); 
        }
    }

    public void invoke() throws Exception{
        System.out.println("" + this.methodName + "  " + this.paramTypes );
        Method method = this.object.getClass().getMethod(this.methodName, this.paramTypes);
        if( null == method){
            System.out.println("没有找到指定方法");
            return ;
        }

        method.invoke(this.object, this.params);
        
    }
}