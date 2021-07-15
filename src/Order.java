import java.util.List;

public interface Order {
  public void accept(OrderVisitor v);
}
