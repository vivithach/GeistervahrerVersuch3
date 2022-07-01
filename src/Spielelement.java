import processing.core.PApplet;

public class Spielelement {
    private int posX;
    private int posY;
    private int breite;
    private int hoehe;
    protected PApplet app;

    public Spielelement(PApplet app) {
        this.app = app;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public boolean kollision(SpielerAuto spieler){
        boolean KollisionX = (getPosX() >= spieler.getPosX() || (getPosX()+breite) >= spieler.getPosX()) && (getPosX() <= (spieler.getPosX()+breite) || (getPosX()+breite) <= (spieler.getPosX()+breite));
        boolean KollisionY = (getPosY() >= spieler.getPosY() || (getPosY()+ hoehe) >= spieler.getPosY()) && (getPosY() <= (spieler.getPosY()+ hoehe) || (getPosY()+ hoehe) <= (spieler.getPosY()+ hoehe));
        return (KollisionX && KollisionY);
    }
}
