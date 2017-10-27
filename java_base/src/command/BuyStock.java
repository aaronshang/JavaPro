package command;

public class BuyStock implements Order{

	Stock _ownStock;
	BuyStock(Stock stock){
		_ownStock = stock;
	}
	
	public void execute(){
		System.out.println("buy stock"+_ownStock.price);
	}
}
