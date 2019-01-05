class ConcreteNotifier extends Notifier{
    @Override
    public void addListener(Object object, String methodName, Object... args) {
        getEventHandler().addEvent(object, methodName, args);
    }

    @Override
    public void notifyX() {
        try {
            getEventHandler().notifyX();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("" + e.getMessage());
        }
    }
}