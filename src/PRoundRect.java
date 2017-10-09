import java.awt.*;


public class PRoundRect implements PShape
{
    int x1, y1, x2, y2;
    int clr, width;

    public PRoundRect(int x1, int y1, int x2, int y2, int clr, int width)
    {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.clr = clr;
        this.width = width;
    }

    public void draw(Graphics2D gg)
    {
        gg.setStroke(new BasicStroke(width));
        gg.setColor(new Color(clr));
        gg.drawRoundRect(x1,y1,x2-x1,y2-y1,20,20);
    }
}
