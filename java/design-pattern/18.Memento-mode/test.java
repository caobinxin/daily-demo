class test{
    public static void main(String[] args) {
        Originator o = new Originator("cc", "男", 22);
        o.onShow();

        /**保存中间的值 */
        Caretaker c = new Caretaker();
        c.setMemento(o.onCreateMemento());

        o.setId(23);
        o.setSex("女");
        o.setName("花花");

        o.onShow();

        o.setMemento(c.getMemento());
        o.onShow();
    }
}