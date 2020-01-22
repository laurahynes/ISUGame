
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;


public class StormtrooperPlayer extends Players {
    
     Animation ani[] = new Animation[4];
     Image walk[][] = new Image[4][4];
     Image stopImage[] = new Image[4];
     SpriteSheet gsprite;
     boolean stopped;
     Rectangle hitbox;
     int dir; //0 = d, 1 = L, 2 = r, 3 = u
     
     int health = 4;
     int wins = 0;

    public StormtrooperPlayer(int x, int y) throws SlickException {
        super(x, y);
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
        dir = 1;
    }

    @Override
    public void move(Input kb) {
        stopped = false;
        int x = (int)hitbox.getX();
        int y = (int)hitbox.getY();
        int origx = x, origy = y;
        
        //wasd to move
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
    }
    
    public void draw(){
        //draws animation while walking
        if(stopped){
            ani[dir].stop();
            stopImage[dir].draw(hitbox.getX() - 12, hitbox.getY() - 12);
        } else{
            ani[dir].start();
            ani[dir].draw(hitbox.getX() - 12, hitbox.getY() - 12);
        }
    }

    public int getHealth() {
        return health;
    }
    
    public int getX() {
        return (int) hitbox.getX();
    }

    public int getY() {
        return (int) hitbox.getY();
    }

    public void setX(int x) {
        hitbox.setX(x);
    }

    public void setY(int y) {
        hitbox.setY(y);
    }
    
    public int getDir(){
        return dir;
    }
    
    public void setHealth(int hp){
        health = hp;
    }
    
    public void win(){
        wins++;
    }
    
    public int getWins(){
        return wins;
    }
    
}
