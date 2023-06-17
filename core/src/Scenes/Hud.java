package Scenes;

import Buttons_Label.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import jdk.javadoc.internal.doclets.formats.html.Table;

import java.awt.*;
import java.io.Serializable;

public class Hud implements Serializable {
    MyGdxGame game;
    public Stage stage;
    private Viewport viewport;
    public MainMenuButton1 IconMenuButton;
    public Slot1Button slot1Button;
    public Slot2Button slot2Button;
    public Slot3Button slot3Button;
    public Slot4Button slot4Button;
    public CancelButton cancelButton;
    private ResumeButton resumeButton;
    public CrossButton crossButton ;
    public SaveAndExitButton saveAndExitButton;
    public MainMenuButton mainMenuButton;
//    public Slot1Button slot1Button;
//    public Slot2Button slot2Button;
//    public Slot3Button slot3Button;
//    public Slot4Button slot4Button;


    public Hud (SpriteBatch sb,MyGdxGame game){
        slot1Button=new Slot1Button(game);
        slot2Button=new Slot2Button(game);
        slot3Button=new Slot3Button(game);
        slot4Button=new Slot4Button(game);
        IconMenuButton=new MainMenuButton1(game);
        mainMenuButton= new MainMenuButton(game);
        resumeButton=new ResumeButton(game);
        crossButton=new CrossButton(game);
        cancelButton=new CancelButton(game);
        saveAndExitButton=new SaveAndExitButton(game);
        viewport = new FitViewport(MyGdxGame.V_Width,MyGdxGame.V_Height,new OrthographicCamera());
        stage = new Stage(viewport,sb);
        stage.addActor(IconMenuButton.button);
        //Gdx.input.setInputProcessor(stage);
    }


}
