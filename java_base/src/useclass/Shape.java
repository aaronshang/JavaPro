package useclass;

import java.util.Random;

/** 
* @author kai.shang
* @version 2016年11月1日 下午11:26:58
*/

/**
 * 动态
 * 
 * 工厂模式，创建
 * */

class BaseShape{
	public void draw(){}
}

class Circle extends BaseShape{
	public void draw(){
		System.out.println("Circle Draw");
	}
}

class Rect extends BaseShape{
	
	public void draw(){
		System.out.println("Rect Draw");
	}
}

class RandShapeGenerator{
	
	private Random rand = new Random(5);
	public BaseShape next(){
		switch(rand.nextInt(2)){
		case 0: return new Circle();
		case 1: return new Rect();
		default:return new Circle();
		}
	}
}
public class Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandShapeGenerator gen = new RandShapeGenerator();
		BaseShape[] shapes = new BaseShape[5];
		for (int i=0; i<5; i++){
			shapes[i] = gen.next();
		}
		
		for(BaseShape shp : shapes){
			shp.draw();
		}
	}

}
