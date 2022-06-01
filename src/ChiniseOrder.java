import javax.swing.*;
import java.awt.*;

public class ChiniseOrder extends UIBuilder implements Order {
  private double orderAmount;
  private double additionalSH;
  private JLabel lblOrderAmount = new JLabel("Order Amount:");
  private JLabel lblAdditionalSH =  new JLabel("Additional S & H(Overseas and Chinise Orders Only):");
  private JTextField txtOrderAmount = new JTextField(10);
  private JTextField txtAdditionalTax = new JTextField(10);
  public ChiniseOrder() {
  }
  public ChiniseOrder(double inp_orderAmount,
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


  public void addUIControls() {

    searchUI = new JPanel();

    searchUI.add(txtAdditionalTax);

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    searchUI.add(lblOrderAmount);
    searchUI.add(txtOrderAmount);
    searchUI.add(lblAdditionalSH);
    searchUI.add(txtAdditionalTax);

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

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(lblAdditionalSH, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(txtAdditionalTax, gbc);


  }


  public void initialize() {
    lblOrderAmount.setText("Order Amount:");
    lblAdditionalSH.setText("Additional S & H(Overseas and Chinise Orders Only):");
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

  public void setOrderAmountText(String valor) {
    txtOrderAmount.setText(valor);
  }

  public void setTaxtext(String valor) {
    txtAdditionalTax.setText(valor);
  }

  public void setSHtext(String valor) {
    txtAdditionalTax.setText(valor);
  }

}