import java.util.*;

class OrderVisitor implements VisitorInterface {

  private double orderTotal;
  private CompositeOrder or;

  public OrderVisitor() {
    or = new CompositeOrder();
  }

  public void visit(NonCaliforniaOrder inp_order) {
    orderTotal = inp_order.getOrderAmount();
    or.addOrder(Arrays.asList(OrderManager.NON_CA_ORDER, inp_order.getOrderAmount(), 0.0, 0.0, orderTotal));
  }

  public void visit(CaliforniaOrder inp_order) {
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalTax();
    or.addOrder(Arrays.asList(OrderManager.CA_ORDER, inp_order.getOrderAmount(), inp_order.getAdditionalTax(), 0.0, orderTotal));
  }

  public void visit(OverseasOrder inp_order) {
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    or.addOrder(Arrays.asList(OrderManager.OVERSEAS_ORDER, inp_order.getOrderAmount(), 0.0, inp_order.getAdditionalSH(), orderTotal));
  }

  public void visit(ChiniseOrder inp_order) {
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    or.addOrder(Arrays.asList(OrderManager.CHINISE_ORDER, inp_order.getOrderAmount(), 0.0, inp_order.getAdditionalSH(),  orderTotal));
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

  public List<Object> getOrder(int position) {
    return or.getOrder(position);
  }

  public List<List<Object>> deleteOrder(int position) {
    return or.deleteOrder(position);
  }

  public List<List<Object>> updateOrders(int position, List<Object> order) {
    return or.updateOrders(position, order);
  }

}

