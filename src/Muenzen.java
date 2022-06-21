import processing.core.PApplet;
import processing.core.PImage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Muenzen extends Spielelement{
    String image_pathcoin = "data/coin.png";
    PImage muenze;


    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(40,160,280,400,520);
    Random rand = new Random();

    Muenzen(PApplet app){
        super(app);
        muenze = app.loadImage(image_pathcoin);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-50);
        setBreite(40);
        setHöhe(40);
    }


    void drawing(){
        app.image(muenze,getPosX(),getPosY(),getBreite(),getHöhe());

    }

    void act(int speed){
        setPosY(getPosY()+speed);
    }


}
