package Structure;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import Enum.Tag

public class Sprite extends Component{
    private GameObject parent;
    private BufferedImage[] images;
    private int currentIndex;

    public Sprite(GameObject parent, String[] imagePaths) {
        super(parent);
        this.currentIndex = 0;
        this.images = new BufferedImage[imagePaths.length];

        for (int i = 0; i < imagePaths.length; ++i){
            try {
                this.images[i] = ImageIO.read(new File(getClass().getResource(imagePaths[i]).toURI()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

    }

    public GameObject getParent() {
        return parent;
    }

    public void animate() {
        this.currentIndex = (this.currentIndex + 1) % images.length;
    }

    public BufferedImage get() {
        return images[currentIndex];
    }
}
