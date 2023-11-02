package gameobjects;

import java.awt.*;
import java.awt.image.BufferedImage;

import handlers.ObjectHandler;
import loaders.GraphicsLoader;
import main.Game;
//import gameobjects;
import supers.Animation;
import supers.GameObject;

public class Bird extends GameObject{
	
	
	Animation animation;
	
	public float gravity;
	public float maxSpeed;
	
	public Bird(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		gravity = 0.3f;
		maxSpeed = 12f;
		
		BufferedImage[] images = new BufferedImage[3];
		
		for(int i = 0; i < images.length; i++) {
			images[i] = GraphicsLoader.loadGraphics("bird"+ i +".png");
		}
	
		animation = new Animation(this, 100, true, images);
		animation.start();
		
		ObjectHandler.addObject(this);
	}
	
	@Override
	public void tick() {
		
		velY += gravity;
		y += velY;
		
		if(velY > maxSpeed) {
			velY = maxSpeed;
		}
		
		if(y + height > Game.HEIGHT - 166) {
			y = Game.HEIGHT - 166 - height;
			setVelY(0);
		}
		
		if(y<0) {
			y=0;
			setVelY(0);
		}
		
		GameObject temp = null;
		
		for(int i = 0; i < ObjectHandler.list.size(); i++) {
			temp = ObjectHandler.list.get(i);
			
			if(temp instanceof Tube) {
				if(this.getBounds().intersects(temp.getBounds())) {
					Game.gameover = true;
				}
			}
		}
		//System.out.println(y);
		
		animation.tick();
	}
	
	@Override
	public void render(Graphics g) {
		animation.render(g);
	}
	
//	public void die() {
//		gameover = true;
	//}

}

