import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameLauncher extends StateBasedGame {

    public GameLauncher(String title) {
        super(title);
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
       //list other screens in here - first one is opening screen
       this.addState(new TitleScreen());
       this.addState(new Controls());
       this.addState(new Level1());
       this.addState(new Level2());
       this.addState(new Level3());
       this.addState(new Player1Win());
       this.addState(new Player2Win());
       
    }

    public static void main(String args[]) throws SlickException {
        GameLauncher game = new GameLauncher("The Mandalorian");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 640, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}