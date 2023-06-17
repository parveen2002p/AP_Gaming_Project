package Sprites;

import Screens.WarScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;

import java.io.Serializable;

public class Tank3 extends Sprite implements Serializable,TankInterface {
    public World world;
    public Body b2body;
    private TextureRegion mariostand;
    public Fixture fixture;
    public int power=100;
    public boolean setToDestroy=false;
    public boolean destroyed=false;

    public float stateTimer=0;
    public BodyDef bdef;

    public Tank3(World world, WarScreen screen){
        super(screen.getAtlas().findRegion("tanks_tankDesert3"));
        this.world=world;
        defineTank();
        mariostand = new TextureRegion(getTexture(),1,442,92,69);
        //setBounds(88,440,86/MyGdxGame.PPM,68/MyGdxGame.PPM);
        setRegion(mariostand);
    }
    public void update(float dt){

        setPosition((b2body.getPosition().x)*MyGdxGame.PPM-getWidth()/2,(b2body.getPosition().y)*MyGdxGame.PPM-getHeight()/2);

    }
    public  void  defineTank(){
        bdef = new BodyDef();
        bdef.position.set(850/ MyGdxGame.PPM,500/MyGdxGame.PPM);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(10/MyGdxGame.PPM);
        fdef.filter.categoryBits=MyGdxGame.MARIO1_BIT;
        fdef.filter.maskBits=MyGdxGame.DEFAULT_BIT | MyGdxGame.MARIO2_BIT | MyGdxGame.AGNI_BIT;
        fdef.shape=shape;
        fdef.friction=1.4f;
        fixture=b2body.createFixture(fdef);
        //b2body.setUserData("P1");
        fdef.isSensor=true;
        fixture.setUserData(this);
        setSize(37,27);
    }
    public void onHeadHit(){
        Gdx.app.log("p1 col","col p1");
        power-=1;
        //setToDestroy=true;
    }
}