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

import java.io.Serializable;

public class VictoryScreen implements Screen, Serializable {
    private String winName;
    private MyGdxGame game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private Texture texture;
    private Texture contbut;
    private Texture collbut;
    private Texture rewardLabel;
    private Texture mysteryBox;
    private Texture real;
    private Texture victory;
    private Stage stage;
    private BitmapFont font1 = new BitmapFont();
    private ContinueButton continueButton ;
    
    float y1 =0;
    float y2;

    public String getWinName() {
        return winName;
    }

    public void setWinName(String winName) {
        this.winName = winName;
    }

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

    public Texture getContbut() {
        return contbut;
    }

    public void setContbut(Texture contbut) {
        this.contbut = contbut;
    }

    public Texture getCollbut() {
        return collbut;
    }

    public void setCollbut(Texture collbut) {
        this.collbut = collbut;
    }

    public Texture getRewardLabel() {
        return rewardLabel;
    }

    public void setRewardLabel(Texture rewardLabel) {
        this.rewardLabel = rewardLabel;
    }

    public Texture getMysteryBox() {
        return mysteryBox;
    }

    public void setMysteryBox(Texture mysteryBox) {
        this.mysteryBox = mysteryBox;
    }

    public Texture getReal() {
        return real;
    }

    public void setReal(Texture real) {
        this.real = real;
    }

    public Texture getVictory() {
        return victory;
    }

    public void setVictory(Texture victory) {
        this.victory = victory;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public BitmapFont getFont1() {
        return font1;
    }

    public void setFont1(BitmapFont font1) {
        this.font1 = font1;
    }

    public ContinueButton getContinueButton() {
        return continueButton;
    }

    public void setContinueButton(ContinueButton continueButton) {
        this.continueButton = continueButton;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public VictoryScreen(MyGdxGame game, String winName){
        this.winName=winName;
        //atlas = new TextureAtlas("images.pack");
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MyGdxGame.V_Width,MyGdxGame.V_Height,gamecam);
        hud=new Hud(game.batch,game);
        real = new Texture(Gdx.files.internal("ani.png"));
        texture = new Texture(Gdx.files.internal("MainBck.png"));
        contbut = new Texture(Gdx.files.internal("contLabel.png"));
        collbut = new Texture(Gdx.files.internal("colLabel.png"));
        rewardLabel = new Texture(Gdx.files.internal("rewLabel.png"));
        mysteryBox = new Texture(Gdx.files.internal("MysteryBox.png"));
        victory = new Texture(Gdx.files.internal("victory.png"));
        y2 = real.getWidth();

        continueButton= new ContinueButton(game);

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
        stage.addActor(continueButton.button);
    }
    public void handleInput(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.M)){
            game.setMainMenuScreen();
        }
        if (continueButton.button.isPressed()){
            game.setMainMenuScreen();
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
        y1 -= 500* delta;
        y2 -= 500* delta;
        if (y1+ real.getWidth() <=0){
            y1 = y2 + texture.getWidth()/3;
        }
        if (y2+ real.getWidth() <=0){
            y2 = y1 + texture.getWidth()/3;
        }
        game.batch.begin();
        game.batch.draw(real,y1,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                0,0,real.getWidth(),
                real.getHeight(),false,false);
        game.batch.draw(real,y2,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                0,0,real.getWidth(),
                real.getHeight(),false,false);
//        game.batch.draw(texture,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                0,0,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(contbut,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1479,-800,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(collbut,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1479,-600,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(rewardLabel,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -1400,-200,texture.getWidth(),
//                texture.getHeight(),false,false);
//        game.batch.draw(mysteryBox,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -3000,-700,texture.getWidth()*2,
//                texture.getHeight()*2,false,false);
        game.batch.draw(victory,0,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                0,0,texture.getWidth()/2,
                texture.getHeight()/2,false,false);
        font1.getData().setScale(4);
        font1.draw(game.batch, "WINNER WINNER", 1250, 600);
        font1.draw(game.batch, winName, 1250, 500);

        //System.out.println(Gdx.input.getX()+"  "+Gdx.input.getY());

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        game.batch.end();
        stage.act();
        stage.draw();
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
stage.dispose();
    }
}
