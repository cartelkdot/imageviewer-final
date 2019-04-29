import java.awt.Color;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * Write a description of class Warhol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Warhol extends Filter
{
    // instance variables - replace the example below with your own
   private OFImage currentImage;
   private ImagePanel imagePanel;
   private JFrame frame;
    /**
     * Constructor for objects of class Warhol
     */
    public Warhol(String name)
   {
        // initialise instance variables
        super(name);
   }

     /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
    int height = image.getHeight();
    int width = image.getWidth();
    for(int y = 0; y < height; y++) {
       for(int x = 0; x < width; x++) {
        Color pix = image.getPixel(x, y);
        int avg = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3;
        image.setPixel(x, y, new Color(avg, avg, avg));
       }
    }
    
    for(int y = 0; y < height; y++) {
       for(int x = 0; x < width; x++) {
        Color pix = image.getPixel(x, y);
        int avg = (pix.getBlue() + pix.getGreen() + pix.getRed()) / 3;
        image.setPixel(x, y, new Color(avg, avg, avg));
       }
    }
    
    for(int y = 0; y < height; y++) {
       for(int x = 0; x < width; x++) {
        Color pix = image.getPixel(x, y);
        int avg = (pix.getGreen() + pix.getRed() + pix.getBlue()) / 3;
        image.setPixel(x, y, new Color(avg, avg, avg));
       }
    }
        if(currentImage != null) {
            // create new image with double size
            //int width = currentImage.getWidth() / 2;
            //int height = currentImage.getHeight() / 2;
            OFImage newImage = new OFImage(width, height);

            // copy pixel data into new image
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    newImage.setPixel(x, y, currentImage.getPixel(x * 2, y * 2));
                }
            }
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    newImage.setPixel(x, y, currentImage.getPixel(x * 1, y * 1));
                }
            }
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    newImage.setPixel(x, y, currentImage.getPixel(x * 3, y * 3));
                }
            }

            currentImage = newImage;
            imagePanel.setImage(currentImage);
            
    }
   }
}
