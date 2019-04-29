import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class BlueChannelFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueChannelFilter extends Filter
{
    /**
     * Constructor for objects of class BlueChannelFilter
     */
    public BlueChannelFilter(String name)
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
                int avg = (pix.getBlue() + pix.getGreen() + pix.getRed()) / 3;
                image.setPixel(x, y, new Color(avg, avg, avg));
            }
        }
    }
}
