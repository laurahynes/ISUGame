import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Level2 extends BasicGameState {

    private Image mainImg;
    //make into players child   
    MandalorianPlayer player1;
    StormtrooperPlayer player2;
    MandLazer ml;
    StormLazer sl;
    
    //mandlazer x and y
    int mx;
    int my;
    
    //stormlazer x and y
    int sx;
    int sy;
    
    boolean isMandShooting=false;
    
    boolean isStormShooting=false;
    
    Rectangle topbar;
    
    String player1Health, player2Health;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       mainImg = new Image("images/Level Backgrounds/Level 2.png");      
       player1 = new MandalorianPlayer(10,30);
       player2 = new StormtrooperPlayer(780,600); 
       
       topbar = new Rectangle(0,0,805,20);
       
       player1Health = "Player 1: " + player1.getHealth();
       player2Health = "Player 2: " + player2.getHealth();
       
       //sets lazer x and y to players x and y
       mx = player1.getX();
       my = player1.getY();
       
       sx = player2.getX();
       sy = player2.getY();
       
       ml = new MandLazer(mx + 5, my, 2);
       
       sl = new StormLazer(sx + 5, sy, 2);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();        
        player2.move(in);
        player1.move(in);        
        
        /////////////////////////////////PLAYER 1//////////////////////////////////          
        //checking to see if walking off screen, sets location so that you cant
        if(player1.isHittingLeft(player1.getX())){            
            player1.setX(2);            
        }
        if(player1.isHittingRight(player1.getX())){
            player1.setX(794);
        }
        if(player1.isHittingTop(player1.getY())){
            player1.setY(24);
        }
        if(player1.isHittingBottom(player1.getY())){
            player1.setY(634);
        }
        //enter to shoot
        if(in.isKeyDown(Input.KEY_ENTER) && !isMandShooting){
            mx = player1.getX();
            my = player1.getY();
            ml.setPosition(mx, my);           
            isMandShooting = true;
        }
        //checks what direction the player is facing to produce the correct image for lazer, and correct x and y locations for lazer
        if(isMandShooting){
            ml.setDir(player1.getDir());
            Rectangle bx = ml.getBox();
            
            //shooting down
            if(player1.getDir() == 0){
            ml.setPosition((int)bx.getX(), (int)(bx.getY() + 10));
            if(bx.getY() > 660)                
                isMandShooting=false;
            }
            
            //shooting left
            if(player1.getDir() == 1){
            ml.setPosition((int)bx.getX() - 10, (int)(bx.getY()));
            if(bx.getX() < -20)                
                isMandShooting=false;
            }
            
            //shooting right
            if(player1.getDir() == 2){
            ml.setPosition((int)bx.getX() + 10, (int)(bx.getY()));
            if(bx.getX() > 850)                
                isMandShooting=false;
            }
            
            //shooting up
            if(player1.getDir() == 3){
            ml.setPosition((int)bx.getX(), (int)(bx.getY() - 10));
            if(bx.getY() < -20)                
                isMandShooting=false;
            }
            
            //reading to see if lazer is hitting player 2
            if(ml.hit(player2.hitbox)){        
                isMandShooting=false;
                ml.setPosition(-100, -100);
                
                player2.setHealth((player2.getHealth()) - 1); 
                
                player2Health = "Player 2: " + player2.getHealth();
            }
        }
        
        //////////////////////////PLAYER 2///////////////////////////////
        
        //checking to see if walking off screen, sets location so that you cant
        if(player2.isHittingLeft(player2.getX())){            
            player2.setX(2);            
        }
        if(player2.isHittingRight(player2.getX())){
            player2.setX(794);
        }
        if(player2.isHittingTop(player2.getY())){
            player2.setY(24);
        }
        if(player2.isHittingBottom(player2.getY())){
            player2.setY(634);
        }
        //space to shoot
        if(in.isKeyDown(Input.KEY_SPACE) && !isStormShooting){
            sx = player2.getX();
            sy = player2.getY();
            sl.setPosition(sx, sy);           
            isStormShooting = true;
        }
        //checks what direction the player is facing to produce the correct image for lazer, and correct x and y locations for lazer
        if(isStormShooting){
            sl.setDir(player2.getDir());
            Rectangle bx = sl.getBox();
            
            //shooting down
            if(player2.getDir() == 0){
            sl.setPosition((int)bx.getX(), (int)(bx.getY() + 10));
            if(bx.getY() > 660)                
                isStormShooting=false;
            }
            
            //shooting left
            if(player2.getDir() == 1){
            sl.setPosition((int)bx.getX() - 10, (int)(bx.getY()));
            if(bx.getX() < -20)                
                isStormShooting=false;
            }
            
            //shooting right
            if(player2.getDir() == 2){
            sl.setPosition((int)bx.getX() + 10, (int)(bx.getY()));
            if(bx.getX() > 850)                
                isStormShooting=false;
            }
            
            //shooting up
            if(player2.getDir() == 3){
            sl.setPosition((int)bx.getX(), (int)(bx.getY() - 10));
            if(bx.getY() < -20)                
                isStormShooting=false;
            }
            
            //reading to see if lazer is hitting player 1
            if(sl.hit(player1.hitbox)){    
                isStormShooting=false;
                sl.setPosition(-100, -100);
                
                player1.setHealth((player1.getHealth()) - 1);      
                
                player1Health = "Player 1: " + player1.getHealth();
            }
        }
        
        
        //when a player dies go to next level
        if(player1.isDead(player1.getHealth())){
            player2.win();
            sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
        }
        
        if(player2.isDead(player2.getHealth())){
            player1.win();
            sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input kb = gc.getInput();
       mainImg.draw(0, 0);       
       player2.draw();
       player1.draw();    
       
       g.setColor(Color.black);
       g.fill(topbar);
       g.draw(topbar);
       
       g.setColor(Color.white);
       g.drawString(player1Health, 10, 0);
       
       g.drawString(player2Health, 680, 0);
       
       //only draws lazer if player is shooting
      if(isMandShooting)
            ml.draw();
      
      if(isStormShooting)
          sl.draw();      
    }

    
    public int getID() {
       return 3;  //this id will be different for each screen
    }

    
}