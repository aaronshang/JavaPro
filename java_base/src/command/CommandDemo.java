package command;

/*
 * 核心思想
 * 个体、行为都封装成对象
 * 将请求和实现分开，所有的请求可用统一的接口或抽象类归一处理。
 * */
public class CommandDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("will do command design pattern.");
		
		Stock stock = new Stock();
		stock.name = "AL";
		stock.price = 200;
		
		//股票经纪人
		Stocker stocker = new Stocker();
		
		//股票行为
		BuyStock buyStock = new BuyStock(stock);
		SellStock sellStock = new SellStock(stock);
		
		//挂单
		stocker.takeOrder(buyStock);
		stocker.takeOrder(sellStock);
		
		//执行
		stocker.DealOrder();
	}

}
