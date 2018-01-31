package middle;

public class KillThread extends Thread{

	private Hero h1,h2;
	
	public KillThread(Hero h1, Hero h2){
		this.h1 = h1;
		this.h2 = h2;
	}
	public void run(){
		while(!h2.isDead()){
			h1.AttachHero(h2);
		}
	}
}
