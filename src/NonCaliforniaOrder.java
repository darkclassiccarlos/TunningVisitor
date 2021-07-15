import javax.swing.*;

public class NonCaliforniaOrder extends UIBuilder implements Order {
  private double orderAmount;
  private JLabel lblOrderAmount = new JLabel("Order Amount:");
  private JTextField txtOrderAmount = new JTextField(10);
  private JTextField txtAdditionalTax = new JTextField(10);
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


  public void addUIControls() {

  }


  public void initialize() {

  }
  public String getOrderAmountText() {
    return txtOrderAmount.getText();
  }
  public String getTaxtext() {
    return txtAdditionalTax.getText();
  }
  public String getSHtext() {
    return txtAdditionalTax.getText();
  }

}
