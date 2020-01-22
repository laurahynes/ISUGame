
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

abstract public class Lazers {

    //needs images, speed they move, damage they do for each round
    protected Rectangle hitbox;    
    protected Image image;

    public Lazers(int lx, int ly, Image img) {
        image = img;
        if (this instanceof MandLazer == false && this instanceof StormLazer == false)
            hitbox = new Rectangle(lx, ly, image.getWidth(), image.getHeight());
                
    }          

    //reads to see if lazer is hitting player hitbox
    public boolean hit(Rectangle hb) {
        if (hitbox.intersects(hb)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void setPosition(int lx, int ly){
        hitbox.setX(lx);
        hitbox.setY(ly);
    }
    
    public Rectangle getBox(){
        return hitbox;
    }        

    public void draw() {
        image.draw(hitbox.getX(), hitbox.getY());
    }
}
