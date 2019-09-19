package source;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private final int WIDTH = 1920, HEIGHT = 1080; // window dimensions
	private final String TITLE = "Default Game Title... Change This"; //window title
	private boolean running = false; //game state variable, initialize to false as the game is not yet running
	private Thread thread; //thread declaration
	private Handler handler; //handler declaration
	private HUD hud; //heads-up display declaration
	
	//constructor, is called from the main method
	public Game(){
		
		handler = new Handler(); //initialize game object manager
		this.addKeyListener(new KeyInput(handler)); //allows for keyboard input (not until focused, after GameFrame is constructed)
		this.addMouseListener(new MouseInput(handler)); //allows for mice input (not until focused, after GameFrame is constructed)
		new GameFrame(WIDTH, HEIGHT, TITLE, this); //calls the GameFrame constructor
		setFocusable(true); requestFocus(); //obtain window focus
		
		hud = new HUD();//initialize heads-up display
		
		//add game objects here
		
	}
	
	//start thread, game is now running
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	//stop thread, game is no longer running
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//game update loop, update x times per second, render as quickly as possible
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			if(running){
				render();
			}
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + ticks);
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	//update game "x" times per second
	private void tick(){
		handler.tick();
		hud.tick();
	}
	
	//render as quickly as possible
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	// application begins here
	public static void main(String[] args) {
		new Game(); //calls the Game constructor
	}	
	
}
