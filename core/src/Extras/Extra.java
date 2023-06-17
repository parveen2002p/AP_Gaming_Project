package Extras;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Extra {
}


class Option{
    private Diamonds diamonds;
    private Coins coins;
    private Sprite dailyReward;
    private Game clashOfTank;

    public void displayOption(){

    }
    public void manageOption(){

    }
    public void manageDiamonds(){

    }
    public void manageDailyReward(){

    }
}

class Cards{
    private Texture Cards;
    private String Missiles;

    public void openChest(){

    }
    public void setReward(){

    }
}


class HealthDrop{
    private float dropCoordinates;
    private Sprite sprite;

    public void startDrop(int x, int y){

    }
    public void increaseTankHealth(){

    }
    public boolean isCollected(){
        return true;
    }
    public void timeOver(){

    }
    public void update(){

    }
}


class Coins{
    private Sprite texture;
    private int quantity;

    public void increaseCoins(){

    }
    public void useCoins(){

    }
    public int getCoins(){
        return 0;
    }
    public void setCoins(){

    }
}
class Diamonds{
    private Sprite texture;
    private int quantity;

    public void increaseDiamonds(){

    }
    public void useDiamons(){

    }
    public int getDiamons(){
        return 0;
    }
    public void setDiamons(){

    }
}
class Chest{
    private Sprite chestTreasure;
    private int coinsNumber;
    private int diamondsNumber;

    public void openChest(){

    }
    public void update(){

    }
    public void render(){

    }
    public void setRewards(){

    }
}