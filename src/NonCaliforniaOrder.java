import javax.swing.*;
import java.awt.*;

public class NonCaliforniaOrder extends UIBuilder implements Order {
  private double orderAmount;
  private JLabel lblOrderAmount = new JLabel("Order Amount:");
  private JTextField txtOrderAmount = new JTextField(10);
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

    searchUI = new JPanel();

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    searchUI.add(lblOrderAmount);
    searchUI.add(txtOrderAmount);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblOrderAmount, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtOrderAmount, gbc);

  }


  public void initialize() {
    lblOrderAmount.setText("Order Amount:");
  }
  public String getOrderAmountText() {
    return txtOrderAmount.getText();
  }
  public String getTaxtext() {
    return "0";
  }
  public String getSHtext() {
    return "0";
  }

  public void setOrderAmountText(String valor) {
    txtOrderAmount.setText(valor);
  }

  public void setTaxtext(String valor) {

  }

  public void setSHtext(String valor) {

  }

}
