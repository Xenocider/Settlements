package xenocider.settlements.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener{
	
	public static boolean arrowUp = false;
	public static boolean arrowDown = false;
	public static boolean arrowLeft = false;
	public static boolean arrowRight = false;

	@Override
	public void keyPressed(KeyEvent evt) {
	    int keyCode = evt.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	arrowUp = true;
	        	System.out.println("UP");
	            break;
	        case KeyEvent.VK_DOWN:
	        	arrowDown = true;
	            break;
	        case KeyEvent.VK_LEFT:
	        	arrowLeft = true;
	            break;
	        case KeyEvent.VK_RIGHT :
	        	arrowRight = true;
	            break;
	     }
	} 

	@Override
	public void keyReleased(KeyEvent evt) {
	    int keyCode = evt.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	arrowUp = false;
	            break;
	        case KeyEvent.VK_DOWN:
	        	arrowDown = false;
	            break;
	        case KeyEvent.VK_LEFT:
	        	arrowLeft = false;
	            break;
	        case KeyEvent.VK_RIGHT :
	        	arrowRight = false;
	            break;
	     }
	} 

	@Override
	public void keyTyped(KeyEvent evt) {
		
	}

}