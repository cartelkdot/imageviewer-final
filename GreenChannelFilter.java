import java.awt.Color;
/**
 * Write a description of class GreenChannelFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreenChannelFilter extends Filter
{
  /**
  * Constructor for objects of class GreenChannelFilter
  */
  public GreenChannelFilter(String name)
  {
    
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
                int avg = (pix.getGreen() + pix.getBlue() + pix.getRed()) / 3;
                image.setPixel(x, y, new Color(avg, avg, avg));
            }
        }
    }
}
