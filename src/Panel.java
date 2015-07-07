import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Panel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	protected Thread animacja; //watek do animacji
	protected int delay;	//czas pomiedzy klatkami
	private Car car1;
	private Car car2;
	
	private JSlider slider1;
	
	
	public Panel() {
		
		car1 = new Car(5);
		car2 = new Car(8);
		slider1 = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 10);
		slider1.setMajorTickSpacing(10);
		slider1.setPaintTicks(true);
		slider1.addChangeListener(		
				new ChangeListener(){
					public void stateChanged(ChangeEvent e){						
						car1.setMovingSpeed(slider1.getValue());						
					}
				}				
		);
		
		add(slider1, BorderLayout.SOUTH);
		
		setBackground(Color.BLACK);
		
		delay = 1000/60;
		animacja = new Thread(this);
		animacja.start();
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);		
		
		g.setColor(Color.WHITE);
		g.fillOval(car1.getX(), car1.getY(), car1.getSize(), car1.getSize());
		g.fillOval(car2.getX(), car2.getY(), car2.getSize(), car2.getSize());
		
	}

	public void run() {
		
		while (Thread.currentThread() == animacja){
			repaint();
			try{
				Thread.sleep(delay);
			} catch (InterruptedException e){
				
				System.out.println ( "Exception: " + e.getMessage() );
				
			}
		}
				
	}

}
