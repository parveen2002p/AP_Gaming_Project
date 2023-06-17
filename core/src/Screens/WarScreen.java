package Screens;
import Buttons_Label.*;
import Scenes.Hud;
import Sprites.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class WarScreen implements Screen, Serializable {
    public static boolean initialTurn=true;
    public static boolean change =false;
    public static float countTime=7;
    private float fuelA =100;
    private float fuelB = 100;
    private boolean bFired=false;
    private boolean aFired=false;
    private boolean isSaving=false;
    transient private Stage stage;

    transient private MyGdxGame game;
    public static float p1strikex;
    public static float p1strikey;
    public static float p2strikex;
    public static float p2strikey;
    private float currentHealth=300;
    private float currentHealthA=300;
    transient private OrthographicCamera gamecam;
    transient private Viewport gamePort;
    transient private Hud hud;
    transient private InputMultiplexer inputMultiplexer;
    transient private TmxMapLoader mapLoader;
    transient private TiledMap map;
    transient private OrthogonalTiledMapRenderer renderer;
    private Boolean isResumed=false;
    private Boolean isExit=false;
    transient private Texture texture;
    transient private World world;
    transient private Box2DDebugRenderer b2dr;
    transient private Tank player;
    transient private Tank2 player2;
    transient private agni missile;
    transient private agni2 missile2;
    transient private TextureAtlas atlas;

    transient private BitmapFont font;

    private int power=10;
    private int angle=10;
    transient public TextureAtlas Agniatlas;
    transient public TextureAtlas StandAgni;
    transient private Texture h1;
    transient private Texture h2;
    transient private Texture h11;
    transient private Texture h22;
    transient private Texture p1Fuelb;
    transient private Texture p1Fuelf;
    transient private Texture p2Fuelb;
    transient private Texture p2Fuelf;
    transient private Texture saving;
    transient private MainMenuButton1 IconMenuButton;
    transient private Slot1Button slot1Button;
    transient private Slot2Button slot2Button;
    transient private Slot3Button slot3Button;
    transient private Slot4Button slot4Button;
    //private ResumeButton resumeButton;
    transient private SaveAndExitButton saveAndExitButton;
    transient private MainMenuButton mainMenuButton;
    transient private CrossButton crossButton;
    transient private CancelButton cancelButton;
    private String T1name;
    private String T2name;
    transient private SimpleDateFormat formatter;
    private Date date;

    public static boolean isInitialTurn() {
        return initialTurn;
    }

    public static void setInitialTurn(boolean initialTurn) {
        WarScreen.initialTurn = initialTurn;
    }

    public static boolean isChange() {
        return change;
    }

    public static void setChange(boolean change) {
        WarScreen.change = change;
    }

    public static float getCountTime() {
        return countTime;
    }

    public static void setCountTime(float countTime) {
        WarScreen.countTime = countTime;
    }

    public float getFuelA() {
        return fuelA;
    }

    public void setFuelA(float fuelA) {
        this.fuelA = fuelA;
    }

    public float getFuelB() {
        return fuelB;
    }

    public void setFuelB(float fuelB) {
        this.fuelB = fuelB;
    }

    public boolean isbFired() {
        return bFired;
    }

    public void setbFired(boolean bFired) {
        this.bFired = bFired;
    }

    public boolean isaFired() {
        return aFired;
    }

    public void setaFired(boolean aFired) {
        this.aFired = aFired;
    }

    public boolean isSaving() {
        return isSaving;
    }

    public void setSaving(boolean saving) {
        isSaving = saving;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public MyGdxGame getGame() {
        return game;
    }

    public void setGame(MyGdxGame game) {
        this.game = game;
    }

    public static float getP1strikex() {
        return p1strikex;
    }

    public static void setP1strikex(float p1strikex) {
        WarScreen.p1strikex = p1strikex;
    }

    public static float getP1strikey() {
        return p1strikey;
    }

    public static void setP1strikey(float p1strikey) {
        WarScreen.p1strikey = p1strikey;
    }

    public static float getP2strikex() {
        return p2strikex;
    }

    public static void setP2strikex(float p2strikex) {
        WarScreen.p2strikex = p2strikex;
    }

    public static float getP2strikey() {
        return p2strikey;
    }

    public static void setP2strikey(float p2strikey) {
        WarScreen.p2strikey = p2strikey;
    }

    public float getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(float currentHealth) {
        this.currentHealth = currentHealth;
    }

    public float getCurrentHealthA() {
        return currentHealthA;
    }

    public void setCurrentHealthA(float currentHealthA) {
        this.currentHealthA = currentHealthA;
    }

    public OrthographicCamera getGamecam() {
        return gamecam;
    }

    public void setGamecam(OrthographicCamera gamecam) {
        this.gamecam = gamecam;
    }

    public Viewport getGamePort() {
        return gamePort;
    }

    public void setGamePort(Viewport gamePort) {
        this.gamePort = gamePort;
    }

    public Hud getHud() {
        return hud;
    }

    public void setHud(Hud hud) {
        this.hud = hud;
    }

    public InputMultiplexer getInputMultiplexer() {
        return inputMultiplexer;
    }

    public void setInputMultiplexer(InputMultiplexer inputMultiplexer) {
        this.inputMultiplexer = inputMultiplexer;
    }

    public TmxMapLoader getMapLoader() {
        return mapLoader;
    }

    public void setMapLoader(TmxMapLoader mapLoader) {
        this.mapLoader = mapLoader;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(OrthogonalTiledMapRenderer renderer) {
        this.renderer = renderer;
    }

    public Boolean getResumed() {
        return isResumed;
    }

    public void setResumed(Boolean resumed) {
        isResumed = resumed;
    }

    public Boolean getExit() {
        return isExit;
    }

    public void setExit(Boolean exit) {
        isExit = exit;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Box2DDebugRenderer getB2dr() {
        return b2dr;
    }

    public void setB2dr(Box2DDebugRenderer b2dr) {
        this.b2dr = b2dr;
    }

    public Tank getPlayer() {
        return player;
    }

    public void setPlayer(Tank player) {
        this.player = player;
    }

    public Tank2 getPlayer2() {
        return player2;
    }

    public void setPlayer2(Tank2 player2) {
        this.player2 = player2;
    }

    public agni getMissile() {
        return missile;
    }

    public void setMissile(agni missile) {
        this.missile = missile;
    }

    public agni2 getMissile2() {
        return missile2;
    }

    public void setMissile2(agni2 missile2) {
        this.missile2 = missile2;
    }

    public void setAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public TextureAtlas getAgniatlas() {
        return Agniatlas;
    }

    public void setAgniatlas(TextureAtlas agniatlas) {
        Agniatlas = agniatlas;
    }

    public void setStandAgni(TextureAtlas standAgni) {
        StandAgni = standAgni;
    }

    public Texture getH1() {
        return h1;
    }

    public void setH1(Texture h1) {
        this.h1 = h1;
    }

    public Texture getH2() {
        return h2;
    }

    public void setH2(Texture h2) {
        this.h2 = h2;
    }

    public Texture getH11() {
        return h11;
    }

    public void setH11(Texture h11) {
        this.h11 = h11;
    }

    public Texture getH22() {
        return h22;
    }

    public void setH22(Texture h22) {
        this.h22 = h22;
    }

    public Texture getP1Fuelb() {
        return p1Fuelb;
    }

    public void setP1Fuelb(Texture p1Fuelb) {
        this.p1Fuelb = p1Fuelb;
    }

    public Texture getP1Fuelf() {
        return p1Fuelf;
    }

    public void setP1Fuelf(Texture p1Fuelf) {
        this.p1Fuelf = p1Fuelf;
    }

    public Texture getP2Fuelb() {
        return p2Fuelb;
    }

    public void setP2Fuelb(Texture p2Fuelb) {
        this.p2Fuelb = p2Fuelb;
    }

    public Texture getP2Fuelf() {
        return p2Fuelf;
    }

    public void setP2Fuelf(Texture p2Fuelf) {
        this.p2Fuelf = p2Fuelf;
    }

    public Texture getSaving() {
        return saving;
    }

    public void setSaving(Texture saving) {
        this.saving = saving;
    }

    public MainMenuButton1 getIconMenuButton() {
        return IconMenuButton;
    }

    public void setIconMenuButton(MainMenuButton1 iconMenuButton) {
        IconMenuButton = iconMenuButton;
    }

    public Slot1Button getSlot1Button() {
        return slot1Button;
    }

    public void setSlot1Button(Slot1Button slot1Button) {
        this.slot1Button = slot1Button;
    }

    public Slot2Button getSlot2Button() {
        return slot2Button;
    }

    public void setSlot2Button(Slot2Button slot2Button) {
        this.slot2Button = slot2Button;
    }

    public Slot3Button getSlot3Button() {
        return slot3Button;
    }

    public void setSlot3Button(Slot3Button slot3Button) {
        this.slot3Button = slot3Button;
    }

    public Slot4Button getSlot4Button() {
        return slot4Button;
    }

    public void setSlot4Button(Slot4Button slot4Button) {
        this.slot4Button = slot4Button;
    }

    public SaveAndExitButton getSaveAndExitButton() {
        return saveAndExitButton;
    }

    public void setSaveAndExitButton(SaveAndExitButton saveAndExitButton) {
        this.saveAndExitButton = saveAndExitButton;
    }

    public MainMenuButton getMainMenuButton() {
        return mainMenuButton;
    }

    public void setMainMenuButton(MainMenuButton mainMenuButton) {
        this.mainMenuButton = mainMenuButton;
    }

    public CrossButton getCrossButton() {
        return crossButton;
    }

    public void setCrossButton(CrossButton crossButton) {
        this.crossButton = crossButton;
    }

    public CancelButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(CancelButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public String getT1name() {
        return T1name;
    }

    public void setT1name(String t1name) {
        T1name = t1name;
    }

    public String getT2name() {
        return T2name;
    }

    public void setT2name(String t2name) {
        T2name = t2name;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
//    public DateTimeFormatter dtf;
//    public LocalDateTime now;

    public WarScreen(MyGdxGame game,String tank1,String tank2) {
        T1name=tank1;
        T2name=tank2;
//         dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//         now = LocalDateTime.now();
        font = new BitmapFont();
         formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         date = new Date();
        Pixmap pixmap = createProceduralPixmap(1, 1,0,1,0);
        Pixmap pixmap2 = createProceduralPixmap(1, 1,1,0,0);
         h1 = new Texture(pixmap);
         h2 = new Texture(pixmap2);
        h11 = new Texture(pixmap);
        h22 = new Texture(pixmap2);
        p1Fuelb = new Texture(pixmap);
        p1Fuelf = new Texture(pixmap2);
        p2Fuelb = new Texture(pixmap);
        p2Fuelf = new Texture(pixmap2);

        this.game = game;
        atlas=new TextureAtlas("mypack.atlas");

       Agniatlas = new TextureAtlas("flame4.atlas");
        StandAgni= new TextureAtlas("standAgni.atlas");

        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MyGdxGame.V_Width/MyGdxGame.PPM, MyGdxGame.V_Height/MyGdxGame.PPM, gamecam);
        hud = new Hud(game.batch,game);
        mapLoader = new TmxMapLoader();
        texture = new Texture(Gdx.files.internal("PauseScreen.png"));
        saving = new Texture(Gdx.files.internal("SlotScreen.png"));
        map = mapLoader.load("Zone.tmx");
        renderer = new OrthogonalTiledMapRenderer(map,1/MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();
//        stage.setViewport(gamePort);
//        stage.addActor(mainMenuButton.button);
//        stage=new Stage();
        inputMultiplexer=new InputMultiplexer();
//        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor((hud.stage));
        slot1Button=new Slot1Button(game);
        slot2Button=new Slot2Button(game);
        slot3Button=new Slot3Button(game);
        slot4Button=new Slot4Button(game);
        IconMenuButton=new MainMenuButton1(game);
        mainMenuButton= new MainMenuButton(game);
        crossButton=new CrossButton(game);
        cancelButton=new CancelButton(game);
        saveAndExitButton=new SaveAndExitButton(game);
//        game.stage.setViewport(gamePort);
//        game.stage.addActor(IconMenuButton.button);
        Gdx.input.setInputProcessor(inputMultiplexer);
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;
//        for (MapObject object : map.getLayers().get(2).getObjects().getByType(PolygonMapObject.class)){
//            Polygon poly = ((PolygonMapObject) object).getPolygon();
//            bdef.type= BodyDef.BodyType.StaticBody;
//            bdef.position.set(poly.getX()+poly.getBoundingRectangle().getWidth()/2,poly.getY()+poly.getBoundingRectangle().getHeight()/4);
//            body = world.createBody(bdef);
//            shape = getPolygon((PolygonMapObject)object);
//
//            //shape.setAsBox(poly.getBoundingRectangle().getWidth()/2,poly.getBoundingRectangle().getHeight()/2);
//            fdef.shape=shape;
//            body.createFixture(fdef);
//        }


        for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle poly = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((poly.getX() + poly.getWidth() / 2)/MyGdxGame.PPM, (poly.getY() + poly.getHeight() / 2)/MyGdxGame.PPM);
            body = world.createBody(bdef);


            shape.setAsBox((poly.getWidth() / 2)/MyGdxGame.PPM, (poly.getHeight() / 2)/MyGdxGame.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);

        }
        player = new Tank(world,this,tank1);
        player2 = new Tank2(world,this,tank2);
//        player.b2body.setActive(false);
//        player2.b2body.setActive(false);
//        missile = new agni(world,this);
        world.setContactListener(new WorldContactListener());
    }

    public void Setup(MyGdxGame game){
        font = new BitmapFont();
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
        Pixmap pixmap = createProceduralPixmap(1, 1,0,1,0);
        Pixmap pixmap2 = createProceduralPixmap(1, 1,1,0,0);
        h1 = new Texture(pixmap);
        h2 = new Texture(pixmap2);
        h11 = new Texture(pixmap);
        h22 = new Texture(pixmap2);
        p1Fuelb = new Texture(pixmap);
        p1Fuelf = new Texture(pixmap2);
        p2Fuelb = new Texture(pixmap);
        p2Fuelf = new Texture(pixmap2);

        this.game = game;
        atlas=new TextureAtlas("mypack.atlas");
        Agniatlas = new TextureAtlas("flame4.atlas");
        StandAgni= new TextureAtlas("standAgni.atlas");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MyGdxGame.V_Width/MyGdxGame.PPM, MyGdxGame.V_Height/MyGdxGame.PPM, gamecam);
        hud = new Hud(game.batch,game);
        mapLoader = new TmxMapLoader();
        texture = new Texture(Gdx.files.internal("PauseScreen.png"));
        saving = new Texture(Gdx.files.internal("SlotScreen.png"));
        map = mapLoader.load("Zone.tmx");
        renderer = new OrthogonalTiledMapRenderer(map,1/MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();
//        stage.setViewport(gamePort);
//        stage.addActor(mainMenuButton.button);
//        stage=new Stage();
        inputMultiplexer=new InputMultiplexer();
//        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor((hud.stage));
        slot1Button=new Slot1Button(game);
        slot2Button=new Slot2Button(game);
        slot3Button=new Slot3Button(game);
        slot4Button=new Slot4Button(game);
        IconMenuButton=new MainMenuButton1(game);
        mainMenuButton= new MainMenuButton(game);
        crossButton=new CrossButton(game);
        saveAndExitButton=new SaveAndExitButton(game);
        cancelButton=new CancelButton(game);
//        game.stage.setViewport(gamePort);
//        game.stage.addActor(IconMenuButton.button);
        Gdx.input.setInputProcessor(inputMultiplexer);
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;
//        for (MapObject object : map.getLayers().get(2).getObjects().getByType(PolygonMapObject.class)){
//            Polygon poly = ((PolygonMapObject) object).getPolygon();
//            bdef.type= BodyDef.BodyType.StaticBody;
//            bdef.position.set(poly.getX()+poly.getBoundingRectangle().getWidth()/2,poly.getY()+poly.getBoundingRectangle().getHeight()/4);
//            body = world.createBody(bdef);
//            shape = getPolygon((PolygonMapObject)object);
//
//            //shape.setAsBox(poly.getBoundingRectangle().getWidth()/2,poly.getBoundingRectangle().getHeight()/2);
//            fdef.shape=shape;
//            body.createFixture(fdef);
//        }


        for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle poly = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((poly.getX() + poly.getWidth() / 2)/MyGdxGame.PPM, (poly.getY() + poly.getHeight() / 2)/MyGdxGame.PPM);
            body = world.createBody(bdef);


            shape.setAsBox((poly.getWidth() / 2)/MyGdxGame.PPM, (poly.getHeight() / 2)/MyGdxGame.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);

        }
        player = new Tank(world,this,this.T1name);
        player2 = new Tank2(world,this,this.T2name);
//        player.b2body.setActive(false);
//        player2.b2body.setActive(false);
//        missile = new agni(world,this);
        world.setContactListener(new WorldContactListener());

    }


//    private static PolygonShape getPolygon(PolygonMapObject polygonObject) {
//        PolygonShape polygon = new PolygonShape();
//        float[] vertices = polygonObject.getPolygon().getTransformedVertices();
//
//        float[] worldVertices = new float[vertices.length];
//
//        for (int i = 0; i < vertices.length; ++i) {
//            System.out.println(vertices[i]);
//            worldVertices[i] = vertices[i]/100;
//        }
//
//        polygon.set(worldVertices);
//        return polygon;
//    }

    public TextureAtlas getAtlas() {
        return atlas;
    }
    public TextureAtlas getAgniAtlas() {
        return Agniatlas;
    }
    public TextureAtlas getStandAgni(){
        return StandAgni;
    }
//    public void changeTurn(){
//        if (whooseTurn) {
//            player.b2body.setActive(false);
//            player2.b2body.setActive(true);
//            whooseTurn=false;
//        }
//        else {
//            player2.b2body.setActive(false);
//            player.b2body.setActive(true);
//            whooseTurn=true;
//        }
//    }

    @Override
    public void show() {
        stage = new Stage();
        inputMultiplexer.addProcessor(stage);
        stage.setViewport(gamePort);
        Gdx.input.setInputProcessor(inputMultiplexer);
        stage.addActor(IconMenuButton.button);
//        stage.addActor(slot1Button.button);
//        stage.addActor(slot2Button.button);
//        stage.addActor(slot3Button.button);
//        stage.addActor(slot4Button.button);

    }
    public void handleInput(float dt){
        if (change==false) {
//            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
//                player.b2body.applyLinearImpulse(new Vector2(0, 4f), player.b2body.getWorldCenter(), true);
//            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2 && fuelA>0) {
                fuelA-=dt*30;
                player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x <= 2 && fuelA>0) {
                fuelA-=dt*30;
                player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                missile=null;
                agni.setToDestroy=false;
                missile = new agni(world, this, player.b2body.getPosition().x, player.b2body.getPosition().y);
                missile.b2body.applyLinearImpulse(new Vector2(getLaunchingPower(), getLaunchingAngle()), player.b2body.getWorldCenter(), true);
            aFired=true;
            }
//            if(mainMenuButton.button.isPressed()){
//
//            }
        }
        else if (change==true) {
//            if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
//                player2.b2body.applyLinearImpulse(new Vector2(0, 4f), player2.b2body.getWorldCenter(), true);
//            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2 && fuelB>0) {
                player2.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player2.b2body.getWorldCenter(), true);
                fuelB-=dt*30;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x <= 2 && fuelB>0) {
                player2.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player2.b2body.getWorldCenter(), true);
                fuelB-=dt*30;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                missile2=null;
                agni2.setToDestroy2=false;
                missile2 = new agni2(world, this, player2.b2body.getPosition().x, player2.b2body.getPosition().y);
                missile2.b2body.applyLinearImpulse(new Vector2(-getLaunchingPower(), getLaunchingAngle()), player2.b2body.getWorldCenter(), true);
                bFired=true;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)  && Gdx.input.isKeyJustPressed(Input.Keys.UP) && power<=90){
            power+=10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)  && Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && power>=4){
            power-=10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)  && Gdx.input.isKeyJustPressed(Input.Keys.UP) && angle<=90){
            angle+=10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)  && Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && angle>=6){
            angle-=10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && isExit){
            isResumed=false;
            isExit=false;
            game.setMainMenuScreen();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            game.setVictoryScreen("Player 1");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            isResumed=true;
//            game.stage.addActor(resumeButton.button);
//            game.stage.addActor(saveAndExitButton.button);
//            game.stage.addActor(mainMenuButton.button);
//            Gdx.input.setInputProcessor(game.stage);
        }
        if (IconMenuButton.button.isPressed()){
            isResumed=true;
            stage.addActor(crossButton.button);
            stage.addActor(mainMenuButton.button);
            stage.addActor(saveAndExitButton.button);
            hud.stage.addActor(crossButton.button);
            hud.stage.addActor(mainMenuButton.button);
            hud.stage.addActor(saveAndExitButton.button);

        }
        if (crossButton.button.isPressed()){
            isResumed=false;
            stage.clear();
            hud.stage.clear();
            stage.addActor(IconMenuButton.button);
            hud.stage.addActor(IconMenuButton.button);
        }
        if (hud.IconMenuButton.button.isPressed()){
            isResumed=true;
            stage.addActor(crossButton.button);
            stage.addActor(mainMenuButton.button);
            stage.addActor(saveAndExitButton.button);
            hud.stage.addActor(crossButton.button);
            hud.stage.addActor(mainMenuButton.button);
            hud.stage.addActor(saveAndExitButton.button);
        }
        if (hud.crossButton.button.isPressed()){
            isResumed=false;
            stage.clear();
            hud.stage.clear();
            stage.addActor(IconMenuButton.button);
            hud.stage.addActor(IconMenuButton.button);
        }
        if(mainMenuButton.button.isPressed()){

            game.setMainMenuScreen();
        }
        if(hud.mainMenuButton.button.isPressed()){

            game.setMainMenuScreen();
        }

        if(cancelButton.button.isPressed()){

            isSaving=false;
            isResumed=false;
            stage.clear();
            hud.stage.clear();
            stage.addActor(IconMenuButton.button);
            hud.stage.addActor(IconMenuButton.button);
        }

        if(hud.cancelButton.button.isPressed()){
            isSaving=false;
            isResumed=false;
            stage.clear();
            hud.stage.clear();
            stage.addActor(IconMenuButton.button);
            hud.stage.addActor(IconMenuButton.button);
        }
        if(hud.saveAndExitButton.button.isPressed()){
            isSaving=true;
            stage.clear();
            hud.stage.clear();
            stage.addActor(slot1Button.button);
            stage.addActor(slot2Button.button);
            stage.addActor(slot3Button.button);
            stage.addActor(slot4Button.button);
            stage.addActor(cancelButton.button);
            hud.stage.addActor(slot1Button.button);
            hud.stage.addActor(slot2Button.button);
            hud.stage.addActor(slot3Button.button);
            hud.stage.addActor(slot4Button.button);
            hud.stage.addActor(cancelButton.button);
        }
        if(saveAndExitButton.button.isPressed()){
            isSaving=true;
            stage.clear();
            hud.stage.clear();
            stage.addActor(slot1Button.button);
            stage.addActor(slot2Button.button);
            stage.addActor(slot3Button.button);
            stage.addActor(slot4Button.button);
            stage.addActor(cancelButton.button);
            hud.stage.addActor(slot1Button.button);
            hud.stage.addActor(slot2Button.button);
            hud.stage.addActor(slot3Button.button);
            hud.stage.addActor(slot4Button.button);
            hud.stage.addActor(cancelButton.button);
        }
        if(slot1Button.button.isPressed()){
            try {
                Save(1);
                game.setMainMenuScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(slot2Button.button.isPressed()){
            try {
                Save(2);
                game.setMainMenuScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(slot3Button.button.isPressed()){
            try {
                Save(3);
                game.setMainMenuScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(slot4Button.button.isPressed()){
            try {
                Save(4);
                game.setMainMenuScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//
//        if (hud..button.isPressed()){
//            isResumed=true;
//        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && isResumed){
            isResumed=false;
            game.setMainMenuScreen();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE) && isResumed){
            isResumed=false;
//            game.stage.clear();
//            show();
        }
//        if (Gdx.input.isTouched()){
//            float x = Gdx.input.getX();
//            float y = Gdx.input.getY();
//            float yR = gamePort.getScreenHeight() / (y - gamePort.getScreenY()); // the y ratio
//            y =  768 / yR;
//
//            float xR = gamePort.getScreenWidth() / (x - gamePort.getScreenX()); // the x ratio
//            x = 1536 / xR;
//
//            System.out.println(yR);
//            System.out.println(xR);
//            isResumed=true;
//        }



        }





    public void Save(int slot) throws IOException {
        this.isResumed=false;
        this.isSaving=false;
        String DateStr =(String)formatter.format(date);

       // System.out.println(dtf.format(now));
        if(slot==1) {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("f1.txt"));
            out.writeObject(this);
            out.close();
            ResumeMenuScreen.slot1=DateStr;
            PrintWriter out1 = new PrintWriter(new FileWriter("f5.txt"));
            out1.println(ResumeMenuScreen.slot1);
            out1.println(ResumeMenuScreen.slot2);
            out1.println(ResumeMenuScreen.slot3);
            out1.println(ResumeMenuScreen.slot4);
            out1.close();
        }
            if(slot==2) {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("f2.txt"));
                out.writeObject(this);
                out.close();
                ResumeMenuScreen.slot2=DateStr;
                PrintWriter out1 = new PrintWriter(new FileWriter("f5.txt"));
                out1.println(ResumeMenuScreen.slot1);
                out1.println(ResumeMenuScreen.slot2);
                out1.println(ResumeMenuScreen.slot3);
                out1.println(ResumeMenuScreen.slot4);
                out1.close();
            }
            if(slot==3) {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("f3.txt"));
                out.writeObject(this);
                out.close();
                ResumeMenuScreen.slot3=DateStr;
                PrintWriter out1 = new PrintWriter(new FileWriter("f5.txt"));
                out1.println(ResumeMenuScreen.slot1);
                out1.println(ResumeMenuScreen.slot2);
                out1.println(ResumeMenuScreen.slot3);
                out1.println(ResumeMenuScreen.slot4);
                out1.close();
            }
            if(slot==4) {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("f4.txt"));
                out.writeObject(this);
                out.close();
                ResumeMenuScreen.slot4=DateStr;
                PrintWriter out1 = new PrintWriter(new FileWriter("f5.txt"));
                out1.println(ResumeMenuScreen.slot1);
                out1.println(ResumeMenuScreen.slot2);
                out1.println(ResumeMenuScreen.slot3);
                out1.println(ResumeMenuScreen.slot4);
                out1.close();
            }
        }

    public World getWorld() {
        return world;
    }

    public TiledMap getMap() {
        return map;
    }

    public void calcDamage(){


        float d = (float) (Math.pow((player2.b2body.getPosition().x - p1strikex),2) + Math.pow((player2.b2body.getPosition().y - p1strikey),2));
        float d2 = (float) Math.pow(d,0.5);
        System.out.println(d2);
        //currentHealth -= (10-(d2 * 10));
        if ((d2)<=1) {
            currentHealth -= ((1-d2)*10);
        }
        if (currentHealth<=0){
            game.setVictoryScreen("Player 1");
        }
    }
    public void calcDamage2(){


        float d = (float) (Math.pow((player.b2body.getPosition().x - p2strikex),2) + Math.pow((player.b2body.getPosition().y - p2strikey),2));
        float d2 = (float) Math.pow(d,0.5);
        System.out.println(d2);
        //currentHealth -= (10-(d2 * 10));
        if ((d2)<=1) {
            currentHealthA -= ((1-d2)*10);
        }
        if (currentHealthA<=0){
            game.setVictoryScreen("Player 2");
        }
    }

    public float getLaunchingPower(){
        return (float) power/100;
    }
    public float getLaunchingAngle(){
return (float) angle/100;
    }

    public void update(float dt){
//        System.out.println(world.getBodyCount());
//        System.out.println("F "+world.getFixtureCount());
        //changeTurn();

        handleInput(dt);
        if (!initialTurn){
            if(countTime>2 && aFired && change==false){
                change=true;
                //missile=null;
                aFired=false;
                fuelB=100;
                power=10;
                angle=10;
            }
        }
        if (change==true && countTime>2 && bFired){
            change=false;
            bFired=false;
            fuelA=100;
            power=10;
            angle=10;
            //missile2=null;
        }
        countTime+=dt;
        world.step(1/60f,6,2);
        player.update(dt);
        player2.update(dt);
        if (missile!=null){
        missile.update(dt);}
        if (missile2!=null){
            missile2.update(dt);}
        gamecam.update();
        renderer.setView(gamecam);

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();


        b2dr.render(world,gamecam.combined);

        game.batch.begin();
//        actor.act(delta);
//        actor.draw(game.batch,1);
        player.draw(game.batch);
        player2.draw(game.batch);
        if (missile!=null){
        missile.draw(game.batch);}
        if (missile2!=null){
            missile2.draw(game.batch);}
        String str = Integer.toString(power);
        font.getData().setScale(2);
        font.draw(game.batch,"Power: "+ str, 700, 150);
        str = Integer.toString(angle);
        font.draw(game.batch, "Angle: "+str, 950, 150);


        game.batch.draw(h2,1200,800,300,30);
        game.batch.draw(h1,1200,800,currentHealth,30);

        game.batch.draw(h22,500,800,300,30);
        game.batch.draw(h11,500,800,currentHealthA,30);

        game.batch.draw(p1Fuelf,200,80,100,30);
        game.batch.draw(p1Fuelb,200,80,fuelA,30);

        game.batch.draw(p2Fuelf,1470,80,100,30);
        game.batch.draw(p2Fuelb,1470,80,fuelB,30);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        //hud.stage.draw();

        game.batch.end();
        hud.stage.act();

        stage.act();

        if (isResumed){
            game.batch.begin();
            game.batch.draw(texture,0,0,MyGdxGame.V_Width/2,
                    MyGdxGame.V_Height/2,
                    MyGdxGame.V_Width,MyGdxGame.V_Height,
                    1,1,0,
                    -500,-300,texture.getWidth()*2,
                    texture.getHeight()*2,false,false);

            game.batch.end();
        }
        if (isSaving){
            game.batch.begin();
            game.batch.draw(saving, (float) 0,0,MyGdxGame.V_Width/2,
                    MyGdxGame.V_Height/2,
                    MyGdxGame.V_Width,MyGdxGame.V_Height,
                    1,1,0,
                    -498,-295,texture.getWidth()*2,
                    texture.getHeight()*2,false,false);

            game.batch.end();
        }
        hud.stage.draw();
        stage.draw();
//        game.batch.begin();
//        game.stage.act();
//        game.stage.draw();
//        game.batch.end();
    }



    private Pixmap createProceduralPixmap (int width, int height,int r,int g,int b) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(r, g, b, 1);
        pixmap.fill();
        return pixmap;
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        //stage.dispose();
    }
}
//for (MapObject object : map.getLayers().get(1).getObjects().getByType(PolygonMapObject.class)){
//        Polygon poly = ((PolygonMapObject) object).getPolygon();
//        bdef.type= BodyDef.BodyType.StaticBody;
//        bdef.position.set(poly.getX()+poly.getBoundingRectangle().getWidth()/2,poly.getY()+poly.getBoundingRectangle().getHeight()/4);
//        body = world.createBody(bdef);
//
//        Vector2[] vertices = new Vector2[poly.getVertexCount()];
//        // Build list of transformed vertices
//        for(int i = 0; i < poly.getVertexCount(); ++i) {
//        vertices[i] = new Vector2();
//        poly.getVertex(i, vertices[i]);
//        body.getTransform().mul(vertices[i]);
//        }
//
//        shape.set(vertices);
//
//        //shape.setAsBox(poly.getBoundingRectangle().getWidth()/2,poly.getBoundingRectangle().getHeight()/2);
//        fdef.shape=shape;
//        body.createFixture(fdef);
////NOTE: You don't want to be newing this up every time, make sure you keep an array of Vector2s and reuse that!
//
//// This assumes a closed polygon, the last vertex is connected with the first.
////            for(int i = 0; i < poly.getVertexCount(); ++i) {
////                Vector2 a = vertices[i];
////                Vector2 b = vertices[(i + 1) % poly.getVertexCount()];
////                renderer.line(a.x, a.y, b.x, b.y);
////            }

//for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
//        Rectangle poly = ((RectangleMapObject) object).getRectangle();
//        bdef.type = BodyDef.BodyType.StaticBody;
//        bdef.position.set(poly.getX() + poly.getWidth() / 2, poly.getY() + poly.getHeight() / 2);
//        body = world.createBody(bdef);
//
//
//        shape.setAsBox(poly.getWidth() / 2, poly.getHeight() / 2);
//        fdef.shape = shape;
//        body.createFixture(fdef);