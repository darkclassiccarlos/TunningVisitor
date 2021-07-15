import java.util.*;

public class CompositeOrder implements Order {
    private double orderAmount;

    private List<List<Object>> orders=new ArrayList<List<Object>>();

    public CompositeOrder(){

    }

    public void addOrder(Order or) {
        //orders.add(Arrays.asList(type, amount, tax, sh, result));
    }

    public List<Object> getOrder(int position) {
        return orders.get(position);
    }

    public List<List<Object>> getOrders() {
        return orders;
    }

    public double getOrderAmount() {

        for(int x =0; x < orders.size(); x++)
        {
           Object size = orders.get(x).get(4);
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
