import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Player2Win extends BasicGameState {

    private Image mainImg;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       mainImg = new Image("images/Level Backgrounds/player2Wins.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       mainImg.draw();
    }
    
    public int getID() {
       return 6;  //this id will be different for each screen
    }

    
}
