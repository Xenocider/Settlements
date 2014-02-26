package xenocider.settlements;


import java.awt.Frame;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

import com.sun.j3d.utils.universe.ViewingPlatform;

import xenocider.settlements.graphics.Drawer;
import xenocider.settlements.listeners.KeyboardListener;

public class Settlements extends Frame {

	public static void main(String[] args) {
		new Settlements();
	}

	Settlements(){
		this.addKeyListener(new KeyboardListener());
		//Drawer.createCube();
		Drawer.createWorld();
	    Drawer.setCamera(0f, 2f, 0f, -20f, -75f);
		//Drawer.universe.getViewingPlatform().setNominalViewingTransform();
	}

}
