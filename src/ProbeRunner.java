import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Klasse zur Durchführung einer Zeitmessung für verschiedene Sortieralgorithmen
 */

public class ProbeRunner {

    // Die zu sortierenden Daten
    private Integer[] sortData;

    /**
     * Constructor
     * @param numElements Anzahl der zu erzeugenden Zahlwerte
     */
    public ProbeRunner(int numElements) {
        this.createData(numElements);
    }

    /**
     * Erzeugt die Daten für die Messung
     * @param numElements Anzahl der zu erzeugenden Zahlwerte
     */
    private void createData(int numElements) {
        this.sortData = new Integer[numElements];
        Random random = new Random();

        for (int i = 0; i < numElements; i++) {
            this.sortData[i] = random.nextInt(Integer.MAX_VALUE);
        }
    }

    /**
     * Führt die einzelnen Messungen inkl. Warm-Up durch
     * @param sort Der zu messende Sortieralgrothmus
     * @param numProbes Anzahl der Messungen
     * @return Array mit Messergebnissen
     */
    public SortMetrics runTest(GenericSort<Integer> sort, int numProbes) {

        // Ablage der einzelnen Messwerte
        long[] probeTimes = new long[numProbes];

        // Führe einen Warmup-durch, der Algorthmus wird vor der Messung 3xdurchgeführt
        for (int probeRun = 0; probeRun < 3; probeRun++) {
            // Lege eine neue Kopie der Daten an
            Integer[] probeData = Arrays.copyOf(this.sortData, this.sortData.length);
            sort.clear();
            sort.add(probeData);
            sort.sort();
        }

        // Führe die eigentliche Messung durch
        for (int probeRun = 0; probeRun < numProbes; probeRun++) {

            // Lege eine neue Kopie der Daten an
            Integer[] probeData = Arrays.copyOf(this.sortData, this.sortData.length);

            // Setze das Sortier-Objekt zurück
            sort.clear();
            sort.add(probeData);

            // Gargage Collector vor der Messung ausführen
            System.gc();

            Instant start = Instant.now();
            List<Integer> sortData = sort.sort();
            Instant end = Instant.now();
            Duration duration = Duration.between(start, end);
            probeTimes[probeRun] = duration.toMillis();

        }
        return new SortMetrics( sort.getClass().getSimpleName(), this.sortData.length, probeTimes);
    }

    /**
     * Liefert Anzahl der Testdaten
     * @return Anzahl der Elemente
     */
    public int getNumOfElements() {
        return this.sortData.length;
    }

    /**
     * Liefert die Testdaten
     * @return Testdaten
     */
    public String getData() {
        return Arrays.toString(this.sortData);
    }
}
