package Screens;

import Buttons_Label.*;
import Scenes.Hud;
import Sprites.SettingsButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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

import java.io.IOException;
import java.io.Serializable;

public class MainMenuScreen implements Screen , Serializable {
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
    private Texture settingMenu;
    private Texture diamond;
    private Texture coin;
    private Texture plusi;
    private Boolean isSetting =false;
    private Stage stage;
    private Music music;
    private SettingsButton settingsButton =new SettingsButton(game);
    private NewGameButton newGameButton=new NewGameButton(game);
    private ResumeGameButton resumeGameButton=new ResumeGameButton(game);
    private ExitButton exitButton=new ExitButton(game);
    private CrossButton crossButton = new CrossButton(game);
    private SoundButton soundButton =new SoundButton(game);
    private MusicButton musicButton=new MusicButton(game);

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

    public Texture getSettingMenu() {
        return settingMenu;
    }

    public void setSettingMenu(Texture settingMenu) {
        this.settingMenu = settingMenu;
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

    public Texture getPlusi() {
        return plusi;
    }

    public void setPlusi(Texture plusi) {
        this.plusi = plusi;
    }

    public Boolean getSetting() {
        return isSetting;
    }

    public void setSetting(Boolean setting) {
        isSetting = setting;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public SettingsButton getSettingsButton() {
        return settingsButton;
    }

    public void setSettingsButton(SettingsButton settingsButton) {
        this.settingsButton = settingsButton;
    }

    public NewGameButton getNewGameButton() {
        return newGameButton;
    }

    public void setNewGameButton(NewGameButton newGameButton) {
        this.newGameButton = newGameButton;
    }

    public ResumeGameButton getResumeGameButton() {
        return resumeGameButton;
    }

    public void setResumeGameButton(ResumeGameButton resumeGameButton) {
        this.resumeGameButton = resumeGameButton;
    }

    public ExitButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(ExitButton exitButton) {
        this.exitButton = exitButton;
    }

    public CrossButton getCrossButton() {
        return crossButton;
    }

    public void setCrossButton(CrossButton crossButton) {
        this.crossButton = crossButton;
    }

    public SoundButton getSoundButton() {
        return soundButton;
    }

    public void setSoundButton(SoundButton soundButton) {
        this.soundButton = soundButton;
    }

    public MusicButton getMusicButton() {
        return musicButton;
    }

    public void setMusicButton(MusicButton musicButton) {
        this.musicButton = musicButton;
    }

    public float getHeightScaleFactor() {
        return heightScaleFactor;
    }

    public float getWidthScaleFactor() {
        return widthScaleFactor;
    }

    // credits to Supercell only
    private final float heightScaleFactor = 0.9f;
    private final float widthScaleFactor = 0.9f;

    public MainMenuScreen(MyGdxGame game){
        //atlas = new TextureAtlas("images.pack");
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MyGdxGame.V_Width,MyGdxGame.V_Height,gamecam);
        hud=new Hud(game.batch,game);
        texture = new Texture(Gdx.files.internal("MainBck.png"));
//        texture2 = new Texture(Gdx.files.internal("settingsButton.png"));
//        texture3 = new Texture(Gdx.files.internal("Exit.png"));
//        texture4 = new Texture(Gdx.files.internal("New.png"));
//        texture5 = new Texture(Gdx.files.internal("resume.png"));
        settingMenu = new Texture(Gdx.files.internal("SettingScreenNew.png"));
        lgray = new Texture(Gdx.files.internal("Lgray.png"));
//        rgray = new Texture(Gdx.files.internal("Rgray.png"));
//        diamond = new Texture(Gdx.files.internal("Gem.png"));
//        coin = new Texture(Gdx.files.internal("Coin.png"));
//        plusi = new Texture(Gdx.files.internal("plusT.png"));
//        stage = new Stage();
        music = MyGdxGame.manager.get("music.ogg",Music.class);
        music.setLooping(true);
        music.play();
//        stage.setViewport(gamePort);
//        stage.addActor(settingsButton.button);
//        stage.addActor(newGameButton.button);
//        stage.addActor(resumeGameButton.button);
//        stage.addActor(exitButton.button);
//        Gdx.input.setInputProcessor(stage);
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
            stage.addActor(settingsButton.button);
            stage.addActor(newGameButton.button);
            stage.addActor(resumeGameButton.button);
            stage.addActor(exitButton.button);
            Gdx.input.setInputProcessor(stage);


    }
    public void handleInput(float dt){
//        if(Gdx.input.isTouched())
//            gamecam.position.x+=100*dt;
        if (Gdx.input.isKeyPressed(Input.Keys.R)){
            //game.stage.clear();
            try {
                game.setResumeMenuScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            isSetting=true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE) && isSetting){
            isSetting=false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.N)){
//            game.stage.clear();
            game.setModeSelectionScreen();
        }
        if (newGameButton.button.isPressed()){
//            game.stage.clear();
            game.setModeSelectionScreen();

        }
        if (resumeGameButton.button.isPressed()){
//            stage.clear();
            try {
                game.setResumeMenuScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (exitButton.button.isPressed()){
            Gdx.app.exit();
            System.exit(0);
//            game.setModeSelectionScreen();
        }
        if (settingsButton.button.isPressed()){
            isSetting=true;
            stage.addActor(crossButton.button);
            stage.addActor(soundButton.button);
            stage.addActor(musicButton.button);
            Gdx.input.setInputProcessor(stage);
        }

        if (crossButton.button.isPressed()){
            isSetting=false;
            stage.clear();
            show();
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

        game.batch.draw(lgray,0,0,MyGdxGame.V_Width/2,
                MyGdxGame.V_Height/2,
                MyGdxGame.V_Width,MyGdxGame.V_Height,
                1,1,0,
                -1300,300,texture.getWidth(),
                texture.getHeight(),false,false);
//        game.batch.draw(diamond,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -11900,-190,texture.getWidth()*9,
//                texture.getHeight()*9,false,false);
//        game.batch.draw(plusi,0,0,MyGdxGame.V_Width/2,
//                MyGdxGame.V_Height/2,
//                MyGdxGame.V_Width,MyGdxGame.V_Height,
//                1,1,0,
//                -32800,-590,texture.getWidth()*22,
//                texture.getHeight()*22,false,false);
//
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
                -310,-177,texture.getWidth(),
                texture.getHeight(),false,false);}

        //settingsButton.button.draw(game.batch,1);
        //game.stage.act(Gdx.graphics.getDeltaTime());
//        stage.act();
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
        //stage=null;
    }

    @Override
    public void dispose() {
//game.stage.dispose();
    }
}
