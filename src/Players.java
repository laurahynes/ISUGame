
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

abstract public class Players {    
    
    protected Rectangle hitbox;
    protected Image img;

    public Players(int x, int y) {
    }

    abstract public void move(Input kb); //each player needs different move rules bc using different key binds             

    //checks to see if players health is zero
    public boolean isDead(int health) {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    //checks to see if player is hitting edges of screen
    public boolean isHittingLeft(int x) {
        if(x < 0){           
            return true;
        }                
        else return false;
    }
    
    public boolean isHittingRight(int x) {
        if(x > 800){           
            return true;
        }                
        else return false;
    }

    public boolean isHittingTop(int y) {
        if(y < 20){           
            return true;
        }                
        else return false;
    }
    
    public boolean isHittingBottom(int y) {
        if(y > 640){           
            return true;
        }                
        else return false;
    }
    
}
