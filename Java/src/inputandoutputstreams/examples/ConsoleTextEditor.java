package inputandoutputstreams.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleTextEditor {

    private File file;

    public ConsoleTextEditor(File file) {
        this.file = file;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder content = new StringBuilder();

            System.out.println("Welcome to the Console Text Editor!");

            while (true) {
                System.out.print("Enter text (type 'exit' to finish): ");
                String input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input.trim())) {
                    break;
                }

                content.append(input).append("\n");
            }

            writeToFile(content.toString());

            System.out.println("\nContent of the file:");
            displayFileContent();

            System.out.println("\nConsole Text Editor has ended.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private void writeToFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
            System.out.println("Text has been written to the file.");
        }
    }

    private void displayFileContent() throws IOException {
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        }
    }
}
