
public class Car implements Runnable {
	
	private Thread carThread;
	private int size;
	private int x, y;
	private int movingSpeed;
	private int nextX;
	private int delay;
	
	public Car(int movingSpeed) {
	
		
		this.movingSpeed = movingSpeed;
		
		size = 50;
		x = 1;
		y = 0;
		delay = 1000/60;
		carThread = new Thread(this);
		carThread.start();
		
	}
	
	public int getSize(){
		return size;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public int getMovingSpeed(){
		return movingSpeed;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setMovingSpeed(int movingSpeed){
		this.movingSpeed = movingSpeed;
	}
	
	public void moveAround(){
		
		nextX = x + size;
		
		if (nextX >= 500){
			movingSpeed *= -1;
		
		}
		
		if (x <= 0){
			movingSpeed *= -1;
		}
		
		x += movingSpeed;
		
	}

    public void run() {
        
		while (Thread.currentThread() == carThread){
			moveAround();
			try{
				Thread.sleep(delay);
			} catch (InterruptedException e){
				
				System.out.println ( "Exception: " + e.getMessage() );
				
			}
		}
}

}
