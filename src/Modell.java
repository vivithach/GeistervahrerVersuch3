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

    public int erzeugeAnzahlVonObjekten(int ListenNummer) {
        List<Integer> liste = null;
        if(ListenNummer == 1){
            liste = Arrays.asList(1,2,3,4,1,2,1,2,3,4,1,2);
        }
        if(ListenNummer == 2){
            liste = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
        }

        Random rand = new Random();
        int anzahl = liste.get(rand.nextInt(liste.size()));
        return anzahl;
    }

    public void fuegeGegeneAutosHinzu() {
        for(int i = 0; i < erzeugeAnzahlVonObjekten(1); i++){
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

    public void ueberpruefeKollisionMitGegnerAuto() {
        for(GegnerAuto aktuellesAuto: GegenerAutos){
            aktuellesAuto.drawing();
            aktuellesAuto.bewegeGegnerAuto(SpielGeschwindigkeit);
            if(aktuellesAuto.kollision(Spieler)){
                Leben.minusLeben();
            }
        }
    }
    

    public void feugeHerzItemsHinzu() {
        if(erzeugeAnzahlVonObjekten(2) == 1){
            HerzItems.add(new Herz(app));
        }
    }

    public void loescheHerzItem() {
        for (int i = 0; i < HerzItems.size(); i++) {
            Herz aktuellesHerz = HerzItems.get(i);
            if (aktuellesHerz.getPosY() > 700) {
                HerzItems.remove(i);
            }
        }
    }

    private void ueberpruefeKollisionMitHerzItem() {
        for(int i = 0; i< HerzItems.size() ; i++){
            Herz aktuellesHerz = HerzItems.get(i);
            if(aktuellesHerz.kollision(Spieler)){
                HerzItems.remove(i);
                Leben.plusLeben();
            }
        }
    }
    
    public void fuegeMuenzenItemsHinzu() {
        if(erzeugeAnzahlVonObjekten(2) == 0){
            MuenzItems.add(new Muenzen(app));
        }
    }

    public void loescheMuenzeItems() {
        for(int i = 0; i< MuenzItems.size() ; i++){
            Muenzen aktuellesMuenze = MuenzItems.get(i);
            if(aktuellesMuenze.getPosY()> 700){
                MuenzItems.remove(i);
            }
        }
    }

    private void ueberpruefeKollisionMitMuenzItem() {
        for(int i = 0; i< MuenzItems.size() ; i++){
            Muenzen aktuellesMuenze = MuenzItems.get(i);
            if(aktuellesMuenze.kollision(Spieler)){
                MuenzItems.remove(i);
                score.erhöheScore();
            }
        }
    }

    
    public void fuegeSpeedwayItemsHinzu() {
        if(erzeugeAnzahlVonObjekten(2) == 1){
            SpeedwayItems.add(new Speedway(app));
        }
    }

    public void loescheSpeedwayItems() {
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
    

    private void ueberprüfeKollisionMitSpeedwayItem() {
        for(int i = 0; i< SpeedwayItems.size() ; i++){
            Speedway aktuellesspeedBlock = SpeedwayItems.get(i);
            if(aktuellesspeedBlock.kollision(Spieler)){
                SpielGeschwindigkeit = 10;
                hinzufruegeIntervall = 250;
                aktuellesspeedBlock.setReingefahren(true);
            }
        }
    }
    
    
    public void fuegeSchraubenschuesselItemsHinzu() {
        if(erzeugeAnzahlVonObjekten(2) == 1){
            SchraubenschluesselItems.add(new Schraubenschluessel(app));
        }
    }

    public void loescheSchraubenschluesselItems() {
        for (int i = 0; i < SchraubenschluesselItems.size(); i++) {
            Schraubenschluessel aktuellesTool = SchraubenschluesselItems.get(i);
            if (aktuellesTool.getPosY() > 700) {
                SchraubenschluesselItems.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitSchraubenschluesselItem() {
        for(int i = 0; i< SchraubenschluesselItems.size() ; i++){
            Schraubenschluessel aktuellesTool = SchraubenschluesselItems.get(i);
            if(aktuellesTool.kollision(Spieler)){
                SchraubenschluesselItems.remove(i);
                Spieler.aendereSteuerung();
            }
        }
    }

    
    public void fuegeObjekteHinzu(){
        if (app.millis()-lastAddTime > hinzufruegeIntervall) {
            fuegeGegeneAutosHinzu();
            feugeHerzItemsHinzu();
            fuegeMuenzenItemsHinzu();
            fuegeSpeedwayItemsHinzu();
            fuegeSchraubenschuesselItemsHinzu();
            lastAddTime = app.millis();
        }
    }

    public void loescheObjekte(){
        loescheGegnerAuto();
        loescheSpeedwayItems();
        loescheHerzItem();
        loescheMuenzeItems();
        loescheSchraubenschluesselItems();
    }

    public void aktualiesiereZustandItems() {
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
    }
    
    public void ueberpruefeKollisionMitObjekt() {
        ueberprüfeKollisionMitSpeedwayItem();
        ueberpruefeKollisionMitHerzItem();
        ueberpruefeKollisionMitMuenzItem();
        ueberpruefeKollisionMitSchraubenschluesselItem();
        ueberpruefeKollisionMitGegnerAuto();
    }
    
    public void RUN(){
        ueberpruefeLeben();
        aktualisiereHintergrund();
        fuegeObjekteHinzu();
        loescheObjekte();
        aktualiesiereZustandItems();
        ueberpruefeKollisionMitObjekt();
        Spieler.drawing();
        Leben.drawing();
        score.drawing();
    }

    public void ueberpruefeLeben() {
        if(Leben.getLeben()<= 20){
            gameOver();
        }
    }

    public void aktualisiereHintergrund() {
        background.drawing();
        background.bewegeHintergrund(SpielGeschwindigkeit);
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
