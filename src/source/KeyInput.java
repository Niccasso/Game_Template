package source;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Handle all key input
public class KeyInput extends KeyAdapter{

	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
	}
	
}
