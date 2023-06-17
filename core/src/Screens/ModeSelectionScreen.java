package Screens;
import Buttons_Label.*;
import Scenes.Hud;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import java.io.Serializable;

public class ModeSelectionScreen implements Screen, Serializable {
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
    private Texture texture5;
    private Texture lgray;
    private Texture rgray;
    private Texture diamond;
    private Texture coin;
    private Texture ring;
    private Texture Box;
    private Texture land;
    private VS_PlayButton vs_playButton;
    private VS_ComputerButton vs_computerButton;
    private BackButton backButton;
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

    public Texture getTexture5() {
        return texture5;
    }

    public void setTexture5(Texture texture5) {
        this.texture5 = texture5;
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

    public Texture getRing() {
        return ring;
    }

    public void setRing(Texture ring) {
        this.ring = ring;
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

    public VS_PlayButton getVs_playButton() {
        return vs_playButton;
    }

    public void setVs_playButton(VS_PlayButton vs_playButton) {
        this.vs_playButton = vs_playButton;
    }

    public VS_ComputerButton getVs_computerButton() {
        return vs_computerButton;
    }

    public void setVs_computerButton(VS_ComputerButton vs_computerButton) {
        this.vs_computerButton = vs_computerButton;
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

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ModeSelectionScreen(MyGdxGame game){
        //atlas = new TextureAtlas("images.pack");
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MyGdxGame.V_Width,MyGdxGame.V_Height,gamecam);
        hud=new Hud(game.batch,game);
        texture = new Texture(Gdx.files.internal("MainBck.png"));
        texture2 = new Texture(Gdx.files.internal("Back_button.png"));
        texture3 = new Texture(Gdx.files.internal("vsComp.png"));
        texture4 = new Texture(Gdx.files.internal("vsPlay.png"));
        texture5 = new Texture(Gdx.files.internal("optscreen.png"));
        lgray = new Texture(Gdx.files.internal("Lgray.png"));
        rgray = new Texture(Gdx.files.internal("Rgray.png"));
        diamond = new Texture(Gdx.files.internal("Gem.png"));
        coin = new Texture(Gdx.files.internal("Coin.png"));
        vs_playButton=new VS_PlayButton(game);
        vs_computerButton=new VS_ComputerButton(game);
        backButton=new BackButton(game);
        //stage=new Stage();


//        mapLoader = new TmxMapLoader();
//        map=mapLoader.load("tank.tmx");
//        renderer=new OrthogonalTiledMapRenderer(map);
        //sgame.stage.clear();
//        stage.setViewport(gamePort);
//        stage.addActor(vs_playButton.button);
//        stage.addActor(vs_computerButton.button);
//        stage.addActor(backButton.button);
//        Gdx.input.setInputProcessor(stage);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
    }

//    public TextureAtlas getAtlas() {
//        return atlas;
//    }

    @Override
    public void show() {
        stage = new Stage();
        stage.setViewport(gamePort);
        stage.addActor(vs_playButton.button);
        stage.addActor(vs_computerButton.button);
        stage.addActor(backButton.button);
        Gdx.input.setInputProcessor(stage);
    }
    public void handleInput(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.M)){
            game.setMainMenuScreen();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.C)){
            game.setTankSelectionScreen();
        }
        if(backButton.button.isPressed()){
            game.setMainMenuScreen();
        }
        if(vs_computerButton.button.isPressed()){
            game.setTankSelectionScreen();
        }
        if(vs_playButton.button.isPressed()){
            game.setTankSelectionScreen();
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


        game.batch.draw(texture5,0,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                -1413,-200,texture.getWidth(),
                texture.getHeight(),false,false);
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
//        game.batch.draw(coin,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -6900,-110,texture.getWidth()*4,
//                texture.getHeight()*4,false,false);
        //System.out.println(Gdx.input.getX()+"  "+Gdx.input.getY());
        stage.act();
        stage.draw();

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
        //stage=null;
    }

    @Override
    public void dispose() {

        //game.stage.dispose();
    }
}
