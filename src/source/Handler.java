package source;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>(); //list of all active game objects
	
	//update all game objects
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	//render all game objects
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	//add object to the list
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	//remove object from the list
	public void removeObject(GameObject object){
		this.object.remove(object);
	}



}