
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

//interacts with mouse, draw, update, only on title screen

public class Buttons {
    protected Rectangle hitbox;
    protected Image image;
    
    public Buttons(int x, int y, Image imgname) throws SlickException{
        image = imgname;
        hitbox = new Rectangle(x, y, image.getHeight(), image.getWidth());
    }
    
   public boolean hit(int mx, int my){
        return hitbox.contains(mx, my);
    }
    
    public void draw(){
        image.draw(hitbox.getX(), hitbox.getY());
    }    
}
