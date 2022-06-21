import processing.core.PApplet;
import processing.core.PImage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Herz extends Spielelement{
    String image_pathherz = "data/heart.png";
    PImage herz;

    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(40,160,280,400,520);
    Random rand = new Random();

    Herz(PApplet app){
        super(app);
        herz = app.loadImage(image_pathherz);

        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-500);
        setBreite(40);
        setHöhe(40);
    }


    void drawing(){
        app.image(herz,getPosX(),getPosY(),getBreite(),getHöhe());

    }

    void act(int speed){
        setPosY(getPosY()+speed);
    }

}
