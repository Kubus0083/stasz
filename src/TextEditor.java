import java.util.Stack;

public class TextEditor {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private StringBuilder document = new StringBuilder();

    public void addText(String text) {
        undoStack.push(document.toString()); // Zapisz stan przed zmianą
        document.append(text);
        redoStack.clear(); // Po dodaniu tekstu, stos redo jest czyszczony
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(document.toString()); // Zapisz bieżący stan przed cofnięciem
            document = new StringBuilder(undoStack.pop());
        } else {
            System.out.println("Brak operacji do cofnięcia.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(document.toString()); // Zapisz bieżący stan przed przywróceniem
            document = new StringBuilder(redoStack.pop());
        } else {
            System.out.println("Brak operacji do przywrócenia.");
        }
    }

    public void displayDocument() {
        System.out.println("Aktualna zawartość dokumentu:");
        System.out.println(document);
    }



}
