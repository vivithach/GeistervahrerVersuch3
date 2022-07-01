import processing.core.PApplet;
import processing.core.PImage;

public class SpielerAuto extends Spielelement {
    private String bildAdresse = "data/Spieler.png";
    private PImage bild = null;

    private int bewegeObjektUmEinheiten = 8;
    private int begrenzungLinks = 25;
    private int begrenzungRechts = 515;

    private boolean steuerungIstVerkehrt;

    SpielerAuto(PApplet app){
        super(app);
        setPosX(265);
        setPosY(450);
        setBreite(60);
        setHoehe(100);
        setSteuerungIstVerkehrt(false);
    }

    public void drawing(){
        if(bild == null){
            bild = app.loadImage(bildAdresse);
        }
        app.image(bild,getPosX(),getPosY(),getBreite(), getHoehe());
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
        if(getPosX()- bewegeObjektUmEinheiten <= begrenzungLinks){
            setPosX(begrenzungLinks);
        }
        else{
            setPosX(getPosX()- bewegeObjektUmEinheiten);
        }
    }

    private void bewegeNachRechts() {
        if (getPosX()+ bewegeObjektUmEinheiten >= begrenzungRechts){
            setPosX(begrenzungRechts);
        }
        else{
            setPosX(getPosX()+ bewegeObjektUmEinheiten);
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

    public int getBewegeObjektUmEinheiten() {
        return bewegeObjektUmEinheiten;
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
