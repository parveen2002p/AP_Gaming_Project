package Buttons_Label;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.MyGdxGame;

import java.io.Serializable;


public class EmptySlot implements Serializable {
    Texture texture;
    TextureRegion textureRegion;
    TextureRegionDrawable textureRegionDrawable;
    public ImageButton button;
    MyGdxGame game;

    public EmptySlot(final MyGdxGame game) {
        this.game=game;
        this.texture = new Texture(Gdx.files.internal("Slots.png"));
        textureRegion = new TextureRegion(texture);
        textureRegionDrawable= new TextureRegionDrawable(textureRegion);
        button = new ImageButton(textureRegionDrawable);
        button.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if (button.isPressed()){
                    game.loadSlotGame(1);
                    System.out.println("YEES in but");
                    //game.setWarScreen();
                    return true;
                }
                return false;
            }
        });
        //setBounds();
        button.setBounds(1300,400,300,300);
    }
}


