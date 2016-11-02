package useclass;
/** 
* @author kai.shang
* @version 2016年11月2日 上午7:34:48
*/
/*
接口与类的区别：
接口不能用于实例化对象。
接口没有构造方法。
接口中所有的方法必须是抽象方法。
接口不能包含成员变量，除了static和final变量。
接口不是被类继承了，而是要被类实现。
接口支持多重继承。
 * */

interface Eat{
	public void washHands();
	public void eatFood();
}

interface Sleep{
	public void washFace();
}

class People implements Eat, Sleep{
	
	public void washHands(){
		System.out.println("People wash hands");
	}
	public void eatFood(){
		System.out.println("People eat food");
	}
	public void washFace(){
		System.out.println("People  wash face before sleep");
	}
}

public class UseInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eat eat = new People();
		eat.eatFood();
		
		Sleep sleep = new People();
		sleep.washFace();
	}

}
