package handlers;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Game.bird.setVelY(-5);
		}
		
//		if(e.getKeyCode() == KeyEvent.VK_E) {
//			TubeHandler.spawnTube();
//		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
