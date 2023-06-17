package Sprites;

import Screens.WarScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

import java.io.Serializable;

public class agni2 extends Sprite implements Serializable {
    private enum State {MOVING,BLASTING,STANDING};
    private State currentState;
    public WarScreen screen;
    public State previousState;
    public Animation agniBlasting;
    public Animation agniMoving;
    private float stateTimer;
    public boolean isBlasted;
    public World world;
    public Body b2body;
    private TextureRegion agnistand;
    public Fixture fixture;
    public static boolean setToDestroy2=false;
    public boolean nowEnd=false;
    public boolean destroyed=false;
    public Array<TextureRegion> frames = new Array<TextureRegion>();
    public float x;
    public float y;

    public agni2(World world, WarScreen screen,float x,float y){
        super(screen.getAgniAtlas().findRegion("0023"));
        this.screen=screen;
        this.x=x;
        this.y=y;
        currentState = State.MOVING;
        previousState = State.MOVING;
        stateTimer=0;
        Array<TextureRegion> frames = new Array<TextureRegion>();
        for (int i = 1;i<=1;i++){
            frames.add(new TextureRegion(screen.getStandAgni().findRegion("tank_bulletFly6"),1,1,78,20));
        }
        agniMoving=new Animation<>(0.1f,frames);
        frames.clear();
        int l=1;
        for (int i = 1;i<=25;i++){
            frames.add(new TextureRegion(getTexture(),l,1,64,64));
            l=l+64+3;
        }
        agniBlasting=new Animation<>(0.1f,frames);
        frames.clear();

        this.world=world;
        defineAgni2();
        //agnistand = new TextureRegion(getTexture(),1,442,92,69);
        setSize(586,468);
        //setBounds(88,440,586,468);
        //setRegion(agnistand);
    }

    public void update(float dt){
        stateTimer+=dt;
        if (setToDestroy2 && !destroyed){
            setSize(586,468);
            //setRegion(getFrame(dt));
            setCategoryFilter(MyGdxGame.DESTROYED_BIT);
            WarScreen.p2strikex= b2body.getPosition().x;
            WarScreen.p2strikey= b2body.getPosition().y;
            screen.calcDamage2();
            System.out.println("x"+b2body.getPosition().x);
            System.out.println(b2body.getPosition().y);
            world.destroyBody(b2body);
            destroyed=true;
            //setRegion(getFrame(dt));
            stateTimer=0;
            WarScreen.countTime=0;
            WarScreen.initialTurn=false;
            //set new region
        }
        else if (!destroyed) {
            //setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
            setPosition((b2body.getPosition().x)*MyGdxGame.PPM-getWidth()/2,(b2body.getPosition().y)*MyGdxGame.PPM-getHeight()/2);
            setRegion(getFrame(dt));
            this.flip(true,false);
            setSize(28,24);
        }
        if (destroyed && stateTimer<2.5) {
            setSize(586,468);
            //setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
            setPosition((b2body.getPosition().x)*MyGdxGame.PPM-getWidth()/2,(b2body.getPosition().y)*MyGdxGame.PPM-getHeight()/2);
            setRegion(getFrame(dt));
            WarScreen.countTime=0;
            WarScreen.initialTurn=false;
        }
    }

    public TextureRegion getFrame(float dt){
        currentState = getState();
        TextureRegion region;
        switch (currentState){
            case BLASTING:
                region= (TextureRegion) agniBlasting.getKeyFrame(stateTimer,true);
                break;
            default:
                region= (TextureRegion) agniMoving.getKeyFrame(stateTimer,true);
                break;
        }
        stateTimer = currentState==previousState ? stateTimer+dt :0;
        previousState=currentState;
        return region;
    }
    public State getState(){
        if (setToDestroy2==true){
            return State.BLASTING;
        }
        else {
            return State.MOVING;
        }
    }
    public  void  defineAgni2(){
        BodyDef bdef;
        bdef = new BodyDef();
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        //b2body.setUserData("Agni");
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/MyGdxGame.PPM);
        fdef.filter.categoryBits=MyGdxGame.AGNI_BIT2;
        fdef.filter.maskBits=MyGdxGame.DEFAULT_BIT | MyGdxGame.MARIO1_BIT ;
        fdef.shape=shape;
        fdef.density=50f;
        fdef.isSensor=true;
        fixture=b2body.createFixture(fdef);
        fixture.setUserData("Agni2");
//        EdgeShape head = new EdgeShape();
//        head.set(new Vector2(-2/MyGdxGame.PPM,7/MyGdxGame.PPM),new Vector2(2/MyGdxGame.PPM,7/MyGdxGame.PPM));
//        fdef.shape=head;
//        fdef.isSensor=true;
//        fixture.setUserData("Agni");
        //b2body.createFixture(fdef).setUserData("Agni");
    }

    public void setCategoryFilter(short filterBit){
        Filter filter = new Filter();
        filter.categoryBits=filterBit;
        fixture.setFilterData(filter);
    }

//    public void onHeadHit(){
//
//        Gdx.app.log("Agni col","col");
//        setCategoryFilter(MyGdxGame.DESTROYED_BIT);
//        setToDestroy=true;
//
//    }
    public void draw(Batch batch) {
        if (! destroyed || stateTimer < 2.5) {
            super.draw(batch);
        }
    }


}
