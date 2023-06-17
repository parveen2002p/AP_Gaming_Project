package Screens;
import Buttons_Label.*;
import Scenes.Hud;
import Sprites.agni;
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

public class TankSelectionScreen implements Screen {
    private MyGdxGame game;
    private boolean isSelected1=false;
    private boolean isSelected2=false;
    private boolean isSelected3=false;
    private int counttank=0;
    private String name1,name2,name3;
    private float T1x, T1y, T2x, T2y;

    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private Texture texture;
    private Texture texture2;
    private Texture playbut;
    private Texture upgradebut;
    private Texture chooseTank;
    private Texture lback;
    private Texture rback;
    private Texture optank1;
    private Texture optank2;

    private Texture hp;
    private Texture lgray;
    private BitmapFont font = new BitmapFont();
    private Texture rgray;
    private Texture diamond;
    private Texture coin;
    private Stage stage;
    private Texture Box;
    private Texture land;
    //private TextureAtlas atlas;
    // private World world;
    // private Box2DDebugRenderer b2dr;
    //SelectTankButton selectTankButton;
    private SelectTankButton1 selectTankButton1;
    private SelectTankButton2 selectTankButton2;
    private SelectTankButton3 selectTankButton3;
    private PlayButton playButton;
    private BackButton backButton;

    public MyGdxGame getGame() {
        return game;
    }

    public void setGame(MyGdxGame game) {
        this.game = game;
    }

    public boolean isSelected1() {
        return isSelected1;
    }

    public void setSelected1(boolean selected1) {
        isSelected1 = selected1;
    }

    public boolean isSelected2() {
        return isSelected2;
    }

    public void setSelected2(boolean selected2) {
        isSelected2 = selected2;
    }

    public boolean isSelected3() {
        return isSelected3;
    }

    public void setSelected3(boolean selected3) {
        isSelected3 = selected3;
    }

    public int getCounttank() {
        return counttank;
    }

    public void setCounttank(int counttank) {
        this.counttank = counttank;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public float getT1x() {
        return T1x;
    }

    public void setT1x(float t1x) {
        T1x = t1x;
    }

    public float getT1y() {
        return T1y;
    }

    public void setT1y(float t1y) {
        T1y = t1y;
    }

    public float getT2x() {
        return T2x;
    }

    public void setT2x(float t2x) {
        T2x = t2x;
    }

    public float getT2y() {
        return T2y;
    }

    public void setT2y(float t2y) {
        T2y = t2y;
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

    public Texture getPlaybut() {
        return playbut;
    }

    public void setPlaybut(Texture playbut) {
        this.playbut = playbut;
    }

    public Texture getUpgradebut() {
        return upgradebut;
    }

    public void setUpgradebut(Texture upgradebut) {
        this.upgradebut = upgradebut;
    }

    public Texture getChooseTank() {
        return chooseTank;
    }

    public void setChooseTank(Texture chooseTank) {
        this.chooseTank = chooseTank;
    }

    public Texture getLback() {
        return lback;
    }

    public void setLback(Texture lback) {
        this.lback = lback;
    }

    public Texture getRback() {
        return rback;
    }

    public void setRback(Texture rback) {
        this.rback = rback;
    }

    public Texture getOptank1() {
        return optank1;
    }

    public void setOptank1(Texture optank1) {
        this.optank1 = optank1;
    }

    public Texture getOptank2() {
        return optank2;
    }

    public void setOptank2(Texture optank2) {
        this.optank2 = optank2;
    }

    public Texture getHp() {
        return hp;
    }

    public void setHp(Texture hp) {
        this.hp = hp;
    }

    public Texture getLgray() {
        return lgray;
    }

    public void setLgray(Texture lgray) {
        this.lgray = lgray;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
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

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Texture getBox() {
        return Box;
    }

    public void setBox(Texture box) {
        Box = box;
    }

    public Texture getLand() {
        return land;
    }

    public void setLand(Texture land) {
        this.land = land;
    }

    public SelectTankButton1 getSelectTankButton1() {
        return selectTankButton1;
    }

    public void setSelectTankButton1(SelectTankButton1 selectTankButton1) {
        this.selectTankButton1 = selectTankButton1;
    }

    public SelectTankButton2 getSelectTankButton2() {
        return selectTankButton2;
    }

    public void setSelectTankButton2(SelectTankButton2 selectTankButton2) {
        this.selectTankButton2 = selectTankButton2;
    }

    public SelectTankButton3 getSelectTankButton3() {
        return selectTankButton3;
    }

    public void setSelectTankButton3(SelectTankButton3 selectTankButton3) {
        this.selectTankButton3 = selectTankButton3;
    }

    public PlayButton getPlayButton() {
        return playButton;
    }

    public void setPlayButton(PlayButton playButton) {
        this.playButton = playButton;
    }

    public BackButton getBackButton() {
        return backButton;
    }

    public void setBackButton(BackButton backButton) {
        this.backButton = backButton;
    }

    public float getHeightScaleFactor() {
        return heightScaleFactor;
    }

    public float getWidthScaleFactor() {
        return widthScaleFactor;
    }

    final float heightScaleFactor = 0.9f;
    final float widthScaleFactor = 0.9f;

    public TankSelectionScreen(MyGdxGame game){
        //atlas = new TextureAtlas("images.pack");
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MyGdxGame.V_Width,MyGdxGame.V_Height,gamecam);
        hud=new Hud(game.batch,game);
        texture = new Texture(Gdx.files.internal("MainBck.png"));
        texture2 = new Texture(Gdx.files.internal("Back_button.png"));
        playbut = new Texture(Gdx.files.internal("playbut.png"));
        upgradebut = new Texture(Gdx.files.internal("upgradebutton.png"));
        chooseTank = new Texture(Gdx.files.internal("chooseTank.png"));
        lback = new Texture(Gdx.files.internal("lback.png"));
        rback = new Texture(Gdx.files.internal("rback.png"));
        optank1 = new Texture(Gdx.files.internal("optank1.png"));
        optank2 = new Texture(Gdx.files.internal("optank2.png"));
        
        hp = new Texture(Gdx.files.internal("hp.png"));
        lgray = new Texture(Gdx.files.internal("Lgray.png"));
        rgray = new Texture(Gdx.files.internal("Rgray.png"));
        diamond = new Texture(Gdx.files.internal("Gem.png"));
        coin = new Texture(Gdx.files.internal("Coin.png"));
        //selectTankButton=new SelectTankButton(game);
        selectTankButton1 = new SelectTankButton1(game);
        selectTankButton2 = new SelectTankButton2(game);
        selectTankButton3 = new SelectTankButton3(game);
        playButton=new PlayButton(game);
        backButton=new BackButton(game);
        name1=null;
        name2=null;
        name3=null;
//        stage = new Stage();
//        mapLoader = new TmxMapLoader();
//        map=mapLoader.load("tank.tmx");
//        renderer=new OrthogonalTiledMapRenderer(map);
        //game.stage.clear();

        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
        // gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
    }

//    public TextureAtlas getAtlas() {
//        return atlas;
//    }


    @Override
    public void show() {
        stage=new Stage();
        stage.setViewport(gamePort);
        //stage.addActor(selectTankButton.button);
        stage.addActor(selectTankButton1.button);
        stage.addActor(selectTankButton2.button);
        stage.addActor(selectTankButton3.button);
        stage.addActor(playButton.button);
        stage.addActor(backButton.button);
        Gdx.input.setInputProcessor(stage);

    }
    public void handleInput(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)){
            game.setModeSelectionScreen();
        }
//        if (Gdx.input.isKeyPressed(Input.Keys.P)){
//            game.setWarScreen();
//        }

        if(selectTankButton1.button.isPressed() && counttank!=2 && isSelected1==false){
            isSelected1=true;
            counttank++;
            name1="tanks_tankGrey3";
        }
        if(selectTankButton2.button.isPressed() && counttank!=2 && isSelected2==false){
            isSelected2=true;
            counttank++;
            name2="tanks_tankDesert3";
        }
        if(selectTankButton3.button.isPressed() && counttank!=2 &&isSelected3==false){
            isSelected3=true;
            counttank++;
            name3="tanks_tankGreen3";
        }
        if(playButton.button.isPressed() && counttank==2){
            if (name1==null) {
                game.setWarScreen(name2, name3);
            }
            else if (name2==null) {
                game.setWarScreen(name1, name3);
            }
            else if (name3==null) {
                game.setWarScreen(name1, name2);
            }
            else {
                game.setWarScreen("tanks_tankDesert3","tanks_tankDesert3");
            }

        }
        if(backButton.button.isPressed()){
            game.setModeSelectionScreen();
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
        //stage.act();
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
////        game.batch.draw(upgradebut,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1479,-800,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(playbut,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1479,-600,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(chooseTank,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1400,-200,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(optank1,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1490,-350,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(optank2,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1730,-380,texture.getWidth(),
//                texture.getHeight(),false,false);
//        
//        game.batch.draw(rback,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1980,-420,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(lback,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1230,-420,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(lgray,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1300,-10,texture.getWidth(),
//                texture.getHeight(),false,false);
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
        game.batch.draw(coin,0,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                -6900,410,texture.getWidth()*4,
                texture.getHeight()*4,false,false);
        //System.out.println(Gdx.input.getX()+"  "+Gdx.input.getY());
        stage.act();
        stage.draw();
        if (isSelected1){
            String str = "Selected";
            font.getData().setScale(2);
            font.draw(game.batch, str, 1125, 725);
        }
        if (isSelected2){
            String str = "Selected";
            font.getData().setScale(2);
            font.draw(game.batch, str, 1400, 725);
        }
        if (isSelected3){
            String str = "Selected";
            font.getData().setScale(2);
            font.draw(game.batch, str, 1650, 725);
        }


        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
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

    }

    @Override
    public void dispose() {
//stage.dispose();
    }
}
