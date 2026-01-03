public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello ");
        history.save(editor.save());

        editor.write("World ");
        history.save(editor.save());

        editor.write("!!!");
        editor.show();

        editor.restore(history.undo());
        editor.show();

        editor.restore(history.undo());
        editor.show();
    }
}
