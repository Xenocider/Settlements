package xenocider.settlements.graphics;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

public class Drawer {
	
	public static SimpleUniverse universe = new SimpleUniverse();
	public static BranchGroup world = new BranchGroup();
	
	public static void createCube() {

		BranchGroup group = new BranchGroup();

		group.addChild(new ColorCube(0.3));
		
		universe.addBranchGraph(group);

	}
	
	public static void createWorld() {
		for(float x=-1f;x<=1f;x = x + 0.04f) {  
			for (float z=-1f;z<=1f;z = z + 0.04f) {
				ColorCube cube = new ColorCube(0.02);
				TransformGroup transGroup = new TransformGroup();
				Transform3D pos1 = new Transform3D();
				pos1.setTranslation(new Vector3f(x,0.0f,z));
				transGroup.setTransform(pos1);
				transGroup.addChild(cube);
				world.addChild(transGroup);
			}
		}
		universe.addBranchGraph(world);
	}
	
	public static void setCamera(float x, float y, float z, float yaw, float pitch) {
		Transform3D transform = new Transform3D();
		transform.setTranslation(new Vector3f(x, y, z));
                
        Transform3D xRotation = new Transform3D();
        xRotation.rotX((float)Math.toRadians(pitch));

        Transform3D yRotation = new Transform3D();
        yRotation.rotY((float)Math.toRadians(yaw));

        yRotation.mul(xRotation);
        transform.mul(yRotation);
        
		universe.getViewingPlatform().getViewPlatformTransform().setTransform(transform);
	}
	
}
