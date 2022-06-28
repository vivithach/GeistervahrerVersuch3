import processing.core.PApplet;

public class Spielelement {
    private int PosX;
    private int PosY;
    private int breite;
    private int höhe;
    protected PApplet app;

    public Spielelement(PApplet app) {
        this.app = app;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getHöhe() {
        return höhe;
    }

    public void setHöhe(int höhe) {
        this.höhe = höhe;
    }

    public boolean kollision(Auto Spieler){
        boolean KollisionX = (getPosX() >= Spieler.getPosX() || (getPosX()+breite) >= Spieler.getPosX()) && (getPosX() <= (Spieler.getPosX()+breite) || (getPosX()+breite) <= (Spieler.getPosX()+breite));
        boolean KollisionY = (getPosY() >= Spieler.getPosY() || (getPosY()+höhe) >= Spieler.getPosY()) && (getPosY() <= (Spieler.getPosY()+höhe) || (getPosY()+höhe) <= (Spieler.getPosY()+höhe));
        return (KollisionX && KollisionY);
    }
}
