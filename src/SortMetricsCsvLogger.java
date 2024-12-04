import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Klasse zum Speichern der Messergebnisse in einer CSV-Datei
 */
public class SortMetricsCsvLogger {

    /**
     * Pfad und Dateiname der CSV-Datei
     */
    private final String filePath;

    /**
     * Constructor
     * @param filePath Pfad und Name der CSV Datei
     */
    public SortMetricsCsvLogger(String filePath) {

        this.filePath = filePath;

        // Header zur Datei hinzufügen, falls die Datei noch nicht existiert
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            if (new java.io.File(filePath).length() == 0) {
                writer.println("Name,NumElements,Avg,Min,Max,ProbeTimes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Schreibt die Ergebnisse einer Messreihe in einer CSV-Zeile
     * @param metrics Ergebnisse einer Messreihe
     */
    public void log(SortMetrics metrics) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.printf("%s,%d,%d,%d,%d%n",
                    metrics.name,
                    metrics.count,
                    metrics.avg,
                    metrics.min,
                    metrics.max
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
