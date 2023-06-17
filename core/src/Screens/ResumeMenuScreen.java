package Screens;
import Buttons_Label.*;
import Scenes.Hud;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import java.io.*;

public class ResumeMenuScreen implements Screen, Serializable {
    private MyGdxGame game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private Texture texture;
    private Texture texture2;
    private Texture texture3;
    private Texture texture4;
    private Texture emp2;
    private Texture emp3;
    private Texture emp4;
    private Texture lgray;
    private Texture rgray;
    private Texture diamond;
    private Texture coin;
    private Texture settingMenu;
    private BackButton backButton;
    private EmptySlot emptySlot;
    private EmptySlot2 emptySlot2;
    private EmptySlot3 emptySlot3;
    private EmptySlot4 emptySlot4;

    static String slot1;
    static String slot2;
    static String slot3;
    static String slot4;
    private BitmapFont font1 = new BitmapFont();
    private BitmapFont font2 = new BitmapFont();
    private BitmapFont font3 = new BitmapFont();
    private BitmapFont font4 = new BitmapFont();
    private Boolean isSetting =false;
    private Texture land;
    //private TextureAtlas atlas;
    // private World world;
    // private Box2DDebugRenderer b2dr;
    final float heightScaleFactor = 0.9f;
    final float widthScaleFactor = 0.9f;
    Stage stage;

    public MyGdxGame getGame() {
        return game;
    }

    public void setGame(MyGdxGame game) {
        this.game = game;
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

    public TmxMapLoader getMapLoader() {
        return mapLoader;
    }

    public void setMapLoader(TmxMapLoader mapLoader) {
        this.mapLoader = mapLoader;
    }

    public TiledMap getMap() {
        return map;
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

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Texture getTexture2() {
        return texture2;
    }

    public void setTexture2(Texture texture2) {
        this.texture2 = texture2;
    }

    public Texture getTexture3() {
        return texture3;
    }

    public void setTexture3(Texture texture3) {
        this.texture3 = texture3;
    }

    public Texture getTexture4() {
        return texture4;
    }

    public void setTexture4(Texture texture4) {
        this.texture4 = texture4;
    }

    public Texture getEmp2() {
        return emp2;
    }

    public void setEmp2(Texture emp2) {
        this.emp2 = emp2;
    }

    public Texture getEmp3() {
        return emp3;
    }

    public void setEmp3(Texture emp3) {
        this.emp3 = emp3;
    }

    public Texture getEmp4() {
        return emp4;
    }

    public void setEmp4(Texture emp4) {
        this.emp4 = emp4;
    }

    public Texture getLgray() {
        return lgray;
    }

    public void setLgray(Texture lgray) {
        this.lgray = lgray;
    }

    public Texture getRgray() {
        return rgray;
    }

    public void setRgray(Texture rgray) {
        this.rgray = rgray;
    }

    public Texture getDiamond() {
        return diamond;
    }

    public void setDiamond(Texture diamond) {
        this.diamond = diamond;
    }

    public Texture getCoin() {
        return coin;
    }

    public void setCoin(Texture coin) {
        this.coin = coin;
    }

    public Texture getSettingMenu() {
        return settingMenu;
    }

    public void setSettingMenu(Texture settingMenu) {
        this.settingMenu = settingMenu;
    }

    public BackButton getBackButton() {
        return backButton;
    }

    public void setBackButton(BackButton backButton) {
        this.backButton = backButton;
    }

    public EmptySlot getEmptySlot() {
        return emptySlot;
    }

    public void setEmptySlot(EmptySlot emptySlot) {
        this.emptySlot = emptySlot;
    }

    public EmptySlot2 getEmptySlot2() {
        return emptySlot2;
    }

    public void setEmptySlot2(EmptySlot2 emptySlot2) {
        this.emptySlot2 = emptySlot2;
    }

    public EmptySlot3 getEmptySlot3() {
        return emptySlot3;
    }

    public void setEmptySlot3(EmptySlot3 emptySlot3) {
        this.emptySlot3 = emptySlot3;
    }

    public EmptySlot4 getEmptySlot4() {
        return emptySlot4;
    }

    public void setEmptySlot4(EmptySlot4 emptySlot4) {
        this.emptySlot4 = emptySlot4;
    }

    public static String getSlot1() {
        return slot1;
    }

    public static void setSlot1(String slot1) {
        ResumeMenuScreen.slot1 = slot1;
    }

    public static String getSlot2() {
        return slot2;
    }

    public static void setSlot2(String slot2) {
        ResumeMenuScreen.slot2 = slot2;
    }

    public static String getSlot3() {
        return slot3;
    }

    public static void setSlot3(String slot3) {
        ResumeMenuScreen.slot3 = slot3;
    }

    public static String getSlot4() {
        return slot4;
    }

    public static void setSlot4(String slot4) {
        ResumeMenuScreen.slot4 = slot4;
    }

    public BitmapFont getFont1() {
        return font1;
    }

    public void setFont1(BitmapFont font1) {
        this.font1 = font1;
    }

    public BitmapFont getFont2() {
        return font2;
    }

    public void setFont2(BitmapFont font2) {
        this.font2 = font2;
    }

    public BitmapFont getFont3() {
        return font3;
    }

    public void setFont3(BitmapFont font3) {
        this.font3 = font3;
    }

    public BitmapFont getFont4() {
        return font4;
    }

    public void setFont4(BitmapFont font4) {
        this.font4 = font4;
    }

    public Boolean getSetting() {
        return isSetting;
    }

    public void setSetting(Boolean setting) {
        isSetting = setting;
    }

    public Texture getLand() {
        return land;
    }

    public void setLand(Texture land) {
        this.land = land;
    }

    public float getHeightScaleFactor() {
        return heightScaleFactor;
    }

    public float getWidthScaleFactor() {
        return widthScaleFactor;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ResumeMenuScreen(MyGdxGame game){
        //atlas = new TextureAtlas("images.pack");
        this.game = game;
            try {
                readSavedList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

//        try {
//            loadSavedGame();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MyGdxGame.V_Width,MyGdxGame.V_Height,gamecam);
        hud=new Hud(game.batch,game);
        texture = new Texture(Gdx.files.internal("MainBck.png"));
        texture2 = new Texture(Gdx.files.internal("settingsButton.png"));
        texture3 = new Texture(Gdx.files.internal("EmptySlot.png"));
        emp2 = new Texture(Gdx.files.internal("EmptySlot.png"));
        emp3 = new Texture(Gdx.files.internal("EmptySlot.png"));
        emp4 = new Texture(Gdx.files.internal("EmptySlot.png"));
        texture4 = new Texture(Gdx.files.internal("game1.png"));
        settingMenu = new Texture(Gdx.files.internal("SettingScreen.png"));
        lgray = new Texture(Gdx.files.internal("Lgray.png"));
        rgray = new Texture(Gdx.files.internal("Rgray.png"));
        diamond = new Texture(Gdx.files.internal("Gem.png"));
        coin = new Texture(Gdx.files.internal("Coin.png"));
        backButton = new BackButton(game);
        emptySlot=new EmptySlot(game);
        emptySlot2=new EmptySlot2(game);
        emptySlot3=new EmptySlot3(game);
        emptySlot4=new EmptySlot4(game);


//        mapLoader = new TmxMapLoader();
//        map=mapLoader.load("tank.tmx");
//        renderer=new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
    }

//    public TextureAtlas getAtlas() {
//        return atlas;
//    }

    @Override
    public void show() {
        stage = new Stage();
        stage.setViewport(gamePort);
        stage.addActor(backButton.button);
        stage.addActor(emptySlot.button);
        stage.addActor(emptySlot2.button);
        stage.addActor(emptySlot3.button);
        stage.addActor(emptySlot4.button);
        Gdx.input.setInputProcessor(stage);
    }
    public static void readSavedList() throws IOException {
        BufferedReader in = new BufferedReader( new FileReader("f5.txt"));

        String l;
//        int i=0;
        for(int i=0;i<4;i++){
            if(i==0){
                try {
                    slot1=in.readLine();
                } catch (Exception e) {
                    slot1="Empty Slot";
                }
            }
            if(i==1){
                try {
                    slot2=in.readLine();
                } catch (Exception e) {
                    slot2="Empty Slot";
                }
            }
            if(i==2){
                try {
                    slot3=in.readLine();
                } catch (Exception e) {
                    slot3="Empty Slot";
                }
            }
            if(i==3){
                try {
                    slot4=in.readLine();
                } catch (Exception e) {
                    slot4="Empty Slot";
                }
            }

        }
        in.close();
    }





//    public void loadSavedGame() throws IOException, ClassNotFoundException {
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream("f1.txt"));
//        WarScreen g1;
//        try{
////            System.out.println(1);
//            g1 = (WarScreen) in.readObject();
////            System.out.println(11);
//            in.close();
//            game.updateSavedGame(1,g1);
//        }
//        catch (Exception e){
//            in.close();
//            game.updateSavedGame(1,null);
//        }
////        in.close();
////        game.updateSavedGame(1,g1);
//
//        in = new ObjectInputStream(new FileInputStream("f2.txt"));
//        try {
////            System.out.println(2);
//            g1 = (WarScreen) in.readObject();
////            System.out.println(22);
//            in.close();
//            game.updateSavedGame(2, g1);
//        }
//        catch (Exception e){
//            in.close();
//            game.updateSavedGame(2,null);
//        }
//        in = new ObjectInputStream(new FileInputStream("f3.txt"));
//        try {
////            System.out.println(3);
//            g1 = (WarScreen) in.readObject();
////            System.out.println(33);
//            in.close();
//            game.updateSavedGame(3, g1);
//        }
//        catch(Exception e){
//            in.close();
//            game.updateSavedGame(3,null);
//        }
//        in = new ObjectInputStream(new FileInputStream("f4.txt"));
//        try {
////            System.out.println(4);
//            g1 = (WarScreen) in.readObject();
////            System.out.println(44);
//            in.close();
//            game.updateSavedGame(4, g1);
//        }
//        catch (Exception e){
//            in.close();
//            game.updateSavedGame(4,null);
//        }
//    }


    public void handleInput(float dt){
//        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
//            game.setWarScreen();
//        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            isSetting=true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE) && isSetting){
            isSetting=false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE) && !isSetting){
            game.setMainMenuScreen();
        }
        if(backButton.button.isPressed()){
            game.setMainMenuScreen();
        }
        if(emptySlot.button.isPressed()){
            System.out.println("CHecked");
            game.loadSlotGame(1);
        }
        if(emptySlot2.button.isPressed()){
            game.loadSlotGame(2);
        }
        if(emptySlot3.button.isPressed()){
            game.loadSlotGame(3);
        }
        if(emptySlot4.button.isPressed()){
            game.loadSlotGame(4);
        }
        
    }
    public void update(float dt){
        handleInput(dt);
        gamecam.update();
        //renderer.setView(gamecam);

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //renderer.render();
        game.batch.begin();
        game.batch.draw(texture,0,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                0,0,texture.getWidth(),
                texture.getHeight(),false,false);
//        game.batch.draw(texture2,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -5,-14,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(texture4,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1343,-250,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(texture3,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1343,-400,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(emp2,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1343,-550,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(emp3,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1343,-700,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(emp4,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1343,-850,texture.getWidth(),
//                texture.getHeight(),false,false);
        game.batch.draw(lgray,0,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                -1300,400,texture.getWidth(),
                texture.getHeight(),false,false);
//        game.batch.draw(diamond,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -11900,-190,texture.getWidth()*9,
//                texture.getHeight()*9,false,false);
//        game.batch.draw(rgray,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1700,-10,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(coin,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -6900,-110,texture.getWidth()*4,
//                texture.getHeight()*4,false,false);
        if(isSetting){
            game.batch.draw(settingMenu,0,0,MyGdxGame.V_Width/2,
                    MyGdxGame.V_Height/2,
                    MyGdxGame.V_Width,MyGdxGame.V_Height,
                    1,1,0,
                    -70,-2,texture.getWidth(),
                    texture.getHeight(),false,false);}
        //System.out.println(Gdx.input.getX()+"  "+Gdx.input.getY());
        stage.act();
        stage.draw();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        font1.getData().setScale(2);
        font1.draw(game.batch, slot1, 1310, 560);
        font1.draw(game.batch, slot2, 1310, 415);
        font1.draw(game.batch, slot3, 1310, 260);
        font1.draw(game.batch, slot4, 1310, 120);

        game.batch.end();
        //hud.stage.draw();
//        game.batch.setProjectionMatrix(gamecam.combined);
//        game.batch.begin();
//        game.batch.draw(texture,0,0);
//        game.batch.end();
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
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {

    }
}
