package source;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

	private Handler handler;
	
	public MouseInput(Handler handler){
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	//override more mouse adapter methods if needed for game
	
}
