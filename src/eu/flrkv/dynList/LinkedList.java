package eu.flrkv.dynList;

public class LinkedList {
    private Knoten first;
    private Knoten akt;

    public LinkedList(){

    }

    ////// Diese Methoden bitte korrigieren
    //Falls die Liste nicht leer ist, wird das letzte Objekt der Liste aktuelles Objekt

    // Fehlerhaft ...
    public void toLast(){
        if (!this.isEmpty()) {
            Knoten tmp = first;
            while (tmp.getNachfolger() != null) {
                tmp = tmp.getNachfolger();
            }
            akt = tmp;
        }
    }

    //Falls es ein aktuelles Objekt gibt und pObject ungleich null ist, wird das aktuelle Objekt durch pObject ersetzt
    // Fehlerhaft
    public void setObject(Aufgabe pAufgabe){
        if (!this.hasAccess() && pAufgabe != null) {
            this.akt.setinhalt(pAufgabe);
        }
    }




    //////

    //Liefert den Wert true wenn die Liste keine Objekte enthält
    public boolean isEmpty(){
        return first == null;
    }

    //Liefert den Wert true wenn es ein aktuelles Objekt gibt
    public boolean hasAccess(){
        return akt != null;
    }

    //Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt(nicht das letzte),wird das dem aktuellen Objekt in der Liste folgende Objekt zum aktuellen Objekt, andernfalls gibt es nach Ausführung des Aufrtags kein aktuelles Objekt
    public void next(){
        if(akt != null && akt.getNachfolger() != null){
            akt=akt.getNachfolger();
        }
    }

    //Wenn Liste nicht leer --> erstes Objekt wird aktuelles Objekt
    public void toFirst(){
        if(first != null){
            akt = first;
        }
    }



    //Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt zurückgegeben
    public Aufgabe getObject(){
        if(akt!=null){
            return akt.getInhalt();
        }
        return null;
    }



    //Ein neues Objekt pObject wird am Ende der Liste angefügt. Das aktuelle Objekt bleibt unverändert. Wenn die Liste leer ist, wird das Objekt pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt. Falls pObject gleich null ist, bleibt die Liste unverändert
    public void append(Aufgabe pAufgabe){
        if(first == null){
            first = new Knoten(pAufgabe);
            return;
        }
        Knoten tmp = first;

        while (tmp.getNachfolger() != null){
            tmp = tmp.getNachfolger();
        }
        tmp.setNachfolger(new Knoten(pAufgabe)) ;
    }

    /* Falls ein aktuelles Objekt vorhanden ist, wird ein neues
     * Objekt
     */
    //Falls aktuelles Objekt vorhanden, wird ein neues Objekt vor dem aktuellen Objekt in die Liste eingefügt. Falls die Liste leer ist und es somit kein aktuelles Objekt gibt, wird pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt. Falls es kein aktuelles Objekt gibt und die Liste nicht leer ist oder pObject gleich null ist, bleibt die Liste unverändert
    public void insert(Aufgabe pAufgabe) {
        if (isEmpty()) {
            first = new Knoten(pAufgabe);
            akt = null;
            return;
        }

        if (!hasAccess() && !isEmpty()) {
            return;
        }

        Knoten tmp = first;
        while (tmp.getNachfolger() != akt && tmp.getNachfolger() != null) {
            tmp = tmp.getNachfolger();
        }
        Knoten tmpKnoten = new Knoten(pAufgabe);
        tmpKnoten.setNachfolger(akt);
        tmp.setNachfolger(tmpKnoten);
    }

    //Die Liste pList wird an die Liste angehängt. Das aktuelle Objekt bleibt unverändert. Falls pList null oder eine leere Liste ist, bleibt die Liste unverändert.
    public void concat(LinkedList pList){
        if (pList == null || pList.first == null) {
            return;
        }
        if (!isEmpty()) {
            Knoten tmp = first;
            while (tmp.getNachfolger() != null) {
                tmp = tmp.getNachfolger();
            }
            tmp.setNachfolger(pList.first);
        } else {
            first = pList.first;
        }
    }

    //Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt gelöscht und das Objekt hinter dem gelöschten Objekt wird zum aktuellen Objekt. Wird das Objekt, das am Ende der Liste steht, gelöscht, gibt es kein aktuelles Objekt mehr. Wenn die Liste leer ist oder es kein aktuelles Objekt gibt, bleibt die Liste unverändert.
    public void remove(){
        if (!isEmpty() && hasAccess()) {
            Knoten tmp = first;
            while (tmp.getNachfolger() != akt && tmp.getNachfolger() != null) {
                tmp = tmp.getNachfolger();
            }

            tmp.setNachfolger(akt.getNachfolger());
            akt = (akt.getNachfolger() != null) ? akt.getNachfolger() : null;
        }
    }
}

