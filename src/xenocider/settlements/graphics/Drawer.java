package xenocider.settlements.graphics;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import xenocider.settlements.Settlements;
import xenocider.settlements.blocks.Grass;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

public class Drawer {
	
	public static float x;
	public static float y;
	public static float z;
	public static float pitch;
	public static float yaw;
	public static float xMax = 20;
	public static float yMax = 20;
	public static float zMax = 20;
	
	public static void createWorld() {
		for(float x=-1f;x<=1f;x = x + 0.06f) {  
			for (float z=-1f;z<=1f;z = z + 0.06f) {
			    Box cube = new Box(0.4f, 0.4f, 0.4f,
			            Box.GENERATE_TEXTURE_COORDS, Grass.app);
				TransformGroup transGroup = new TransformGroup();
				Transform3D pos1 = new Transform3D();
				pos1.setTranslation(new Vector3f(x,0.0f,z));
				transGroup.setTransform(pos1);
				transGroup.addChild(cube);
				Settlements.root.addChild(transGroup);
			}
		}
	}
	
	public static void setCamera(float xNew, float yNew, float zNew, float yawNew, float pitchNew) {
		if(xNew>xMax) {xNew = xMax;}
		if(yNew>yMax) {yNew = yMax;}
		if(zNew>zMax) {zNew = zMax;}
		if(yawNew>360) {yawNew = yawNew-360;}
		if(pitchNew>360) {pitchNew = pitchNew-360;}
		if(xNew<-xMax) {xNew = -xMax;}
		if(yNew<-yMax) {yNew = -yMax;}
		if(zNew<-zMax) {zNew = -zMax;}
		if(yawNew<0) {yawNew = yawNew+360;}
		if(pitchNew<0) {pitchNew = pitchNew+360;}
		x = xNew;
		y = yNew;
		z = zNew;
		yaw = yawNew;
		pitch = pitchNew;
		Transform3D transform = new Transform3D();
		transform.setTranslation(new Vector3f(x, y, z));
                
        Transform3D xRotation = new Transform3D();
        xRotation.rotX((float)Math.toRadians(pitch));

        Transform3D yRotation = new Transform3D();
        yRotation.rotY((float)Math.toRadians(yaw));

        yRotation.mul(xRotation);
        transform.mul(yRotation);
        
		Settlements.universe.getViewingPlatform().getViewPlatformTransform().setTransform(transform);
	}
	
	/**
	 * 
	 * @param xAdd - The addition to the camera's x
	 * @param yAdd - The addition to the camera's y
	 * @param zAdd - The addition to the camera's z
	 * @param yawAdd - The addition to the camera's yaw
	 * @param pitchAdd - The addition to the camera's pitch
	 */
	public static void moveCamera(float xAdd, float yAdd, float zAdd, float yawAdd, float pitchAdd) {
		float xNew;
		float yNew;
		float zNew;
		float yawNew;
		float pitchNew;
		xNew = x + xAdd;
		yNew = y + yAdd;
		zNew = z + zAdd;
		yawNew = yaw + yawAdd;
		pitchNew = pitch + pitchAdd;
		setCamera(xNew, yNew, zNew, yawNew, pitchNew);
	}

	
}
