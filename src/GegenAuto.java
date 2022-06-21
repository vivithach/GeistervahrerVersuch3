import processing.core.PApplet;
import processing.core.PImage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GegenAuto extends Spielelement{
    String image_path2 = "data/Gegner.png";
    PImage Gegner;


    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(25,145, 265, 385, 505);
    Random rand = new Random();


    GegenAuto(PApplet app){
        super(app);
        Gegner = app.loadImage(image_path2);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-400);
        setBreite(60);
        setHöhe(100);

    }


    void drawing(){
        app.image(Gegner,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    void act(int speed){
        setPosY(getPosY()+(speed*2));
    }


}
