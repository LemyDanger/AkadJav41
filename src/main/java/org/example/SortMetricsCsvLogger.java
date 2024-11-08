package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortMetricsCsvLogger {

    private final String filePath;

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

    public void log(SortMetrics metrics) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.printf("%s,%d,%d,%d,%d%n",
                    metrics.getName(),
                    metrics.getNumElemnts(),
                    metrics.avg,
                    metrics.min,
                    metrics.max
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
