import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Modell {

    private int SpielGeschwindigkeit;
    private int hinzufruegeIntervall;
    private float lastAddTime;
    private Background background;
    private Lebensbalken Leben;
    private Score score;
    private PApplet app;

    SpielerAuto Spieler;
    ArrayList<GegnerAuto> GegenerAutos;
    ArrayList<Herz> HerzItems;
    ArrayList<Muenzen> MuenzItems;
    ArrayList<Speedway> SpeedwayItems;
    ArrayList<Schraubenschluessel> SchraubenschluesselItems;

    ScreenControll Screen;
    GameScreen gameScreen;


    Modell(PApplet app){

        this.app = app;
        SpielGeschwindigkeit = 2;

        hinzufruegeIntervall = 1000;
        lastAddTime = 0;
        gameScreen = GameScreen.START_SCREEN;


        GegenerAutos = new ArrayList<>();
        HerzItems = new ArrayList<>();
        MuenzItems = new ArrayList<>();
        SpeedwayItems = new ArrayList<>();
        SchraubenschluesselItems = new ArrayList<>();
        background = new Background(app);
        Spieler = new SpielerAuto(app);
        Leben = new Lebensbalken(app);
        Screen = new ScreenControll(app);
        score = new Score(app);

    }



    void startGame() {
        gameScreen=GameScreen.GAME_SCREEN;
    }

    void gameOver() {
        gameScreen=GameScreen.GAMEOVER_SCREEN;
    }


    public void fuegeGegeneAutosHinzu() {
        List<Integer> anzahlAutos = Arrays.asList(1,2,3,4,1,2,1,2,3,4,1,2);
        Random rand = new Random();

        for(int i = 0; i < anzahlAutos.get(rand.nextInt(anzahlAutos.size()));i++){
            GegenerAutos.add(new GegnerAuto(app));
        }
    }

    public void loescheGegnerAuto() {
        for (int i = 0; i < GegenerAutos.size(); i++) {
            GegnerAuto AktuellesAuto = GegenerAutos.get(i);
            if (AktuellesAuto.getPosY() > 700) {
                GegenerAutos.remove(i);
            }
        }
    }


    public void fuegeHerzenHinzu() {
        List<Integer> anzahlHerzen = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
        Random rand2 = new Random();

        if(anzahlHerzen.get(rand2.nextInt(anzahlHerzen.size())) == 1){
            HerzItems.add(new Herz(app));
        }
    }

    public void loescheHerz() {
        for (int i = 0; i < HerzItems.size(); i++) {
            Herz aktuellesHerz = HerzItems.get(i);
            if (aktuellesHerz.getPosY() > 700) {
                HerzItems.remove(i);
            }
        }
    }


    public void fuegeMuenzenHinzu() {
        List<Integer> anzahlMuenzen = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
        Random rand3 = new Random();

        if(anzahlMuenzen.get(rand3.nextInt(anzahlMuenzen.size())) == 0){
            MuenzItems.add(new Muenzen(app));
        }
    }

    public void loescheMuenze() {
        for(int i = 0; i< MuenzItems.size() ; i++){
            Muenzen aktuellesMuenze = MuenzItems.get(i);
            if(aktuellesMuenze.getPosY()> 700){
                MuenzItems.remove(i);
            }
        }
    }

    public void fuegeSpeedwaysHinzu() {
        List<Integer> anzahlspeedBlock = Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0);
        Random rand4 = new Random();

        if(anzahlspeedBlock.get(rand4.nextInt(anzahlspeedBlock.size())) == 1){
            SpeedwayItems.add(new Speedway(app));
        }
    }

    public void loescheSpeedway() {
        for (int i = 0; i < SpeedwayItems.size(); i++) {
            Speedway aktuellesspeedBlock = SpeedwayItems.get(i);
            if (aktuellesspeedBlock.getPosY() > 1750) {
                if (aktuellesspeedBlock.isReingefahren()) {
                    SpielGeschwindigkeit = 2;
                    hinzufruegeIntervall = 1000;
                    aktuellesspeedBlock.setReingefahren(false);
                }
                SpeedwayItems.remove(i);
            }
        }
    }

    public void fuegeSchraubenschuesselHinzu() {
        List<Integer> anzahlTool = Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0);
        Random rand5 = new Random();

        if(anzahlTool.get(rand5.nextInt(anzahlTool.size())) == 1){
            SchraubenschluesselItems.add(new Schraubenschluessel(app));
        }
    }

    public void loescheSchraubenschluessel() {
        for (int i = 0; i < SchraubenschluesselItems.size(); i++) {
            Schraubenschluessel aktuellesTool = SchraubenschluesselItems.get(i);
            if (aktuellesTool.getPosY() > 700) {
                SchraubenschluesselItems.remove(i);
            }
        }
    }


    public void fuegeObjekteHinzu(){
        if (app.millis()-lastAddTime > hinzufruegeIntervall) {
            fuegeGegeneAutosHinzu();
            fuegeHerzenHinzu();
            fuegeMuenzenHinzu();
            fuegeSpeedwaysHinzu();
            fuegeSchraubenschuesselHinzu();
            lastAddTime = app.millis();
        }
    }

    public void loescheObjekte(){
        loescheGegnerAuto();
        loescheSpeedway();
        loescheHerz();
        loescheMuenze();
        loescheSchraubenschluessel();
    }

    public void aktualiesiereZustand() {
        if(Leben.getLeben()<= 20){
            gameOver();
        }
        background.drawing();
        background.bewegeHintergrund(SpielGeschwindigkeit);
        for(Speedway aktuellesspeedBlock: SpeedwayItems){
            aktuellesspeedBlock.drawing();
            aktuellesspeedBlock.bewegeSpeedway(SpielGeschwindigkeit);
        }
        for(Herz aktuellesHerz: HerzItems){
            aktuellesHerz.drawing();
            aktuellesHerz.bewegeHerz(SpielGeschwindigkeit);
        }
        for(Muenzen aktuellesMuenze: MuenzItems){
            aktuellesMuenze.drawing();
            aktuellesMuenze.bewegeMuenzen(SpielGeschwindigkeit);
        }
        for(Schraubenschluessel aktuellesTool: SchraubenschluesselItems){
            aktuellesTool.drawing();
            aktuellesTool.bewegeSchraubenschluessel(SpielGeschwindigkeit);
        }
        Spieler.drawing();
        Leben.drawing();
        score.drawing();
    }



    void RUN(){

        fuegeObjekteHinzu();
        loescheObjekte();
        aktualiesiereZustand();


        for(int i = 0; i< SpeedwayItems.size() ; i++){
            Speedway aktuellesspeedBlock = SpeedwayItems.get(i);
            if(aktuellesspeedBlock.kollision(Spieler)){
                SpielGeschwindigkeit = 10;
                hinzufruegeIntervall = 250;
                aktuellesspeedBlock.setReingefahren(true);
            }
        }


        for(int i = 0; i< HerzItems.size() ; i++){
            Herz aktuellesHerz = HerzItems.get(i);
            if(aktuellesHerz.kollision(Spieler)){
                HerzItems.remove(i);
                Leben.plusLeben();
            }
        }


        for(int i = 0; i< MuenzItems.size() ; i++){
            Muenzen aktuellesMuenze = MuenzItems.get(i);
            if(aktuellesMuenze.kollision(Spieler)){
                MuenzItems.remove(i);
                score.erhöheScore();
            }
        }

        for(int i = 0; i< SchraubenschluesselItems.size() ; i++){
            Schraubenschluessel aktuellesTool = SchraubenschluesselItems.get(i);
            if(aktuellesTool.kollision(Spieler)){
                SchraubenschluesselItems.remove(i);
                //ändere Richtung
                Spieler.aendereSteuerung();
            }
        }

        for(GegnerAuto aktuellesAuto: GegenerAutos){
            aktuellesAuto.drawing();
            aktuellesAuto.bewegeGegnerAuto(SpielGeschwindigkeit);
            if(aktuellesAuto.kollision(Spieler)){
                Leben.minusLeben();
            }
        }
    }


    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    public int getSpielGeschwindigkeit() {
        return SpielGeschwindigkeit;
    }

    public void setSpielGeschwindigkeit(int spielGeschwindigkeit) {
        this.SpielGeschwindigkeit = spielGeschwindigkeit;
    }
}
