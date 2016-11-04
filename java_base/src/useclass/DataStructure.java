package useclass;
import java.util.Enumeration;
import java.util.Vector;
/** 
* @author kai.shang
* @version 2016年11月4日 下午11:16:23
*/ 

class DataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestEnumeration();
	}
	
	/**
	 *测试枚举数据类型
	 *Enumeration本身是个接口，不是数据结构
	 *
	 *
	 *@author aaron
	 *@Time 2016年11月4日
	 */
	static public void TestEnumeration(){

		Vector<String> dayNames = new Vector<String>();
		dayNames.add("Monday");
		dayNames.add("Tuesday");
		Enumeration days = dayNames.elements();
		while(days.hasMoreElements()){
			System.out.println(days.nextElement());
		}
	}

}
