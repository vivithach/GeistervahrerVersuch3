import processing.core.PApplet;
import processing.core.PImage;

public class Auto extends Spielelement {
    String image_path1 = "data/Spieler.png";
    PImage Auto;

    boolean verkehrtherum = false;

    Auto(PApplet app){
        super(app);
        Auto = app.loadImage(image_path1);
        setPosX(265);
        setPosY(450);
        setBreite(60);
        setHöhe(100);
    }


    public void drawing(){
        app.image(Auto,getPosX(),getPosY(),getBreite(),getHöhe());
    }


    public void bewegeLinks(){
        if(verkehrtherum){
            if (getPosX()+8 > 515){
                setPosX(515);
            }
            else{
                setPosX(getPosX()+8);
            }
        }
        else{
            if(getPosX()-8 < 25){
                setPosX(25);
            }
            else{
                setPosX(getPosX()-8);
            }
        }
    }


    public void bewegeRechts(){
        if(verkehrtherum){
            if(getPosX()-8 < 25){
                setPosX(25);
            }
            else{
                setPosX(getPosX()-8);
            }
        }
        else{
            if (getPosX() > 515){
                setPosX(515);
            }
            else{
                setPosX(getPosX()+8);
            }
        }
    }


    public void aendereRichtung(){
        if(verkehrtherum){
            verkehrtherum = false;
        }
        else{
            verkehrtherum = true;
        }
    }
}
