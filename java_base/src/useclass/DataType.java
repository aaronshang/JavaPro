package useclass;
/** 
* @author kai.shang
* @version 2016年11月2日 下午10:02:37
*/

/**
 * 	基本数据类型的使用
 *	static
	类变量（静态变量）
	类变量也称为静态变量，在类中以static关键字声明，但必须在方法构造方法和语句块之外。
	无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
	静态变量除了被声明为常量外很少使用。
	
	常量是指声明为public/private，final和static类型的变量。常量初始化后不可改变。
	静态变量储存在静态存储区。经常被声明为常量，很少单独使用static声明变量。
	静态变量在程序开始时创建，在程序结束时销毁。
	
	与实例变量具有相似的可见性。但为了对类的使用者可见，大多数静态变量声明为public类型。
	默认值和实例变量相似。数值型变量默认值是0，布尔型默认值是false，引用类型默认值是null。
	变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
	静态变量可以通过：ClassName.VariableName的方式访问。
	类变量被声明为public static final类型时，类变量名称必须使用大写字母。
	如果静态变量不是public和final类型，其命名方式与实例变量以及局部变量的命名方式一致。
 
	非访问修饰符
	为了实现一些其他的功能，Java也提供了许多非访问修饰符。
	static修饰符，用来创建类方法和类变量。
	Final修饰符，用来修饰类、方法和变量，
	final修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
	Abstract修饰符，用来创建抽象类和抽象方法。
	Synchronized和volatile修饰符，主要用于线程的编程。
	
	Static修饰符
	静态变量：
	Static关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 
	静态变量也被成为类变量。局部变量不能被声明为static变量。
	静态方法：
	Static关键字用来声明独立于对象的静态方法。静态方法不能使用类的非静态变量。
	静态方法从参数列表得到数据，然后计算这些数据。
	
	Synchronized修饰符
	Synchronized关键字声明的方法同一时间只能被一个线程访问。
	Synchronized修饰符可以应用于四个访问修饰符。
	实例：
	public synchronized void showDetails(){
	.......
	} 
 
 */

class Dog{
	public static final String Name = "Hero";
	public static int age = 10;
}

public class DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(Dog.Name);
	}

}
