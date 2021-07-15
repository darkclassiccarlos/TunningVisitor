import javax.swing.*;

public class NonCaliforniaOrder implements Order {
  private double orderAmount;
  private JLabel lblOrderAmount = new JLabel("Order Amount:");

  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
}
