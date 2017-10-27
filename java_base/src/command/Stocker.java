package command;
import java.util.ArrayList;
import java.util.List;

public class Stocker {

	private List<Order> list = new ArrayList<Order>();
	public void takeOrder(Order order){
		list.add(order);
	}
	
	
	public void DealOrder(){
		
		for(Order order: list){
			order.execute();
		}
	}
}
