import processing.core.PImage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Herz extends Spielelement{
    String image_pathherz = "data/heart.png";
    PImage herz;

    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(40,160,280,400,520);
    Random rand = new Random();

    Herz(){
        herz = loadImage(image_pathherz);

        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-500);
        setBreite(40);
        setHöhe(40);
    }


    void drawing(){
        image(herz,getPosX(),getPosY(),getBreite(),getHöhe());

    }

    void act(int speed){
        setPosY(getPosY()+speed);
    }

    boolean kollision(Auto Spieler){
        boolean KollisionX = (getPosX() >= Spieler.getPosX() || (getPosX()+50) >= Spieler.getPosX()) && (getPosX() <= (Spieler.getPosX()+50) || (getPosX()+50) <= (Spieler.getPosX()+50));
        boolean KollisionY = (getPosY() >= Spieler.getPosY() || (getPosY()+100) >= Spieler.getPosY()) && (getPosY() <= (Spieler.getPosY()+100) || (getPosY()+100) <= (Spieler.getPosY()+100));
        return (KollisionX && KollisionY);
    }
}
