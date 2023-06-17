package com.mygdx.game;

import Screens.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class MyGdxGame extends Game implements Serializable {
	public static final int V_Width=1810;
	public static final int V_Height=908;
	public static final float PPM=200;
	public static final short DEFAULT_BIT=1;
	public static final short MARIO1_BIT=2;
	public static final short MARIO2_BIT=4;
	public static final short AGNI_BIT=8;
	public static final short AGNI_BIT2=32;
	public static final short DESTROYED_BIT=16;
	public SpriteBatch batch;

	private WarScreen warScreen;
	public WarScreen w1;
	public WarScreen w2;
	public WarScreen w3;
	public WarScreen w4;

	private MainMenuScreen mainMenuScreen;
	private ResumeMenuScreen resumeMenuScreen;
	private ModeSelectionScreen modeSelectionScreen;
	private TankSelectionScreen tankSelectionScreen;
	private VictoryScreen victoryScreen;
	public static AssetManager manager;
	public Stage stage;

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public WarScreen getWarScreen() {
		return warScreen;
	}

	public void setWarScreen(WarScreen warScreen) {
		this.warScreen = warScreen;
	}

	public WarScreen getW1() {
		return w1;
	}

	public void setW1(WarScreen w1) {
		this.w1 = w1;
	}

	public WarScreen getW2() {
		return w2;
	}

	public void setW2(WarScreen w2) {
		this.w2 = w2;
	}

	public WarScreen getW3() {
		return w3;
	}

	public void setW3(WarScreen w3) {
		this.w3 = w3;
	}

	public WarScreen getW4() {
		return w4;
	}

	public void setW4(WarScreen w4) {
		this.w4 = w4;
	}

	public MainMenuScreen getMainMenuScreen() {
		return mainMenuScreen;
	}

	public void setMainMenuScreen(MainMenuScreen mainMenuScreen) {
		this.mainMenuScreen = mainMenuScreen;
	}

	public ResumeMenuScreen getResumeMenuScreen() {
		return resumeMenuScreen;
	}

	public void setResumeMenuScreen(ResumeMenuScreen resumeMenuScreen) {
		this.resumeMenuScreen = resumeMenuScreen;
	}

	public ModeSelectionScreen getModeSelectionScreen() {
		return modeSelectionScreen;
	}

	public void setModeSelectionScreen(ModeSelectionScreen modeSelectionScreen) {
		this.modeSelectionScreen = modeSelectionScreen;
	}

	public TankSelectionScreen getTankSelectionScreen() {
		return tankSelectionScreen;
	}

	public void setTankSelectionScreen(TankSelectionScreen tankSelectionScreen) {
		this.tankSelectionScreen = tankSelectionScreen;
	}

	public VictoryScreen getVictoryScreen() {
		return victoryScreen;
	}

	public void setVictoryScreen(VictoryScreen victoryScreen) {
		this.victoryScreen = victoryScreen;
	}

	public static AssetManager getManager() {
		return manager;
	}

	public static void setManager(AssetManager manager) {
		MyGdxGame.manager = manager;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void create() {
		try {
			loadSavedGame();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		batch = new SpriteBatch();
		manager = new AssetManager();
		manager.load("music.ogg", Music.class);
		manager.finishLoading();
		//stage = new Stage(new ScreenViewport());
		stage = new Stage();
		mainMenuScreen = new MainMenuScreen(this);
		setScreen(mainMenuScreen);
	}
	public void setVictoryScreen(String winName){
		victoryScreen = new VictoryScreen(this,winName);
		setScreen(victoryScreen);
	}
	public void setMainMenuScreen(){
		mainMenuScreen = new MainMenuScreen(this);
		setScreen(mainMenuScreen);
	}
	public void updateSavedGame(int i, WarScreen w){
		if (i==1){
			this.w1=w;
		}
		if (i==2){
			this.w2=w;
		}
		if (i==3){
			this.w3=w;
		}
		if (i==4){
			this.w4=w;
		}
	}

	public void loadSlotGame(int i){
		if(i==1){
			if (w1!=null) {
				System.out.println("YES NULL1");
				w1.Setup(this);
				this.setScreen(w1);
			}
			else {
				System.out.println("YES NULL in else");
			}
		}
		if(i==2){
			if (w2!=null) {
				w2.Setup(this);
				this.setScreen(w2);
			}
		}
		if(i==3){
			if (w3!=null) {
				w3.Setup(this);
				this.setScreen(w3);
			}
		}
		if(i==4){
			if (w4!=null) {
				w4.Setup(this);
				this.setScreen(w4);
			}
		}
	}
	public void loadSavedGame() throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("f1.txt"));
		WarScreen g1;
		try{
            System.out.println(1);
			g1 = (WarScreen) in.readObject();
            System.out.println(11);
			in.close();
			this.updateSavedGame(1,g1);
		}
		catch (Exception e){
			System.out.println("Excep");
			in.close();
			this.updateSavedGame(1,null);

		}
//        in.close();
//        game.updateSavedGame(1,g1);

		in = new ObjectInputStream(new FileInputStream("f2.txt"));
		try {
            System.out.println(2);
			g1 = (WarScreen) in.readObject();
            System.out.println(22);
			in.close();
			this.updateSavedGame(2, g1);
		}
		catch (Exception e){
			in.close();
			this.updateSavedGame(2,null);
		}
		in = new ObjectInputStream(new FileInputStream("f3.txt"));
		try {
            System.out.println(3);
			g1 = (WarScreen) in.readObject();
            System.out.println(33);
			in.close();
			this.updateSavedGame(3, g1);
		}
		catch(Exception e){
			in.close();
			this.updateSavedGame(3,null);
		}
		in = new ObjectInputStream(new FileInputStream("f4.txt"));
		try {
            System.out.println(4);
			g1 = (WarScreen) in.readObject();
            System.out.println(44);
			in.close();
			this.updateSavedGame(4, g1);
		}
		catch (Exception e){
			in.close();
			this.updateSavedGame(4,null);
		}
	}

	public void setResumeMenuScreen() throws IOException, ClassNotFoundException {
		resumeMenuScreen = new ResumeMenuScreen(this);
		setScreen(resumeMenuScreen);
	}
	public void setModeSelectionScreen(){
		//stage=new Stage();
		modeSelectionScreen = new ModeSelectionScreen(this);
		setScreen(modeSelectionScreen);
	}
	public void setTankSelectionScreen(){
		//stage=new Stage();
		tankSelectionScreen = new TankSelectionScreen(this);
		setScreen(tankSelectionScreen);
	}
	public void setWarScreen(String str1,String str2){
//		if (tank==1){
//			warScreen = new WarScreen(this);
//			warScreen.player.
//			setScreen(warScreen);
//		}
//		if (tank==2){
//			warScreen = new WarScreen(this);
//			setScreen(warScreen);
//		}
//		if (tank==3){
//			warScreen = new WarScreen(this);
//			setScreen(warScreen);
//		}
		warScreen = new WarScreen(this,str1,str2);
		setScreen(warScreen);

	}


	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
