import java.awt.*;
import java.io.Serializable;

/**
 * Created by Vladislav on 29.06.2017.
 */
public interface PShape extends Serializable
{
    public void draw(Graphics2D gg);
}
