package eu.flrkv.dynList;

public class Knoten{
    private Aufgabe inhalt;
    private Knoten nachfolger;

    public Knoten(Aufgabe pAufgabe){
        this.inhalt = pAufgabe;
    }

    public Aufgabe getInhalt(){
        return inhalt;
    }

    public Knoten getNachfolger(){
        return nachfolger;
    }

    public void setNachfolger(Knoten nachfolger) {
        this.nachfolger = nachfolger;
    }

    public void setinhalt(Aufgabe pInhalt){
        inhalt = pInhalt;
    }

}
