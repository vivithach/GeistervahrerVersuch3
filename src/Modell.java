import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Modell {

    private int spielGeschwindigkeit;
    private int hinzufruegeIntervall;
    private float lastAddTime;
    private Background background;
    private Lebensbalken leben;
    Score score;
    private PApplet app;

    SpielerAuto spieler;
    ArrayList<GegnerAuto> gegenerAutos;
    ArrayList<Herz> herzItems;
    ArrayList<Muenzen> muenzItems;
    ArrayList<Speedway> speedwayItems;
    ArrayList<Schraubenschluessel> schraubenschluesselItems;

    ScreenControll screen;
    GameScreen gameScreen;
    
    Modell(PApplet app){
        this.app = app;
        spielGeschwindigkeit = 2;

        hinzufruegeIntervall = 1000;
        lastAddTime = 0;
        gameScreen = GameScreen.START_SCREEN;
        
        gegenerAutos = new ArrayList<>();
        herzItems = new ArrayList<>();
        muenzItems = new ArrayList<>();
        speedwayItems = new ArrayList<>();
        schraubenschluesselItems = new ArrayList<>();
        background = new Background(app);
        spieler = new SpielerAuto(app);
        leben = new Lebensbalken(app);
        screen = new ScreenControll(app);
        score = new Score(app);
    }
    
    public void startGame() {
        gameScreen=GameScreen.GAME_SCREEN;
    }

    public void gameOver() {
        gameScreen=GameScreen.GAMEOVER_SCREEN;
    }

    public int erzeugeRandomZahl(String Liste) {

        List<Integer> liste = null;

        if(Liste == "anzahlGegnerAutos"){
            liste = Arrays.asList(1,2,3,4,1,2,1,2,3,4,1,2);
        }
        if(Liste == "anszahlItems"){
            liste = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
        }
        if(Liste == "fahrbahnPositionGegner"){
            liste = Arrays.asList(25,145, 265, 385, 505);
        }
        if(Liste == "fahrbahnPositionHerzMuenzen"){
            liste = Arrays.asList(40,160,280,400,520);
        }
        if(Liste == "fahrbahnPositionSchraubenschluesselSpeedway"){
            liste = Arrays.asList(15,135,255,375,495);
        }

        Random rand = new Random();
        int anzahl = liste.get(rand.nextInt(liste.size()));
        return anzahl;
    }

    public void fuegeGegeneAutosHinzu(int anzahlObjekte) {
        for(int i = 0; i < anzahlObjekte; i++){
            gegenerAutos.add(new GegnerAuto(app, erzeugeRandomZahl("fahrbahnPositionGegner")));
        }
    }

    public void loescheGegnerAuto() {
        for (int i = 0; i < gegenerAutos.size(); i++) {
            GegnerAuto AktuellesAuto = gegenerAutos.get(i);
            if (AktuellesAuto.getPosY() > 700) {
                gegenerAutos.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitGegnerAuto() {
        for(GegnerAuto aktuellesAuto: gegenerAutos){
            aktuellesAuto.drawing();
            aktuellesAuto.bewegeGegnerAuto(spielGeschwindigkeit);
            if(aktuellesAuto.kollision(spieler)){
                leben.minusLeben();
            }
        }
    }
    

    public void feugeHerzItemsHinzu(int anzahlObjekte) {
        if(anzahlObjekte == 1){
            herzItems.add(new Herz(app, erzeugeRandomZahl("fahrbahnPositionHerzMuenzen")));
        }
    }

    public void loescheHerzItem() {
        for (int i = 0; i < herzItems.size(); i++) {
            Herz aktuellesHerz = herzItems.get(i);
            if (aktuellesHerz.getPosY() > 700) {
                herzItems.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitHerzItem() {
        for(int i = 0; i< herzItems.size() ; i++){
            Herz aktuellesHerz = herzItems.get(i);
            if(aktuellesHerz.kollision(spieler)){
                herzItems.remove(i);
                leben.plusLeben();
            }
        }
    }
    
    public void fuegeMuenzenItemsHinzu(int anzahlObjekte) {
        if(anzahlObjekte == 0){
            muenzItems.add(new Muenzen(app, erzeugeRandomZahl("fahrbahnPositionHerzMuenzen")));
        }
    }

    public void loescheMuenzeItems() {
        for(int i = 0; i< muenzItems.size() ; i++){
            Muenzen aktuellesMuenze = muenzItems.get(i);
            if(aktuellesMuenze.getPosY()> 700){
                muenzItems.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitMuenzItem() {
        for(int i = 0; i< muenzItems.size() ; i++){
            Muenzen aktuellesMuenze = muenzItems.get(i);
            if(aktuellesMuenze.kollision(spieler)){
                muenzItems.remove(i);
                score.erhöheScore();
            }
        }
    }

    
    public void fuegeSpeedwayItemsHinzu(int anzahlObjekte) {
        if(anzahlObjekte == 1){
            speedwayItems.add(new Speedway(app, erzeugeRandomZahl("fahrbahnPositionSchraubenschluesselSpeedway")));
        }
    }

    public void loescheSpeedwayItems() {
        for (int i = 0; i < speedwayItems.size(); i++) {
            Speedway aktuellesspeedBlock = speedwayItems.get(i);
            if (aktuellesspeedBlock.getPosY() > 1750) {
                if (aktuellesspeedBlock.isReingefahren()) {
                    spielGeschwindigkeit = 2;
                    hinzufruegeIntervall = 1000;
                    aktuellesspeedBlock.setReingefahren(false);
                }
                speedwayItems.remove(i);
            }
        }
    }
    

    public void ueberprüfeKollisionMitSpeedwayItem() {
        for(int i = 0; i< speedwayItems.size() ; i++){
            Speedway aktuellesspeedBlock = speedwayItems.get(i);
            if(aktuellesspeedBlock.kollision(spieler)){
                spielGeschwindigkeit = 10;
                hinzufruegeIntervall = 250;
                aktuellesspeedBlock.setReingefahren(true);
            }
        }
    }
    
    
    public void fuegeSchraubenschuesselItemsHinzu(int anzahlObjekte) {
        if(anzahlObjekte == 1){
            schraubenschluesselItems.add(new Schraubenschluessel(app, erzeugeRandomZahl("fahrbahnPositionSchraubenschluesselSpeedway")));
        }
    }

    public void loescheSchraubenschluesselItems() {
        for (int i = 0; i < schraubenschluesselItems.size(); i++) {
            Schraubenschluessel aktuellesTool = schraubenschluesselItems.get(i);
            if (aktuellesTool.getPosY() > 700) {
                schraubenschluesselItems.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitSchraubenschluesselItem() {
        for(int i = 0; i< schraubenschluesselItems.size() ; i++){
            Schraubenschluessel aktuellesTool = schraubenschluesselItems.get(i);
            if(aktuellesTool.kollision(spieler)){
                schraubenschluesselItems.remove(i);
                spieler.aendereSteuerung();
            }
        }
    }

    
    public void fuegeObjekteHinzu(){
        if (app.millis()-lastAddTime > hinzufruegeIntervall) {
            fuegeGegeneAutosHinzu(erzeugeRandomZahl("anzahlGegnerAutos"));
            feugeHerzItemsHinzu(erzeugeRandomZahl("anszahlItems"));
            fuegeMuenzenItemsHinzu(erzeugeRandomZahl("anszahlItems"));
            fuegeSpeedwayItemsHinzu(erzeugeRandomZahl("anszahlItems"));
            fuegeSchraubenschuesselItemsHinzu(erzeugeRandomZahl("anszahlItems"));
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
        for(Speedway aktuellesspeedBlock: speedwayItems){
            aktuellesspeedBlock.drawing();
            aktuellesspeedBlock.bewegeSpeedway(spielGeschwindigkeit);
        }
        for(Herz aktuellesHerz: herzItems){
            aktuellesHerz.drawing();
            aktuellesHerz.bewegeHerz(spielGeschwindigkeit);
        }
        for(Muenzen aktuellesMuenze: muenzItems){
            aktuellesMuenze.drawing();
            aktuellesMuenze.bewegeMuenzen(spielGeschwindigkeit);
        }
        for(Schraubenschluessel aktuellesTool: schraubenschluesselItems){
            aktuellesTool.drawing();
            aktuellesTool.bewegeSchraubenschluessel(spielGeschwindigkeit);
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
        spieler.drawing();
        leben.drawing();
        score.drawing();
    }

    public void ueberpruefeLeben() {
        if(leben.getLeben()<= 20){
            gameOver();
        }
    }

    public void aktualisiereHintergrund() {
        background.drawing();
        background.bewegeHintergrund(spielGeschwindigkeit);
    }
}
