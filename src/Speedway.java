import processing.core.PApplet;
import processing.core.PImage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Speedway extends Spielelement{
    String image_pathrain = "data/rainbow.png";
    PImage rain;
    private boolean geladen = false;
    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(15,135,255,375,495);
    Random rand = new Random();

    boolean reingefahren = false;

    Speedway(PApplet app){
        super(app);

        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-100);
        setBreite(90);
        setHöhe(40);
    }


    void drawing(){
        if(geladen == false){
            rain = app.loadImage(image_pathrain);
            geladen = true;
        }
        app.image(rain,getPosX(),getPosY(),getBreite(),getHöhe());

    }

    void act(int speed){
        setPosY(getPosY()+speed);
    }


}
