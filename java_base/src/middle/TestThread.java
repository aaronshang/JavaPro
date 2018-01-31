package middle;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero sunMonkey= new Hero();
		sunMonkey.name = "Sun Monkey";
		
		Hero zhuPig = new Hero();
		zhuPig.name = "Zhu Pig";
		
		Hero dog= new Hero();
		dog.name = "Dog";
		
		Hero cat = new Hero();
		cat.name = "Cat";
		
		KillThread k1 = new KillThread(sunMonkey, zhuPig);
		k1.start();
		KillThread k2 = new KillThread(dog, cat);
		k2.start();
	}

}
