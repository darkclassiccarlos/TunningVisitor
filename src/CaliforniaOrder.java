import javax.swing.*;

public class CaliforniaOrder implements Order {
  private double orderAmount;
  private double additionalTax;
  private JLabel lblOrderAmount = new JLabel("Order Amount:");
  private JLabel lblAdditionalTax = new JLabel("Additional Tax(CA Orders Only):");
  public CaliforniaOrder() {
  }
  public CaliforniaOrder(double inp_orderAmount,
      double inp_additionalTax) {
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalTax() {
    return additionalTax;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }

  public void addUIControls() {
    JPanel searchUI = new JPanel();
    JTextField txtOrderAmount = new JTextField(10);
    JTextField txtAdditionalTax = new JTextField(10);

  }

  public void initialize() {
    lblOrderAmount.setText("Order Amount:");
    lblAdditionalTax.setText("Additional Tax(CA Orders Only):");
  }
}

