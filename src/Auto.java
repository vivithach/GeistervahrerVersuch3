import processing.core.PApplet;
import processing.core.PImage;

public class Auto extends Spielelement {
    String image_path1 = "data/Spieler.png";
    PImage Auto;

    private boolean geladen = false;

    private int bewegung = 8;
    private int randLinks = 25;
    private int randRechts = 515;

    boolean verkehrtherum = false;

    Auto(PApplet app){
        super(app);
        setPosX(265);
        setPosY(450);
        setBreite(60);
        setHöhe(100);
    }


    public void drawing(){

        if(geladen == false){
            Auto = app.loadImage(image_path1);
            geladen = true;
        }
        app.image(Auto,getPosX(),getPosY(),getBreite(),getHöhe());
    }


    public void bewegeLinks(){
        if(verkehrtherum){
            if (getPosX()+bewegung >= randRechts){
                setPosX(randRechts);
            }
            else{
                setPosX(getPosX()+bewegung);
            }
        }
        else{
            if(getPosX()-bewegung <= randLinks){
                setPosX(randLinks);
            }
            else{
                setPosX(getPosX()-bewegung);
            }
        }
    }


    public void bewegeRechts(){
        if(verkehrtherum){
            if(getPosX()-bewegung <= randLinks){
                setPosX(randLinks);
            }
            else{
                setPosX(getPosX()-bewegung);
            }
        }
        else{
            if (getPosX() + bewegung >= randRechts){
                setPosX(randRechts);
            }
            else{
                setPosX(getPosX()+bewegung);
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

    public int getBewegung() {
        return bewegung;
    }

    public int getRandLinks() {
        return randLinks;
    }

    public int getRandRechts() {
        return randRechts;
    }
}
