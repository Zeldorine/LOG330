package ets.log330.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author Zeldorine
 */
public abstract class FileReader {

    private static final String SEPARATOR = ";";
    private static final String[] FILE_TYPES = {".csv", ".xlsx"};

    /**
     * Read content in the file defined by the path and put them in a list.
     *
     * @param path The file path.
     * @return A list with all data within the file defined by the path.
     */
    public static List<List<Double>> read(String path) {
        return read(path, true);
    }

    /**
     * Read content in the file defined by the path and put them in a list.
     *
     * @param path The file path.
     * @param checkTotalLine
     * @return A list with all data within the file defined by the path.
     */
    public static List<List<Double>> read(String path, boolean checkTotalLine) {
        return read(path, checkTotalLine, new int[0], new int[0]);
    }

    /**
     * Read content in the file defined by the path and put them in a list.
     *
     * @param path The file path.
     * @param checkTotalLine True if a total lines number is setted in the first
     * line on the first column
     * @param linesToRemove
     * @param columnsToRemove
     * @return A list with all data within the file defined by the path.
     */
    public static List<List<Double>> read(String path, boolean checkTotalLine, int[] linesToRemove, int[] columnsToRemove) {
        if (validatePath(path)) {
            return null;
        }

        List<String> content = extractContent(path);

        if (content == null) {
            System.out.println("file content is null, path: " + path);
            return null;
        }

        removeLines(linesToRemove, content);

        if (content.isEmpty()) {
            System.out.println("file content is empty, path: " + path);
            return null;
        } else if (content.size() == 1) {
            System.out.println("Warning: file content has only one value, path: " + path);
            Double totalElement = Double.parseDouble(content.get(0));

            if (totalElement == 0) {
                List<List<Double>> data = new LinkedList<>();
                data.add(new ArrayList<>(0));
                return data;
            } else {
                System.out.println("The total of number (lines) doesn't match with the total specified in the first line, path: " + path);
                System.out.println("Total expected: " + totalElement + " total actual: " + 0);
                return null;
            }

        }

        String currentLine = null;
        List<List<Double>> data;
        Integer totalLine = 0;

        try {
            int nbColumn = content.get(1).split(SEPARATOR).length;
            data = new LinkedList<>();

            if (checkTotalLine) {
                totalLine = Integer.parseInt(content.get(0).split(SEPARATOR)[0]);
                currentLine = content.get(0);
                content.remove(0); // Remove first line which is total number in the file.
            }

            if (convertContent(nbColumn, data, content, columnsToRemove)) {
                return null;
            }

        } catch (NumberFormatException nfe) {
            System.out.println("An error occured while reading and parsing file, a line is not a number : " + currentLine);
            return null;
        }

        removeColumns(columnsToRemove, data);

        if (verifyTotalLines(path, checkTotalLine, totalLine, data)) {
            return null;
        }

        return data;
    }

    private static boolean convertContent(int nbColumn, List<List<Double>> data, List<String> content, int[] columnsToRemove) {
        String currentLine;

        for (int i = 0; i < nbColumn; i++) {
            data.add(new ArrayList<>(content.size()));
        }

        int countLine = 1;
        for (String line : content) {
            currentLine = line;
            String[] values = line.split(SEPARATOR, -1);
            // Check if the number of column is the same that the first line
            if (values.length != nbColumn) {
                System.out.println("Error: file content has not the same number of column: ");
                System.out.println("At line " + currentLine + ", there are " + values.length + " columns and expected " + nbColumn);
                return true;
            }

            for (int i = 0; i < nbColumn; i++) {
                try {
                    data.get(i).add(Double.parseDouble(values[i].replace(",", ".")));
                } catch (NumberFormatException nfe) {
                    // If the value need to be remove dont display an alert message
                    if (!columnsToRemoveContainValue(columnsToRemove, i)) {
                        System.out.println("WARN, a line is not a number : " + currentLine + " at column " + (i + 1) + " and line " + countLine);
                    }
                }
            }

            countLine++;
        }

        return false;
    }

    private static boolean columnsToRemoveContainValue(int[] columnsToRemove, int value) {
        if (columnsToRemove.length > 0) {
            return IntStream.of(columnsToRemove).anyMatch(n -> n == value);
        }

        return false;
    }

    private static List<String> extractContent(String path) {
        List<String> content = null;

        try {
            content = Files.readAllLines(Paths.get(path));
        } catch (Exception e) {
            try {
                // If Files cannot reading file, try manually with a buffer
                content = new LinkedList<>();
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));

                String currentLine;

                while ((currentLine = br.readLine()) != null) {
                    content.add(currentLine);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("An error occured while reading file " + path);
                System.out.println(e.getMessage());
            } catch (Exception es) {
                System.out.println("An error occured while reading file " + path);
                System.out.println(e.getMessage());
            }

        }

        return content;
    }

    private static boolean validatePath(String path) {
        if (path == null || path.isEmpty()) {
            System.out.println("Path cannot be null or empty");
            return true;
        }

        boolean correctEOF = false;
        for (String fileType : FILE_TYPES) {
            if (path.endsWith(fileType)) {
                correctEOF = true;
            }
        }

        if (!correctEOF) {
            System.out.println("The file should be a csv. Path = " + path);
            return true;
        }

        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("The file should be exists and be a file not a directory. Path = " + path);
            return true;
        }

        return false;
    }

    private static boolean verifyTotalLines(String path, boolean checkTotalLine, Integer totalLine, List<List<Double>> data) {
        // If a value for total lines is specified, keep it, otherwise get a new one
        String errMsg = "The total of number (lines) doesn't match with the total specified in the first line, path: " + path;

        if (!checkTotalLine) {
            totalLine = data.get(0).size();
            errMsg = "Columns don't contain the same amount of value";
        }

        for (List<Double> list : data) {
            if (totalLine != list.size()) {
                System.out.println(errMsg);
                System.out.println("Total expected: " + totalLine + " total actual: " + list.size());
                return true;
            }
        }

        return false;
    }

    private static void removeColumns(int[] columnsToRemove, List<List<Double>> content) {
        if (columnsToRemove.length > 0) {
            Arrays.sort(columnsToRemove);

            for (int i = columnsToRemove.length - 1; i >= 0; i--) {
                if (columnsToRemove[i] < content.size()) {
                    content.remove(columnsToRemove[i]);
                    System.out.println("Remove column " + columnsToRemove[i] + " from data");
                } else {
                    System.out.println("Cannot Remove column " + columnsToRemove[i] + " from data, max column is " + content.size());
                }
            }
        }
    }

    private static void removeLines(int[] linesToRemove, List<String> content) {
        if (linesToRemove.length > 0) {
            Arrays.sort(linesToRemove);

            for (int i = linesToRemove.length - 1; i >= 0; i--) {
                if (linesToRemove[i] < content.size()) {
                    content.remove(linesToRemove[i]);
                    System.out.println("Remove line " + linesToRemove[i] + " from data");
                } else {
                    System.out.println("Cannot Remove line " + linesToRemove[i] + " from data, max line is " + content.size());
                }
            }
        }
    }

}
