  import java.util.HashMap;

/**
 * Hauptklasse
 * <p>
 * Führt eine Messung mit den verschiedenen Suchklassen durch und protokolliert die Ergebnisse in einer Logdatei
 */
public class Main {

    /**
     * Einstiegspunkt der Applikation
     *
     * @param args
     */
    public static void main(String[] args) {

        // Liste mit den zu testenden Algorithmen
        HashMap<String, GenericSort<Integer>> sortingAlgorithms = new HashMap<>();
        sortingAlgorithms.put("bubble", new BubbleSort<>());
        sortingAlgorithms.put("selection", new SelectionSort<>());
        sortingAlgorithms.put("quick", new QuickSort<>());




        // Menge der zu sortierenen Objekte pro Durchfang
        int[] numElements = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 900000, 100000};
        // int[] numElements = {1000, 2000, 5000};

        // CSV-Logger
        SortMetricsCsvLogger logger = new SortMetricsCsvLogger("sort_metrics.csv");

        for (int number : numElements) {

            ProbeRunner probeRunner = new ProbeRunner(number);

            // Bei Messungen mit > 50k Objekten Bubblesort ausschließen
            if(number > 100000) {
                sortingAlgorithms.remove("bubble");
            }

            // Bei Messungen mit > 100k Objekten Selection ausschließen
            if(number > 200000) {
                sortingAlgorithms.remove("selection");
            }

            for (GenericSort<Integer> algorithm : sortingAlgorithms.values()) {

                System.out.println("Sortiere nach "+algorithm.toString()+" mit "+number+" Elementen");

                // Messung durchführen und Ergebnisse empfangen
                SortMetrics metrics = probeRunner.runTest(algorithm, 3);

                // Messung in CSV-Datei ablegen
                logger.log(metrics);
            }
        }
    }
}