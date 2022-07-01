import processing.core.PApplet;
import processing.core.PImage;

public class Background extends Spielelement {
    private String hintergrundbildAdresse = "data/Hintergrund.png";

    private PImage hintergrundbild1 = null;
    private PImage hintergrundbild2 = null;

    private int posX_hintergrundBild1;
    private int PosY_hintergrundbild1;

    private int posX_hintergrundbild2;
    private int posY_hintergrundbild2;


    Background(PApplet app) {
        super(app);
        setPosX_hintergrundBild1(0);
        setPosX_hintergrundbild2(0);
        setPosY_hintergrundbild1(0);
        setPosY_hintergrundbild2(600);
    }

    public void drawing() {
        if(hintergrundbild1 ==null && hintergrundbild2 == null){
            hintergrundbild1 = app.loadImage(hintergrundbildAdresse);
            hintergrundbild2 = app.loadImage(hintergrundbildAdresse);
        }
        app.image(hintergrundbild1, posX_hintergrundBild1, PosY_hintergrundbild1, app.width, app.height);
        app.image(hintergrundbild2, posX_hintergrundbild2, posY_hintergrundbild2, app.width, app.height);
    }

    public void bewegeHintergrund(int speed) {
        PosY_hintergrundbild1 = PosY_hintergrundbild1 + speed;
        posY_hintergrundbild2 = posY_hintergrundbild2 + speed;

        if (PosY_hintergrundbild1 >= 600) {
            PosY_hintergrundbild1 = -600;
        }

        if (posY_hintergrundbild2 >= 600) {
            posY_hintergrundbild2 = -600;
        }
    }

    public int getPosX_hintergrundBild1() {
        return posX_hintergrundBild1;
    }

    public void setPosX_hintergrundBild1(int posX_hintergrundBild1) {
        this.posX_hintergrundBild1 = posX_hintergrundBild1;
    }

    public int getPosY_hintergrundbild1() {
        return PosY_hintergrundbild1;
    }

    public void setPosY_hintergrundbild1(int posY_hintergrundbild1) {
        PosY_hintergrundbild1 = posY_hintergrundbild1;
    }

    public int getPosX_hintergrundbild2() {
        return posX_hintergrundbild2;
    }

    public void setPosX_hintergrundbild2(int posX_hintergrundbild2) {
        this.posX_hintergrundbild2 = posX_hintergrundbild2;
    }

    public int getPosY_hintergrundbild2() {
        return posY_hintergrundbild2;
    }

    public void setPosY_hintergrundbild2(int posY_hintergrundbild2) {
        this.posY_hintergrundbild2 = posY_hintergrundbild2;
    }
}

