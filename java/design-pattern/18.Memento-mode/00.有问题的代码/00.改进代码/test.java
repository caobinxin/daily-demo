class test{
    public static void main(String[] args) {
        GameRole c = new GameRole();
        c.getInitState();
        c.stateDisplay();

        //保存状态
        RoleStateManager r = new RoleStateManager(c.onCreatMemento());
        

        //大战 boss时 ，耗损严重
        c.fight();
        c.stateDisplay();

        //恢复之前的状态
        c.onSetMemento(r.getMemento());

        c.stateDisplay();
    }
}

/***
 * 
 * 
 * 代码无错 未必优  这个有点类似于 clone模式 暴露太多
 * 
 * 我们将游戏的细节都暴露给客户端了， 客户端的职责太大了，需要知道游戏的 生命力、攻击力、防御力等这些细节
 * 还要对他们进行备份，以后如果需要增加 游戏角色的魔法力 或者 修改现有的某种能力，例如生命力 改为经验值，这部分就一定要修改了。同样的道理也存在于恢复时的代码。
 * 
 * 显然 我们希望的是把 这些游戏角色，的存取状态细节封装起来，而且最好是封装在外部的类当中。以体现职责分离
 */