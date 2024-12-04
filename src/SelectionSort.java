import java.util.List;

/**
 * Diese Klasse implementiert einen Selection-Sort Algorithmus
 *
 * @param <T> Der Typ der zu sortierenden Objekte.
 *            Das Objekt muss zur Vergleichbarkeit das Comparable-Interface implementieren
 */
public class SelectionSort<T extends Comparable<T>> extends GenericSort<T> {

    /**
     * Sortiert die interne Liste nach dem Selection-Algorithmus
     *
     * @return Die sortierte Liste der Objekte
     */
    public List<T> sort() {

        int i, j, min;
        int n = this.elements.size();


        // Durchlaufe die Daten von Anfang bis Ende
        for (i = 0; i < n - 1; i++) {

            // Ersten Index für den kleinsten Wert merken
            min = i;

            // Durchlaufe die restlichen Daten
            for (j = i + 1; j < n; j++) {

                // Falls ein kleinerer Wert gefunden wurde, dessen Index merken
                if (this.elements.get(j).compareTo(this.elements.get(min)) < 0) {
                    min = j;
                }
            }

            // Falls ein kleinerer Wert gefunden wurde, tauschen
            if (min != i) {
                swap(i, min);
            }
        }
        return this.elements;
    }
}

