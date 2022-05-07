package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	public String path;
	public int width;
	public int height;

	public int[] pixels;

	public Spritesheet(String path) {
		BufferedImage image = null;

		try {
			image = ImageIO.read(Spritesheet.class.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (image == null) {
			return;
		}

		this.path = path;
		this.width = image.getWidth();
		this.height = image.getHeight();

		pixels = image.getRGB(0, 0, width, height, null, 0, width);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = (pixels[i] & 0xff) / 64;
		}

		for (int i = 0; i < 8; i++) {
			System.out.println(pixels[i]);
		}
	}
}
