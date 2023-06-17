package Sprites;

import Screens.WarScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

import java.io.Serializable;


public class myhealth extends Sprite implements Serializable {
    public World world;
    public Animation animation;
    private TextureRegion healthstand;
    public int power=100;


    public float stateTimer=0;

    public myhealth(World world, WarScreen screen){
        //super(screen.getAtlas().findRegion("tanks_tankDesert3"));
        stateTimer=0;
        Array<TextureRegion> frames = new Array<TextureRegion>();
        int l=1;
        for (int i = 1;i<=25;i++){
            frames.add(new TextureRegion(getTexture(),l,1,64,64));
            l=l+64+3;
        }
        animation=new Animation<>(0.1f,frames);
        frames.clear();

        this.world=world;
        defineMario();
        healthstand = new TextureRegion(getTexture(),1,442,92,69);
        //setBounds(88,440,86/MyGdxGame.PPM,68/MyGdxGame.PPM);
        setRegion(healthstand);
    }
    public void update(float dt){

        setRegion(getFrame(dt));
        setSize(28,24);

    }
    public  void  defineMario(){

        setSize(37,27);
    }

    public TextureRegion getFrame(float dt){
        TextureRegion region;
        region= (TextureRegion) animation.getKeyFrame(stateTimer,true);
        stateTimer +=dt;
        return region;
    }

    }



