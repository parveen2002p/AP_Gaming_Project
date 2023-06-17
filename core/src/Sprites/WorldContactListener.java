package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
       // Gdx.app.log("Begin","");
        Fixture f1 = contact.getFixtureA();
        Fixture f2 = contact.getFixtureB();
        //int cdef= f1.getFilterData().categoryBits | f2.getFilterData().categoryBits;

        if (f1.getUserData()=="Agni" || f2.getUserData()=="Agni"){
            agni.setToDestroy=true;
            Fixture head = f1.getUserData()=="Agni" ? f1 : f2;
            Fixture object = head == f1? f2:f1;}
        else if (f1.getUserData()=="Agni2" || f2.getUserData()=="Agni2"){
            agni2.setToDestroy2=true;
            Fixture head = f1.getUserData()=="Agni2" ? f1 : f2;
            Fixture object = head == f1? f2:f1;}


//            if (object.getUserData()!=null && mario2.class.isAssignableFrom(object.getUserData().getClass())){
//                    ((mario2)object.getUserData()).onHeadHit();
//                }
//            if (object.getUserData()!=null && mario.class.isAssignableFrom(object.getUserData().getClass())){
//                ((mario)object.getUserData()).onHeadHit();
//            }
//            try {
//                if (object.getUserData()!=null && mario2.class.isAssignableFrom(object.getUserData().getClass())){
//                    ((mario2)object.getUserData()).onHeadHit();
//                }
//            }
//            catch (Exception e){
//                System.out.println("YES OCC");
//            }
//            if (object.getUserData()!=null && mario.class.isAssignableFrom(object.getUserData().getClass())){
//                ((mario)object.getUserData()).onHeadHit();
//            }

//            switch (cdef){
//                case MyGdxGame.AGNI_BIT | MyGdxGame.MARIO2_BIT:
//                    if (f1.getFilterData().categoryBits==MyGdxGame.AGNI_BIT){
//                        ((mario2)f1.getUserData()).onHeadHit();
//                        agni.setToDestroy=true;
//
//                    }
//                    else if (f2.getFilterData().categoryBits==MyGdxGame.AGNI_BIT){
//                        ((mario2)f1.getUserData()).onHeadHit();
//                        agni.setToDestroy=true;
//                    }
//                    break;
//                case MyGdxGame.AGNI_BIT | MyGdxGame.DEFAULT_BIT:
//                    if (f1.getFilterData().categoryBits==MyGdxGame.AGNI_BIT){
//                        agni.setToDestroy=true;
//                        //((mario)f1.getUserData()).onHeadHit();
//                    }
//                    else if (f2.getFilterData().categoryBits==MyGdxGame.AGNI_BIT){
//                        agni.setToDestroy=true;
//                        //((mario2)f1.getUserData()).onHeadHit();
//                    }
//                    break;
//                case MyGdxGame.AGNI_BIT | MyGdxGame.MARIO1_BIT:
//                    if (f1.getFilterData().categoryBits==MyGdxGame.AGNI_BIT){
//                        ((mario)f1.getUserData()).onHeadHit();
//                        agni.setToDestroy=true;
//                    }
//                    else if (f2.getFilterData().categoryBits==MyGdxGame.AGNI_BIT){
//                        ((mario)f1.getUserData()).onHeadHit();
//                        agni.setToDestroy=true;
//                    }
//                    break;
            }




    @Override
    public void endContact(Contact contact) {
        //Gdx.app.log("end","");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
