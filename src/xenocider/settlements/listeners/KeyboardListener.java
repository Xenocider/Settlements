package xenocider.settlements.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import xenocider.settlements.graphics.Drawer;

public class KeyboardListener implements KeyListener{
	

	@Override
	public void keyPressed(KeyEvent evt) {
	    int keyCode = evt.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	Drawer.moveCamera(0, 0, -0.02f, 0, 0);
	            break;
	        case KeyEvent.VK_DOWN:
	        	Drawer.moveCamera(0, 0, 0.02f, 0, 0);
	            break;
	        case KeyEvent.VK_LEFT:
	        	Drawer.moveCamera(-0.02f, 0, 0, 0, 0);
	            break;
	        case KeyEvent.VK_RIGHT :
	        	Drawer.moveCamera(0.02f, 0, 0, 0, 0);
	            break;
	        case KeyEvent.VK_COMMA:
	        	Drawer.moveCamera(0, -0.02f, 0, 0, 0);
	            break;
	        case KeyEvent.VK_PERIOD :
	        	Drawer.moveCamera(0, 0.02f, 0, 0, 0);
	            break;
	        case KeyEvent.VK_O:
	        	Drawer.moveCamera(0, 0, 0, 2, 0);
	            break;
	        case KeyEvent.VK_P :
	        	Drawer.moveCamera(0, 0, 0, -2, 0);
	            break;
	     }
	} 

	@Override
	public void keyReleased(KeyEvent evt) {
	    int keyCode = evt.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            break;
	        case KeyEvent.VK_DOWN:
	            break;
	        case KeyEvent.VK_LEFT:
	            break;
	        case KeyEvent.VK_RIGHT :
	            break;
	     }
	} 

	@Override
	public void keyTyped(KeyEvent evt) {
		
	}

}
