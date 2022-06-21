import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Spiel extends PApplet {
    //Variablen
    int speed = 2;

    int gegnerNummer = 25;
    int AutoInterval = 1000;
    float lastAddTime = 0;

    //
    Background background;
    Auto Spieler;
    ArrayList<GegenAuto> Gegner = new ArrayList<>();
    Lebensbalken Leben;
    GameScreen gameScreen = GameScreen.START_SCREEN;
    ScreenControll Screen;
    ArrayList<Herz> herz = new ArrayList<>();
    ArrayList<Muenzen> muenze = new ArrayList<>();
    Score score;
    ArrayList<Speedway> speedBlock = new ArrayList<>();
    ArrayList<Schraubenschluessel> Tool = new ArrayList<>();


    public void settings() {
        size(600, 600);
    }

    public void setup(){


        String image_path1 = "data/Spieler.png";
        PImage Auto;
        Auto = this.loadImage(image_path1);

        String image_path2 = "data/Gegner.png";
        PImage Gegner;
        Gegner = this.loadImage(image_path2);

        String image_pathherz = "data/heart.png";
        PImage herz;
        herz = this.loadImage(image_pathherz);

        String image_pathcoin = "data/coin.png";
        PImage muenze;
        muenze = this.loadImage(image_pathherz);

        String image_pathTool = "data/Schraubenschlüssel.png";
        PImage tool;
        tool = this.loadImage(image_pathTool);

        background = new Background(this);
        Spieler = new Auto(this);
        Leben = new Lebensbalken(this);
        Screen = new ScreenControll(this);
        score = new Score(this);

    }
    public void draw(){
        if (gameScreen == GameScreen.START_SCREEN) {
            Screen.initScreen();
        } else if (gameScreen == GameScreen.GAME_SCREEN) {
            RUN();
        } else if (gameScreen == GameScreen.GAMEOVER_SCREEN) {
            Screen.gameOverScreen();
        }
    }

    void steuerungSpielerAuto() {
        if (keyPressed) {
            if (key == 'a' || keyCode == LEFT) {
                Spieler.bewegeLinks();
            }
            else if ((key == 'b' || keyCode == RIGHT))
            {
                Spieler.bewegeRechts();
            }
        }
    }



    public void mousePressed() {
        if (gameScreen==GameScreen.START_SCREEN) {
            startGame();
        }
        if (gameScreen==GameScreen.GAMEOVER_SCREEN) {
            //restart();
        }
    }

    void startGame() {
        gameScreen=GameScreen.GAME_SCREEN;
    }

    void gameOver() {
        gameScreen=GameScreen.GAMEOVER_SCREEN;
    }

    void ObjektAdder(){
        if (millis()-lastAddTime > AutoInterval) {


            //Autos
            List<Integer> anzahlAutos = Arrays.asList(1,2,3,4,1,2,1,2,3,4,1,2);
            Random rand = new Random();

            for(int i = 0; i < anzahlAutos.get(rand.nextInt(anzahlAutos.size()));i++){
                Gegner.add(new GegenAuto(this));
            }

            //Herzen
            List<Integer> anzahlHerzen = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
            Random rand2 = new Random();

            if(anzahlHerzen.get(rand2.nextInt(anzahlHerzen.size())) == 1){
                herz.add(new Herz(this));
            }

            //Münzen
            List<Integer> anzahlMuenzen = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
            Random rand3 = new Random();

            if(anzahlMuenzen.get(rand3.nextInt(anzahlMuenzen.size())) == 0){
                muenze.add(new Muenzen(this));
            }

            //SpeedBlöcke
            List<Integer> anzahlspeedBlock = Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0);
            Random rand4 = new Random();

            if(anzahlspeedBlock.get(rand4.nextInt(anzahlspeedBlock.size())) == 1){
                speedBlock.add(new Speedway(this));
            }

            //Schraubenschlüsssel
            List<Integer> anzahlTool = Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0);
            Random rand5 = new Random();

            if(anzahlTool.get(rand5.nextInt(anzahlTool.size())) == 1){
                Tool.add(new Schraubenschluessel(this));
            }


            lastAddTime = millis();
        }
    }

    void ObjektDeleter(){
        //Autos
        for(int i =0; i< Gegner.size() ;i++){
            GegenAuto AktuellesAuto = Gegner.get(i);
            if(AktuellesAuto.getPosY() > 700){
                Gegner.remove(i);
            }
        }
        //Herzen
        for(int i =0; i< herz.size() ;i++){
            Herz aktuellesHerz = herz.get(i);
            if(aktuellesHerz.getPosY() > 700){
                herz.remove(i);
            }
        }
        //Münzen
        for(int i =0; i< muenze.size() ;i++){
            Muenzen aktuellesMuenze = muenze.get(i);
            if(aktuellesMuenze.getPosY()> 700){
                muenze.remove(i);
            }
        }

        //SpeeWay
        for(int i =0; i< speedBlock.size() ;i++){
            Speedway aktuellesspeedBlock = speedBlock.get(i);
            if(aktuellesspeedBlock.getPosY() > 1750){
                if(aktuellesspeedBlock.reingefahren){
                    speed = 2;
                    AutoInterval = 1000;
                    aktuellesspeedBlock.reingefahren = false;
                }
            }
        }

        //Tools





    }



    void RUN(){

        //Überprüfen Leben
        if(Leben.getLeben()<= 20){
            gameOver();
        }

        //Hintergrund
        background.drawing();
        background.act(speed);

        //Objekt handler
        ObjektAdder();
        ObjektDeleter();


        //SpeedWay
        for(Speedway aktuellesspeedBlock:speedBlock){
            aktuellesspeedBlock.drawing();
            aktuellesspeedBlock.act(speed);

        }
        for(int i =0; i< speedBlock.size() ;i++){
            Speedway aktuellesspeedBlock = speedBlock.get(i);
            if(aktuellesspeedBlock.kollision(Spieler)){
                speed = 10;
                AutoInterval = 250;
                aktuellesspeedBlock.reingefahren = true;
            }
        }


        //Herzen
        for(Herz aktuellesHerz:herz){
            aktuellesHerz.drawing();
            aktuellesHerz.act(speed);
        }
        for(int i =0; i< herz.size() ;i++){
            Herz aktuellesHerz = herz.get(i);
            if(aktuellesHerz.kollision(Spieler)){
                herz.remove(i);
                Leben.plusLeben();
            }
        }

        //Münzen
        for(Muenzen aktuellesMuenze:muenze){
            aktuellesMuenze.drawing();
            aktuellesMuenze.act(speed);
        }
        for(int i =0; i< muenze.size() ;i++){
            Muenzen aktuellesMuenze = muenze.get(i);
            if(aktuellesMuenze.kollision(Spieler)){
                muenze.remove(i);
                score.erhöheScore();
            }
        }

        //Tools
        for(Schraubenschluessel aktuellesTool:Tool){
            aktuellesTool.drawing();
            aktuellesTool.act(speed);
        }
        for(int i =0; i< Tool.size() ;i++){
            Schraubenschluessel aktuellesTool = Tool.get(i);
            if(aktuellesTool.kollision(Spieler)){
                Tool.remove(i);
                //ändere Richtung
                Spieler.aendereRichtung();
            }
        }


        //Gegner
        for(GegenAuto aktuellesAuto:Gegner){
            aktuellesAuto.drawing();
            aktuellesAuto.act(speed);
            if(aktuellesAuto.kollision(Spieler)){
                Leben.minusLeben();
            }
        }

        steuerungSpielerAuto();
        Spieler.drawing();

        Leben.drawing();
        score.drawing();

    }
    public static void main(String[] args) {
        String[] params = {"Processing Spiel"};
        PApplet.runSketch(params, new Spiel());
    }
}

