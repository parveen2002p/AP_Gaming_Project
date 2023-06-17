package Buttons_Label;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.MyGdxGame;

import java.io.Serializable;

public class MusicButton implements Serializable {
    Texture texture;
    TextureRegion textureRegion;
    TextureRegionDrawable textureRegionDrawable;
    public ImageButton button;
    MyGdxGame game;

    public MusicButton(final MyGdxGame game) {
        this.game=game;
        this.texture = new Texture(Gdx.files.internal("Music.png"));
        textureRegion = new TextureRegion(texture);
        textureRegionDrawable= new TextureRegionDrawable(textureRegion);
        button = new ImageButton(textureRegionDrawable);
        button.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if (button.isPressed()){
                    System.out.println("YEES PRESSED");
                    //game.setWarScreen();
                    return true;
                }
                return false;
            }
        });
        //setBounds();
        button.setBounds(500,200,400,400);
    }
}


