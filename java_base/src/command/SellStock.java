package command;

public class SellStock implements Order{

	Stock _ownStock;
	SellStock(Stock stock){
		_ownStock = stock;
	}
	
	public void execute(){
		System.out.println("sell stock"+_ownStock.price);
	}
}
