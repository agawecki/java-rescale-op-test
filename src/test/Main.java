package test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;

public class Main {

  public static void main(String[] args) {
    System.out.println(System.getProperty("java.runtime.name"));

    String imageFileName = "test.png";
    try {
      File imageFile = new File(imageFileName);
      BufferedImage image = ImageIO.read(imageFile);
      rescale(image, 1.0f, 50.0f);

      File outputFile = new File(imageFile.getParent(), "rescaled-" + imageFile.getName());
      ImageIO.write(image, "png", outputFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static BufferedImage rescale(BufferedImage img,
                               float factor,
                               float offset) {
    // brightness: scale from -100..100 range to -255..255 range  (lights out ... white out)
    // don't do anything for the identity operation
    RescaleOp rescaleOp = new RescaleOp(factor, offset, null);
    return rescaleOp.filter(img, img);
  }
}

