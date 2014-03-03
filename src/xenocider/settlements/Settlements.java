package xenocider.settlements;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.sun.j3d.utils.universe.SimpleUniverse;

import xenocider.settlements.blocks.Grass;
import xenocider.settlements.graphics.Drawer;
import xenocider.settlements.listeners.KeyboardListener;

public class Settlements extends JFrame{
	
	    // INSTANCE ****************************************************************

	    /** The canvas where the object is rendered. */
	    public static Canvas3D canvas;

	    /** Simplifies the configuration of the scene. */
	    public static SimpleUniverse universe;

	    /** The root node of the scene. */
	    public static BranchGroup root;
	    
		private final float pitch = -75f;
	    
	    // INITIALIZATION **********************************************************

	    /**
	     * Creates a window with a 3D canvas on its center.
	     *
	     * @throws IOException if some error occur while loading the model
	     */
	    public Settlements() throws IOException {
	        configureWindow();
	        configureCanvas();
	        conigureUniverse();
	        //addModelToUniverse();
	        //addLightsToUniverse();
	        loadTextures();
	        Drawer.createWorld();
	        root.compile();
	        universe.addBranchGraph(root);
	        getContentPane().setFocusable(true);
	        getContentPane().addKeyListener(new KeyboardListener());
	    }

	    private void loadTextures() throws FileNotFoundException, IOException {
			Grass.loadTexture();
			
		}

		/**
	     * Defines basic properties of this window.
	     */
	    private void configureWindow() {
	        setTitle("Basic Java3D Program");
	        setSize(640, 480);
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int locationX = (screenSize.width - getWidth()) / 2;
	        int locationY = (screenSize.height - getHeight()) / 2;
	        setLocation(locationX,locationY);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    /**
	     * Defines basic properties of the canvas. 
	     */
	    private void configureCanvas() {
	        canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
	        canvas.setDoubleBufferEnable(true);
	        getContentPane().add(canvas, BorderLayout.CENTER);
	    }

	    /** 
	     * Defines basic properties of the universe.
	     */
	    private void conigureUniverse() {
	        universe = new SimpleUniverse(canvas);
	        Drawer.setCamera(0, 0.5f, 1, 0, -60);
	        root = new BranchGroup();
	    }
	    
	    public static void main(String[] args) {
	        try {
	            new Settlements().setVisible(true);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

}
