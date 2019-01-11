class ConcreteIterator extends Iterator{
    
    private int currencyIndex = 0;
    private ConcreteAggregate aggregate;
    public ConcreteIterator(ConcreteAggregate aggregate){
        this.aggregate = aggregate;
    }

    @Override
    public Object onCurrentItem() {
        return aggregate.getItems(currencyIndex);
    }

    @Override
    public Object onFirst() {
        return aggregate.getItems(0);
    }

    @Override
    public boolean onIsDone() {
        return currencyIndex >= aggregate.getCount() ? true: false;
    }

    @Override
    public Object onNext() {
        System.out.println(currencyIndex);
        return aggregate.getItems(currencyIndex++);
    }

    
}