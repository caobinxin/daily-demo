class Decorator  implements Component{

    Component component = null ;
    /**
     * @param component the component to set
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void onOperation() {
        component.onOperation();    
    }
}