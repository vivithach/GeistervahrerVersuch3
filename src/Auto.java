import processing.core.PApplet;
import processing.core.PImage;

public class Auto extends Spielelement {
    private String BildAdresse = "data/Spieler.png";
    private PImage Bild = null;
    
    private int bewegung = 8;
    private int begrenzungLinks = 25;
    private int begrenzungRechts = 515;

    private boolean steuerungIstVerkehrt;

    Auto(PApplet app){
        super(app);
        setPosX(265);
        setPosY(450);
        setBreite(60);
        setHöhe(100);
        setSteuerungIstVerkehrt(false);
    }

    public void drawing(){
        if(Bild == null){
            Bild = app.loadImage(BildAdresse);
        }
        app.image(Bild,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    public void bewegeAutoNachLinks(){
        if(isSteuerungIstVerkehrt()){
            bewegeNachRechts();
        }
        else{
            bewegeNachLinks();
        }
    }

    public void bewegeAutoNachRechts(){
        if(isSteuerungIstVerkehrt()){
            bewegeNachLinks();
        }
        else{
            bewegeNachRechts();
        }
    }

    private void bewegeNachLinks() {
        if(getPosX()-bewegung <= begrenzungLinks){
            setPosX(begrenzungLinks);
        }
        else{
            setPosX(getPosX()-bewegung);
        }
    }

    private void bewegeNachRechts() {
        if (getPosX()+bewegung >= begrenzungRechts){
            setPosX(begrenzungRechts);
        }
        else{
            setPosX(getPosX()+bewegung);
        }
    }

    public void aendereSteuerung(){
        if(isSteuerungIstVerkehrt()){
            setSteuerungIstVerkehrt(false);
        }
        else{
            setSteuerungIstVerkehrt(true);
        }
    }

    public int getBewegung() {
        return bewegung;
    }

    public int getBegrenzungLinks() {
        return begrenzungLinks;
    }

    public int getBegrenzungRechts() {
        return begrenzungRechts;
    }

    public boolean isSteuerungIstVerkehrt() {
        return steuerungIstVerkehrt;
    }

    public void setSteuerungIstVerkehrt(boolean steuerungIstVerkehrt) {
        this.steuerungIstVerkehrt = steuerungIstVerkehrt;
    }
}
