class test{
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        

        Colleague A = new ConcreteColleagueA(m);
        Colleague B = new ConcreteColleagueB(m);
        Colleague C = new ConcreteColleagueC(m);
        Colleague D = new ConcreteColleagueD(m);

        m.onAddColleague(A);
        m.onAddColleague(B);
        m.onAddColleague(C);
        m.onAddColleague(D);

        A.onSend("我是A");
        B.onSend("你好");
        
    }
}