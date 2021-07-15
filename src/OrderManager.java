import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.sun.java.swing.plaf.windows.*;


import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "Create Order";
  public static final String EXIT = "Exit";
  public static final String CA_ORDER = "California Order";
  public static final String NON_CA_ORDER = "Non-California Order";
  public static final String OVERSEAS_ORDER = "Overseas Order";
  public static final String COLOMBIAN_ORDER = "Colombian Order";
  public static final String BLANK = "";

  private JComboBox cmbOrderType;
  //
  private JPanel pSearchCriteria;
  //
  private JTextField txtOrderAmount, txtAdditionalTax,
  txtAdditionalSH;
  private JLabel lblOrderType, lblOrderAmount;
  private JLabel lblAdditionalTax, lblAdditionalSH;
  private JLabel lblTotal, lblTotalValue;

  private OrderVisitor objVisitor;

  private JTable table;
  private JScrollPane scrollPane;
  private Container contentPane;

  public OrderManager() {
    super("Visitor Pattern - Example");

    //Create the visitor instance
    objVisitor = new OrderVisitor();

    cmbOrderType = new JComboBox();
    cmbOrderType.addItem(OrderManager.BLANK);
    cmbOrderType.addItem(OrderManager.CA_ORDER);
    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
    cmbOrderType.addItem(OrderManager.COLOMBIAN_ORDER);


    //txtOrderAmount = new JTextField(10);
    //txtAdditionalTax = new JTextField(10);
    txtAdditionalSH = new JTextField(10);

    lblOrderType = new JLabel("Order Type:");
    //
    pSearchCriteria = new JPanel();
    //
    //lblOrderAmount = new JLabel("Order Amount:");
    //lblAdditionalTax = new JLabel("Additional Tax(CA Orders Only):");
    //lblAdditionalSH =  new JLabel("Additional S & H(Overseas Orders Only):");

    lblTotal = new JLabel("Result:");
    lblTotalValue =
      new JLabel("Click Create or GetTotal Button");

    //Create the open button
    JButton getTotalButton =
      new JButton(OrderManager.GET_TOTAL);
    getTotalButton.setMnemonic(KeyEvent.VK_G);
    JButton createOrderButton =
      new JButton(OrderManager.CREATE_ORDER);
    getTotalButton.setMnemonic(KeyEvent.VK_C);
    JButton exitButton = new JButton(OrderManager.EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonHandler objButtonHandler = new ButtonHandler(this);

    getTotalButton.addActionListener(objButtonHandler);
    createOrderButton.addActionListener(objButtonHandler);
    exitButton.addActionListener(new ButtonHandler());
    //add listener
    cmbOrderType.addActionListener(objButtonHandler);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    JPanel panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    panel.add(getTotalButton);
    panel.add(createOrderButton);
    panel.add(exitButton);
    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(getTotalButton, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(exitButton, gbc2);

    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    //buttonPanel.add(lblOrderAmount);
    //buttonPanel.add(txtOrderAmount);
    //buttonPanel.add(lblAdditionalTax);
    //buttonPanel.add(txtAdditionalTax);
    //buttonPanel.add(lblAdditionalSH);
    //buttonPanel.add(txtAdditionalSH);
    buttonPanel.add(lblTotal);
    buttonPanel.add(lblTotalValue);
    buttonPanel.add(pSearchCriteria);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbOrderType, gbc);

    //gbc.anchor = GridBagConstraints.EAST;
    //gbc.gridx = 0;
    //gbc.gridy = 1;
    //gridbag.setConstraints(lblOrderAmount, gbc);
    //
    gridbag.setConstraints(pSearchCriteria, gbc);
    //
    //gbc.anchor = GridBagConstraints.WEST;
    //gbc.gridx = 1;
    //gbc.gridy = 1;
    //gridbag.setConstraints(txtOrderAmount, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 2;
    //gridbag.setConstraints(lblAdditionalTax, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 2;
    //gridbag.setConstraints(txtAdditionalTax, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 3;
    //gridbag.setConstraints(lblAdditionalSH, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(txtAdditionalSH, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotal, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotalValue, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    //****************************************************

    //Add the buttons and the log to the frame
    contentPane = getContentPane();

    contentPane.add(buttonPanel, BorderLayout.NORTH);

    //contentPane.add(scrollPane, BorderLayout.CENTER );

    contentPane.add(panel, BorderLayout.PAGE_END);

    try {
      UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
        OrderManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }
  public void displayNewUI(JPanel panel) {
    pSearchCriteria.removeAll();
    pSearchCriteria.add(panel);
    pSearchCriteria.validate();
    validate();
  }
  public static void main(String[] args) {
    JFrame frame = new OrderManager();

    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );

    //frame.pack();
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }
  public String getOrderAmount() {
    return txtOrderAmount.getText();
  }
  public String getTax() {
    return txtAdditionalTax.getText();
  }
  public String getSH() {
    return txtAdditionalSH.getText();
  }
  public JComboBox getOrderTypeCtrl() {
    return cmbOrderType;
  }

  public void setGrid(TableModel tableModel){
    table = new JTable(tableModel);

    table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, table.getSelectedRow());
      }
    });

    scrollPane = new JScrollPane(table);
    contentPane.add(scrollPane, BorderLayout.CENTER);
  }

} // End of class OrderManager

class ButtonHandler implements ActionListener {
  OrderManager objOrderManager;
  UIBuilder builder;
  public void actionPerformed(ActionEvent e) {
    String totalResult = null;

    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }
    if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {
      //String selection = objOrderManager.getOrderType();
      String orderType = objOrderManager.getOrderType();

      if (orderType.equals("") == false) {
        BuilderFactory factory = new BuilderFactory();
        //create an appropriate builder instance
        builder = factory.getUIBuilder(orderType);
        //configure the director with the builder
        UIDirector director = new UIDirector(builder);
        //director invokes different builder
        // methods
        director.build();
        //get the final build object
        JPanel UIObj = builder.getSearchUI();
        objOrderManager.displayNewUI(UIObj);
      }
    }
    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)
        ) {
      //get input values
      String orderType = objOrderManager.getOrderType();
      //String strOrderAmount = objOrderManager.getOrderAmountText();
      String strOrderAmount = builder.getOrderAmountText();
      String strTax = builder.getTaxtext();
      String strSH = builder.getSHtext();

      double dblOrderAmount = 0.0;
      double dblTax = 0.0;
      double dblSH = 0.0;

      if (strOrderAmount.trim().length() == 0) {
        strOrderAmount = "0.0";
      }
      if (strTax.trim().length() == 0) {
        strTax = "0.0";
      }
      if (strSH.trim().length() == 0) {
        strSH = "0.0";
      }

      dblOrderAmount =
        new Double(strOrderAmount).doubleValue();
      dblTax = new Double(strTax).doubleValue();
      dblSH = new Double(strSH).doubleValue();

      //Create the order
      Order order = createOrder(orderType, dblOrderAmount,
                    dblTax, dblSH);

      //Get the Visitor
      OrderVisitor visitor =
        objOrderManager.getOrderVisitor();

      // accept the visitor instance
      order.accept(visitor);

      objOrderManager.setTotalValue(" Order Created Successfully");

      //Grid tables
      SetValuesGrid(visitor.getOrders());

    }

    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
      //Get the Visitor
      OrderVisitor visitor =  objOrderManager.getOrderVisitor();

      totalResult = new Double(visitor.getOrderTotal()).toString();

      totalResult = " Orders Total = " + totalResult;

      objOrderManager.setTotalValue(totalResult);
    }
  }

  //Metodo que carga los datos en la grilla
  public void SetValuesGrid(List<List<Object>> dataTables) {
    List<String> columns = new ArrayList<String>();
    List<String[]> values = new ArrayList<String[]>();

    columns.add("Type");
    columns.add("Amount");
    columns.add("Addit Tax");
    columns.add("Addit S&H");
    columns.add("Result");

    for (int i = 0; i < dataTables.size(); i++) {
      values.add(
              new String[] {
                      dataTables.get(i).get(0).toString(),
                      dataTables.get(i).get(1).toString(),
                      dataTables.get(i).get(2).toString(),
                      dataTables.get(i).get(3).toString(),
                      dataTables.get(i).get(4).toString()
              });
    }

    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

    objOrderManager.setGrid(tableModel);
  }

  public Order createOrder(String orderType,
      double orderAmount, double tax, double SH) {

    if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
      return new CaliforniaOrder(orderAmount, tax);
    }
    if (orderType.equalsIgnoreCase(
      OrderManager.NON_CA_ORDER)) {
      return new NonCaliforniaOrder(orderAmount);
    }
    if (orderType.equalsIgnoreCase(
          OrderManager.OVERSEAS_ORDER)) {
      return new OverseasOrder(orderAmount, SH);
    }
    if (orderType.equalsIgnoreCase(
            OrderManager.COLOMBIAN_ORDER)) {
      return new ColombianOrder(orderAmount, SH);
    }
    return null;
  }

  public ButtonHandler() {
  }
  public ButtonHandler(OrderManager inObjOrderManager) {
    objOrderManager = inObjOrderManager;
  }

  //*******************
  public void printDebugData(JTable table) {
    int numRows = table.getRowCount();
    int numCols = table.getColumnCount();
    javax.swing.table.TableModel model = table.getModel();

    System.out.println("Value of data: ");
    for (int i=0; i < numRows; i++) {
      System.out.print("    row " + i + ":");
      for (int j=0; j < numCols; j++) {
        System.out.print("  " + model.getValueAt(i, j));
      }
      System.out.println();
    }
    System.out.println("--------------------------");
  }
  //*******************

} // End of class ButtonHandler

