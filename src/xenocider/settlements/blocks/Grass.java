package xenocider.settlements.blocks;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.media.j3d.Appearance;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.TextureCubeMap;

import xenocider.settlements.Settlements;

import com.sun.j3d.utils.image.TextureLoader;

public class Grass extends Block {
	
	public static Appearance app;
	public static String imageFilePath = "/Users/ict12/Desktop/grass.png";
	private static FileInputStream fileInputStream;
	
	public static void loadTexture() throws FileNotFoundException, IOException {
		byte[] rawData = getRawBytesFromFile(imageFilePath); // some code to read raw bytes from image file
		ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(rawData));
		BufferedImage bimage = ImageIO.read(iis);
		Appearance app = new Appearance();
	    Texture tex = new TextureLoader(bimage).getTexture();
	    app.setTexture(tex);
	    TextureAttributes texAttr = new TextureAttributes();
	    texAttr.setTextureMode(TextureAttributes.MODULATE);
	    app.setTextureAttributes(texAttr);
	}
    private static byte[] getRawBytesFromFile(String path) throws FileNotFoundException, IOException {

        byte[] image;
        File file = new File(path);
        image = new byte[(int)file.length()];

        fileInputStream = new FileInputStream(file);
        fileInputStream.read(image);

        return image;
    }

}
