import javax.swing.*;
import java.util.List;

public interface Order {
  JPanel searchUI = new JPanel();

  public  void accept(OrderVisitor v);
  public  void addUIControls();
  public  void initialize();

  public default JPanel getSearchUI() {
    return searchUI;
  }

/*  public void addOrder(Order or);

  public Order getOrder(int position);

  public abstract List<List<Object>> getOrders();

  public void accept(OrderVisitor v); */
}
