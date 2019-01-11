class test{
    public static void main(String[] args) {
        ConcreteReceiverA cRA = new ConcreteReceiverA();
        ConcreteReceiverB cRB = new ConcreteReceiverB();
        /** 这样写的好处在与  我们可以很 随意的指定  命令最终的执行者是谁   ConcreteReceiver* 就是我们命令的最终的执行者 */

        ConcreteCommandA cCA = new ConcreteCommandA(cRB);/**命令的执行者和 命令 进行绑定 */
       
        Invoker i = new Invoker();/*  去管理我们的命令（请求） 的触发时机   这里我们不用管 我们的请求（ConcreteCommand*）和 请求的响应者 到底是谁  只管调用的时机，就ok*/  

        i.setCommand(cCA);
        i.onExecuteCommand();

    }
}