package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.MyGdxGame;

import java.io.Serializable;

public class TrajectoryActor extends Actor implements Serializable {
    Texture ball = new Texture(Gdx.files.internal("coin.png"));
    private Controller controller;
    private ProjectileEquation projectileEquation;
    private Sprite trajectorySprite=new Sprite(ball);

    public int trajectoryPointCount = 30;
    public float timeSeparation = 1f;

    public TrajectoryActor(Controller controller, float gravity) {
        this.controller = controller;
        this.projectileEquation = new ProjectileEquation();
        this.projectileEquation.gravity = gravity;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        projectileEquation.startVelocity.set(controller.power, 0f);
        projectileEquation.startVelocity.rotateDeg(controller.angle);
    }

    //@Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        float t = 0f;
        float width = this.getWidth();
        float height = this.getHeight();

        float timeSeparation = this.timeSeparation;

        for (int i = 0;  i<trajectoryPointCount; i++) {
            float x = this.getX() + projectileEquation.getX(t);
            float y = this.getY() + projectileEquation.getY(t);

            batch.setColor(this.getColor());
            batch.draw(trajectorySprite, x/ MyGdxGame.PPM, y/MyGdxGame.PPM, width, height);

            t += timeSeparation;
        }
    }

    //@Override
    public Actor hit(float x, float y) {
        return null;
    }
}