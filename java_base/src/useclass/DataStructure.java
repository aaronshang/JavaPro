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
	
	/*
	 * 枚举类型要用关键字enum，隐含创建数据类型Enum的子类
	 * */
	public static enum EnumTest{
		MON,
		UE,
		WED;
	}
	
	
	static public void TestEnumeration(){
		
		EnumTest t1 = EnumTest.UE;
		switch(t1){
		case UE:
			System.out.println("This is Monday."+t1.ordinal());
			break;
		default:
			System.out.println(t1);
			break;
		}

//		Vector<String> dayNames = new Vector<String>();
//		dayNames.add("Monday");
//		dayNames.add("Tuesday");
//		Enumeration days = dayNames.elements();
//		while(days.hasMoreElements()){
//			System.out.println(days.nextElement());
//		}
	}

}
