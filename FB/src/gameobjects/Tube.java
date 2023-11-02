package gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import enums.TubeType;
import handlers.ObjectHandler;
import loaders.GraphicsLoader;
import main.Game;
import supers.GameObject;

public class Tube extends GameObject{
	
	TubeType type;
	
	BufferedImage tubeBlock;
	BufferedImage tube;
	
	public Tube(int x, int y, int width, int height, TubeType type) {
		super(x, y, width, height);
		
		this.type = type;
		this.velX = 3;
		
		tube = GraphicsLoader.loadGraphics("tube.png");
		
		if(type == TubeType.BOTTOM) {
			tubeBlock = GraphicsLoader.loadGraphics("tubebottomdown.png");
		}else if(type == TubeType.TOP) {
			tubeBlock = GraphicsLoader.loadGraphics("tubebottomtop.png");
		}
	}

	@Override
	public void tick() {
		x -= velX;
		
		if(x + width < 0) {
			ObjectHandler.removeObject(this);
			
			if(type == TubeType.TOP) {
			Game.score += 1;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if(type == TubeType.BOTTOM) {
			g.drawImage(tube, x, y, 72, height, null);
			g.drawImage(tubeBlock, x - 3, y, null);
		}else if(type == TubeType.TOP) {
			g.drawImage(tube, x, y, 72, height, null);
			g.drawImage(tubeBlock, x - 3, y + height - 36, null);
		}
		
	}

}
