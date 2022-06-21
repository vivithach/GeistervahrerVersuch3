import processing.core.PImage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Schraubenschluessel extends Spielelement{
    String image_pathTool = "data/Schraubenschlüssel.png";
    PImage tool;

    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(15,135,255,375,495);
    Random rand = new Random();


    //boolean reingefahren = false;

    Schraubenschluessel(){
        tool = loadImage(image_pathTool);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-100);
        setBreite(90);
        setHöhe(40);
    }


    public void drawing(){
        image(tool,getPosX(),getPosY(),getBreite(),getHöhe());

    }

    public void act(int speed){
        setPosY(getPosY()+speed*5);
    }

    public boolean kollision(Auto Spieler){
        boolean KollisionX = (getPosX() >= Spieler.getPosX() || (getPosX()+50) >= Spieler.getPosX()) && (getPosX() <= (Spieler.getPosX()+50) || (getPosX()+50) <= (Spieler.getPosX()+50));
        boolean KollisionY = (getPosY() >= Spieler.getPosY() || (getPosY()+100) >= Spieler.getPosY()) && (getPosY() <= (Spieler.getPosY()+100) || (getPosY()+100) <= (Spieler.getPosY()+100));
        return (KollisionX && KollisionY);
    }
}
