public class BuilderFactory {
    public UIBuilder getUIBuilder(String str) {
        UIBuilder builder = null;
        if (str.equalsIgnoreCase(OrderManager.CA_ORDER)) {
            builder = new CaliforniaOrder();
        }
        if (str.equals(OrderManager.NON_CA_ORDER)) {
            builder =  new NonCaliforniaOrder();
        }
        if (str.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)) {
            builder = new OverseasOrder();
        }
        if (str.equalsIgnoreCase(OrderManager.CHINISE_ORDER)) {
            builder = new ChiniseOrder();
        }
        return builder;
    }
}
