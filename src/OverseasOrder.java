import javax.swing.*;

public class OverseasOrder implements Order {
  private double orderAmount;
  private double additionalSH;
  private JLabel lblOrderAmount = new JLabel("Order Amount:");
  private JLabel lblAdditionalSH =  new JLabel("Additional S & H(Overseas Orders Only):");
  public OverseasOrder() {
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
}
