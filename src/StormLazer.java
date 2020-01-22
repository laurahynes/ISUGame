
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class StormLazer extends Lazers {
    
    public StormLazer(int lx, int ly, int dir) throws SlickException {
        super(lx, ly, null);
        setDir(dir);
        hitbox = new Rectangle(lx, ly, image.getWidth(), image.getHeight());
    }
    
    //sees which way to shoot lazer
    // 0 = d, 1 = L, 2 = r, 3 = u
    //images are for all 4 directions
    public void setDir(int dir) throws SlickException {
        if (dir == 0) {
            image = new Image("images/Extras/slazerD.png");
        } else if (dir == 1) {
            image = new Image("images/Extras/slazerL.png");
        } else if (dir == 2) {
            image = new Image("images/Extras/slazerR.png");
        } else {
            image = new Image("images/Extras/slazerU.png");
        }
    }
}
