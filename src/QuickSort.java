import java.util.Collections;
import java.util.List;

/**
 * Diese Klasse implementiert einen Quicksort Algorithmus
 *
 * @param <T> Der Typ der zu sortierenden Objekte.
 *            Das Objekt muss zur Vergleichbarkeit das Comparable-Interface implementieren
 */
public class QuickSort<T extends Comparable<T>> extends GenericSort<T> {

    /**
     * Sortiert die interne Liste nach dem Quicksort-Algorithmus
     *
     * @return Die sortierte Liste der Objekte
     */
    public List<T> sort() {

        // Startet quickSort mit maximalen Grenzen
        this.quickSort(0, this.elements.size() - 1);
        return this.elements;
    }

    /**
     * Rekursive Quicksort-Methoden
     *
     * @param left  Index auf den Start des Bereichs
     * @param right Index auf das Ende des Bereichs
     */
    private void quickSort(int left, int right) {

        // Index auf das bereits korrekt sortierte (mittlere) Element
        int pivotIndex;

        if (left < right) {

            // Teile die Menge und empfange den Index des Pivot
            pivotIndex = this.divide(left, right);

            // Sortiere die zwei Teil-Mengen
            this.quickSort(left, pivotIndex - 1);
            this.quickSort(pivotIndex + 1, right);
        }
    }

    /**
     * Ordnet Elemente anhand eines Pivot-Werts an
     *
     * @param start Index auf das erste Element des Bereichs
     * @param end   Index auf das letzte Element des Bereichs
     * @return Index auf das korrekt platzierte Pivot Element
     */
    private int divide(int start, int end) {

        // Wert des Pivot Element
        T pivot = this.elements.get(end);

        // Zeiger auf die kleineren Elemente
        int low = start - 1;

        // Zeiger auf die größeren Elemente
        int high;

        // Durchlaufe alle Elemente
        for (high = start; high < end; high++) {

            // Wenn das aktuelle Element kleiner als der Pivot, tausche
            if (this.elements.get(high).compareTo(pivot) < 0) {
                low++;
                Collections.swap(this.elements, low, high);
            }
        }

        // Pivot-Element zwischen kleinere und größere Elemente platzieren
        this.swap((low+1), high);
        return (low+1);
    }
}
