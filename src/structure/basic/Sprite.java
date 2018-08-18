package structure.basic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Sprite extends Component{
    private static final int maxCount = 5;
    private int count;
    private BufferedImage[] images;
    private int currentIndex;

    public Sprite(String[] imagePaths) {
        this.count = 0;
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

    public void animate() {
        this.currentIndex = (this.currentIndex + 1) % images.length;
    }

    public BufferedImage getImage() {
        // for every "maxCount" times of repainting, animate once.
        if (this.count == maxCount - 1) this.animate();
        this.count = (this.count + 1) % maxCount;

        return this.images[this.currentIndex];
    }
}
