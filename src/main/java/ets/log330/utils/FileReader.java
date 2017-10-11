package ets.log330.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Zeldorine
 */
public abstract class FileReader {

    private static final String SEPARATOR = ";";
    private static final String FILE_TYPE = ".csv";

    /**
     * Read content in the file defined by the path and put them in a list.
     *
     * @param path The file path.
     * @return A list with all data within the file defined by the path.
     */
    public static List<List<Double>> read(String path) {
        if (path == null || path.isEmpty()) {
            System.out.println("Path cannot be null or empty");
            return null;
        }

        if (!path.endsWith(FILE_TYPE)) {
            System.out.println("The file should be a csv. Path = " + path);
            return null;
        }

        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("The file should be exists and be a file not a directory. Path = " + path);
            return null;
        }

        List<String> content;
        try {
            content = Files.readAllLines(Paths.get(path));
        } catch (Exception e) {
            System.out.println("An error occured while reading file " + path);
            return null;
        }

        if (content == null) {
            System.out.println("file content is null, path: " + path);
            return null;
        }

        if (content.isEmpty()) {
            System.out.println("file content is empty, path: " + path);
            return null;
        } else if (content.size() == 1) {
            System.out.println("Warning: file content has only one value, path: " + path);
            Double totalElement = Double.parseDouble(content.get(0));

            if (totalElement == 0) {
                List<List<Double>> data = new LinkedList<List<Double>>();
                data.add(new ArrayList<Double>(0));
                return data;
            } else {
                System.out.println("The total of number (lines) doesn't match with the total specified in the first line, path: " + path);
                System.out.println("Total expected: " + totalElement + " total actual: " + 0);
                return null;
            }

        }

        String currentLine = null;
        List<List<Double>> data = null;
        int totalLine = 0;

        try {
            int nbColumn = content.get(1).split(SEPARATOR).length;
            totalLine = Integer.parseInt(content.get(0).split(SEPARATOR)[0]);
            data = new LinkedList<List<Double>>();
            currentLine = content.get(0);
            content.remove(0); // Remove first line which is total number in the file.

            for (int i = 0; i < nbColumn; i++) {
                data.add(new ArrayList<Double>(content.size()));
            }

            for (String line : content) {
                currentLine = line;
                String[] values = line.split(SEPARATOR);

                // Check if the number of column is the same that the first line
                if (values.length != nbColumn) {
                    System.out.println("Error: file content has not the same number of column: ");
                    System.out.println("At line " + currentLine + ", there are " + values.length + " columns and expected " + nbColumn);
                    return null;
                }

                for (int i = 0; i < nbColumn; i++) {
                    data.get(i).add(Double.parseDouble(values[i].replace(",", ".")));
                }
            }

        } catch (NumberFormatException nfe) {
            System.out.println("An error occured while reading and parsing file, a line is not a number : " + currentLine);
            return null;
        }

        for (List<Double> list : data) {
            if (totalLine != list.size()) {
                System.out.println("The total of number (lines) doesn't match with the total specified in the first line, path: " + path);
                System.out.println("Total expected: " + totalLine + " total actual: " + list.size());
                return null;
            }
        }

        return data;
    }
}
