import java.util.*;

class OrderVisitor implements VisitorInterface {

  private List<List<Object>> orders;

  private Vector orderObjList;
  private double orderTotal;

  private CompositeOrder or;

  public OrderVisitor() {
    orderObjList = new Vector();
    orders = new ArrayList<List<Object>>();
    or = new CompositeOrder();
  }

  public void visit(NonCaliforniaOrder inp_order) {

    orderTotal = inp_order.getOrderAmount();
    or.addOrder(Arrays.asList("Non California", inp_order.getOrderAmount(), 0.0, 0.0, orderTotal));

    //orderTotal = orderTotal + inp_order.getOrderAmount();
  }

  public void visit(CaliforniaOrder inp_order) {
    //orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalTax();
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalTax();

    or.addOrder(Arrays.asList("California", inp_order.getOrderAmount(), inp_order.getAdditionalTax(), 0.0, orderTotal));
  }

  public void visit(OverseasOrder inp_order) {
    //orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();

    or.addOrder(Arrays.asList("Overseas", inp_order.getOrderAmount(), 0.0, inp_order.getAdditionalSH(), orderTotal));
  }

  public void visit(ColombianOrder inp_order) {
    //orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();

    or.addOrder(Arrays.asList("Overseas", inp_order.getOrderAmount(), 0.0, inp_order.getAdditionalSH(),  orderTotal));
  }

  public void visit(CompositeOrder inp_order) {
    orderTotal = inp_order.getOrderAmount();
  }

  public double getOrderTotal() {
    return orderTotal;
  }

  public List<List<Object>> getOrders() {
    return or.getOrders();
  }

}
