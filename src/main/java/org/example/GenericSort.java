package org.example;

import java.util.*;

/**
 * Generische Basisklasse zur Sortierung von Objekten
 *
 * @param <T> Der Typ der zu sortierenden Objekte.
 *            Das Objekt muss zur Vergleichbarkeit das Comparable-Interface implementieren
 */
public abstract class GenericSort<T extends Comparable<T>> {

    /**
     * Interne Liste zur Ablage der zu sortierenden Objekte
     */
    protected ArrayList<T> elements = new ArrayList<>();

    /**
     * Fügt ein zu sortierendes Objekt hinzu
     *
     * @param element Das hinzuzufügende Objekte
     */
    public void add(T element) {
        this.elements.add(element);
    }

    /**
     * Fügt ein Array mit zu sortierenden Objekten hinzu
     *
     * @param elements Das Array mit hinzuzufügenden Objekten
     */
    public void add(T[] elements) {
        this.elements.addAll(Arrays.asList(elements));
    }

    /**
     * Gibt die interne Liste der Objekte zurück
     *
     * @return Liste der Objekte
     */
    public ArrayList<T> get() {
        return this.elements;
    }

    public void clear() {
        this.elements = new ArrayList<>();
    }


    /**
     * Tauscht zwei Objekte in der Liste
     *
     * @param i Index des 1. Objekts
     * @param j Index des 2. Objekts
     * @throws IndexOutOfBoundsException – Falls einer der Indexe außerhalb der Liste liegt
     * @see Collections
     */
    protected void swap(int i, int j) {
        // Tausch wird mit der swap-Methode der Collections-Class durchgeführt
        Collections.swap(this.elements,i,j);
    }

    /**
     * Sortiert die interne Liste, muss von einer Unterklasse implementiert werden
     *
     * @return Die sortierte Liste der Objekte
     */
    public abstract List<T> sort();


}
