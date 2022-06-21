import processing.core.PApplet;
import processing.core.PImage;

public class Background extends Spielelement{
    String image_path = "data/Hintergrund.png";

    PImage background1;
    PImage background2;

    private int background1_x = 0;
    private int background1_y = 0;

    private int background2_x = 0;
    private int background2_y = height;

    Background(){
        background1 = loadImage(image_path);
        background2 = loadImage(image_path);
    }

    void drawing(){
        image(background1,background1_x,background1_y,width,height);
        image(background2,background2_x,background2_y,width,height);
    }

    void act(int speed){
        background1_y = background1_y + speed;
        background2_y = background2_y + speed;

        if(background1_y >= height){
            background1_y = -height;
        }
        if(background2_y >= height){
            background2_y = -height;
        }

    }
}

