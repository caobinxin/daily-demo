class test{

    public static void main(String[] args) {
        Composite root = new Composite("root");

        Leaf x = new Leaf("x");
        root.onAdd(x);

        Leaf y = new Leaf("y");
        root.onAdd(y);

        Composite lay2 = new Composite("lay2");
        
        Leaf lay2_Leaf_x = new Leaf("x");

        lay2.onAdd(lay2_Leaf_x);

        root.onAdd(lay2);

        lay2.onAdd(new Leaf("y"));

        Composite lay3 = new Composite("lay3");
        lay3.onAdd(new Leaf("x"));
        lay3.onAdd(new Leaf("y"));

        lay2.onAdd(lay3);

        root.onAdd(new Leaf("w"));
        root.onAdd(new Leaf("z"));

        root.onDisplay(0);
    }
}