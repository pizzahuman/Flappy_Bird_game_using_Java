package loaders;


import java.awt.image.*;
import java.io.IOException;

import javax.imageio.*;

public class GraphicsLoader {
	
	public static BufferedImage loadGraphics(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(ResourceLoader.load("/"+path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
