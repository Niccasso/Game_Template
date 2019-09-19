package source;

import java.awt.Graphics;
import java.awt.Rectangle;

//template for all game objects
public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX , velY;
	protected boolean visible;
	
	public GameObject(int x, int y, ID id, boolean visible){
		this.x = x;
		this.y = y;
		this.id = id;
		this.visible = visible;
	}
	
	public abstract void tick(); //game updates
	public abstract void render(Graphics g); 
	public abstract Rectangle getBounds(); //collision detection
	
	//getters and setters
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return this.id;
	}
	public void setVis(boolean visibility){
		this.visible = visibility;
	}
	public boolean getVis(){
		return this.visible;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getVelX(){
		return this.velX;
	}
	public int getVelY(){
		return this.velY;
	}

}
