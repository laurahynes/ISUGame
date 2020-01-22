import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Controls extends BasicGameState {
    
    private Image mainImg;
    private Buttons b1;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       mainImg = new Image("images/Level Backgrounds/cntrlscreen.png");
       b1 = new Buttons(20,500, new Image("images/Buttons/return.png"));
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        //need to add return button, also update controls screen image
        
        Input input = gc.getInput();
        
        //read in mouse coords
        int mx = input.getMouseX(), my = input.getMouseY();
        
        //return button, goes to title screen
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && b1.hit(mx, my)) {
            sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       mainImg.draw(0, 0);
       b1.draw();
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}