import javax.swing.*;
import java.util.List;

public interface Order {

  public  void accept(OrderVisitor v);


/*  public void addOrder(Order or);

  public Order getOrder(int position);

  public abstract List<List<Object>> getOrders();

  public void accept(OrderVisitor v); */
}
