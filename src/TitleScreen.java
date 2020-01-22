
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class TitleScreen extends BasicGameState {

    private Image mainImg;
    private Buttons b1, b2;       

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mainImg = new Image("images/Level Backgrounds/titlescreen.png");
        b1 = new Buttons(20, 200, new Image("images/buttons/controls.png"));
        b2 = new Buttons(600, 200, new Image("images/buttons/start.png"));                
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput(); 
        

        //read in mouse coords
        int mx = input.getMouseX(), my = input.getMouseY();

        //start button goes to level 1, control button goes to control screen
        //b1 = control btn, b2 = start btn
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (b2.hit(mx, my)) {
                sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());                
            } else if (b1.hit(mx, my)) {
                sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());                
            }
        }

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mainImg.draw(0, 0);
        b1.draw();
        b2.draw();                
    }

    public int getID() {
        return 0;  //this id will be different for each screen
    }

}
