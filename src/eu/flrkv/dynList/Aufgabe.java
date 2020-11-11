package eu.flrkv.dynList;

public class Aufgabe{

    private String text;

    public Aufgabe(String pText){
        setText(pText);
    }

    public void setText(String pText){
        text = pText;
    }

    public String getText(){
        return text;
    }
}
