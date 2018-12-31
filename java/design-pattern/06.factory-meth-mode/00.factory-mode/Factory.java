class Factory{
    public Ioperation createOperation(String lable){

        Ioperation ioperation = null;

        switch(lable){
            case "+":
                ioperation = new Add(1, 2);
                break;
            case "-":
                ioperation = new Sub(1, 2);
                break;
        }

        return ioperation;
    }
}