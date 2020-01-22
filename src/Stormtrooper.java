import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Stormtrooper {
    private Animation ani[] = new Animation[4];
    private Image walk[][] = new Image[4][4];
    private Image stopImage[] = new Image[4];
    private SpriteSheet gsprite;
    private boolean stopped;
    private Rectangle hitbox;
    private int dir; //0 = d, 1 = L, 2 = r, 3 = u
    
    public Stormtrooper(int x, int y) throws SlickException{
        gsprite = new SpriteSheet("images/stormtrooper.png", 32, 48);
        gsprite.startUse();
        for (int i = 0; i < 4; i++) {
            stopImage[i] = gsprite.getSubImage(0, i);
            for (int j = 0; j < 4; j++) {
                walk[i][j] = gsprite.getSubImage(j, i);
            }
            ani[i] = new Animation(walk[i], 100);
        }
        gsprite.endUse();
        hitbox = new Rectangle(x, y, 26, 30);
        stopped = true;
        dir = 2;
    }
    
     public void move(Input kb){
        stopped = false;
        int x = (int)hitbox.getX();
        int y = (int)hitbox.getY();
        int origx = x, origy = y;
        
        if(kb.isKeyDown(Input.KEY_D)){
            x++;
            dir = 2;
        } else if(kb.isKeyDown(Input.KEY_A)){
            x--;
            dir = 1;
        }else if(kb.isKeyDown(Input.KEY_S)){
            y++;
            dir = 0;
        }else if(kb.isKeyDown(Input.KEY_W)){
            y--;
            dir = 3;
        }else{
            stopped = true;
        }
        hitbox.setX(x);
        hitbox.setY(y);
        
        /*if(isHitting(walls)){
            hitbox.setX(origx);
            hitbox.setY(origy);
        }*/
    }
    
    public boolean isHitting(ArrayList<Rectangle> rect){
        for (Rectangle r : rect) {
            if(hitbox.intersects(r)){
                return true;
            }
        }
        return false;
    }
    
    /*public boolean isHitting(GameObject go){
        return hitbox.intersects(go.getHitBox());
    }*/
    
    public void draw(){
        if(stopped){
            ani[dir].stop();
            stopImage[dir].draw(hitbox.getX() - 12, hitbox.getY() - 12);
        } else{
            ani[dir].start();
            ani[dir].draw(hitbox.getX() - 12, hitbox.getY() - 12);
        }
    }
}

