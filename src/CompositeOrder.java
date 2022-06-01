import java.util.*;

public class CompositeOrder implements Order {

    private List<List<Object>> orders;

    public CompositeOrder(){
        orders = new ArrayList<List<Object>>();
    }

    public void addOrder(List<Object> or) {
        orders.add(or);
    }

    public List<Object> getOrder(int position) {
        return orders.get(position);
    }

    public List<List<Object>> deleteOrder(int position) {
        orders.remove(position);
        return orders;
    }
    public List<List<Object>> getOrders() {
        return orders;
    }

    public double getOrderAmount() {
        double orderAmount = 0;

        for(int x =0; x < orders.size(); x++)
        {
            double total = (double)orders.get(x).get(4);
            orderAmount += total;
        }

        return orderAmount;
    }

    public void accept(OrderVisitor v) {
        v.visit(this);
    }

    public void addUIControls() {

    }

    public void initialize() {

    }
}
