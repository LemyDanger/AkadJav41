/**
 * Klasse zur Aufnahme einer Messreihe und zur Berechnung von Minimal-, Maximal- und Durchschnittswert einer Messreihe
 */
public class SortMetrics {

    /**
     * Array mit den verschiedenen Messungen
     */
    private long[] probeTimes;

    /**
     * Name des Sortieralgorithmus
     */
    public String name;


    /**
     * Anzahl der Datensätze
     */
    public int count = 0;

    /**
     * Minamal-, Maximal- und Durchschnittswert der Messungen
     */
    public long min = 0, max = 0, avg = 0;


    /**
     * Konstruktor
     *
     * @param name       Name des Algorithmus
     * @param count     Anzahl der zu sortierenden Elemente
     * @param probeTimes Array mit Messwerten
     */
    public SortMetrics(String name, int count, long[] probeTimes) {
        this.name = name;
        this.count = count;
        this.probeTimes = probeTimes;
        this.calcMetrics();
    }

    /**
     * Berechne Minimum, Maximum und Durchschnitt der Messungen
     */
    private void calcMetrics() {

        if (this.probeTimes.length < 1) {
            // Keine Messwerte vorhanden
            return;
        }

        int sum = 0;

        this.min = this.probeTimes[0];
        this.max = this.probeTimes[0];

        for (long value : this.probeTimes) {
            sum += value;
            this.min = (value < this.min) ? value : this.min;
            this.max = (value > this.max) ? value : this.max;
        }
        this.avg = (sum / this.probeTimes.length);
    }

}
