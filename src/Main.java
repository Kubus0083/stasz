import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWybierz operację: add, undo, redo, show, exit");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.println("Wpisz tekst do dodania:");
                    String text = scanner.nextLine();
                    editor.addText(text);
                    break;
                case "undo":
                    editor.undo();
                    break;
                case "redo":
                    editor.redo();
                    break;
                case "show":
                    editor.displayDocument();
                    break;
                case "exit":
                    System.out.println("Zamykanie edytora.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieznana komenda.");
            }
        }
    }
}
