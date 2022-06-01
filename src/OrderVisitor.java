import java.util.*;

class OrderVisitor implements VisitorInterface {

  public static final String CA_ORDER = "California Order";
  public static final String NON_CA_ORDER = "Non-California Order";
  public static final String OVERSEAS_ORDER = "Overseas Order";
  public static final String CHINISE_ORDER = "Chinise Order";

  private double orderTotal;
  private CompositeOrder or;

  public OrderVisitor() {
    or = new CompositeOrder();
  }

  public void visit(NonCaliforniaOrder inp_order) {
    orderTotal = inp_order.getOrderAmount();
    or.addOrder(Arrays.asList(NON_CA_ORDER, inp_order.getOrderAmount(), 0.0, 0.0, orderTotal));
  }

  public void visit(CaliforniaOrder inp_order) {
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalTax();
    or.addOrder(Arrays.asList(CA_ORDER, inp_order.getOrderAmount(), inp_order.getAdditionalTax(), 0.0, orderTotal));
  }

  public void visit(OverseasOrder inp_order) {
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    or.addOrder(Arrays.asList(OVERSEAS_ORDER, inp_order.getOrderAmount(), 0.0, inp_order.getAdditionalSH(), orderTotal));
  }

  public void visit(ChiniseOrder inp_order) {
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    or.addOrder(Arrays.asList(CHINISE_ORDER, inp_order.getOrderAmount(), 0.0, inp_order.getAdditionalSH(),  orderTotal));
  }

  public void visit(CompositeOrder inp_order) {
    orderTotal = inp_order.getOrderAmount();
  }

  public double getOrderTotal() {
    return or.getOrderAmount();
  }

  public List<List<Object>> getOrders() {
    return or.getOrders();
  }

  public List<List<Object>> deleteOrder(int position) {
    return or.deleteOrder(position);
  }

}

