package middle;

public class Hero {

	public String name;
	public int blood;
	public int damage;
	
	public Hero(){
		blood = 100;
		damage = 10;
	}
	public void AttachHero(Hero h){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.blood -= damage;
		System.out.format("%s is attacking %s, current blood %d\n", name, h.name, h.blood);
	}
	public boolean isDead(){
		return blood>0?false:true;
	}
}
