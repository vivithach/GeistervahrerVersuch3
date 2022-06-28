import processing.core.PApplet;
import processing.core.PImage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Schraubenschluessel extends Spielelement{
    String image_pathTool = "data/Schraubenschlüssel.png";
    PImage tool;
    private boolean geladen = false;
    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(15,135,255,375,495);
    Random rand = new Random();


    //boolean reingefahren = false;

    Schraubenschluessel(PApplet app){
        super(app);

        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-100);
        setBreite(90);
        setHöhe(40);
    }


    public void drawing(){
        if(geladen == false){
            tool = app.loadImage(image_pathTool);
            geladen = true;
        }

        app.image(tool,getPosX(),getPosY(),getBreite(),getHöhe());

    }

    public void act(int speed){
        setPosY(getPosY()+speed*5);
    }


}
