class TextEditor {
    private String text = "";

    public void write(String newText) {
        text += newText;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        this.text = memento.getText();
    }

    public void show() {
        System.out.println("Text: " + text);
    }
}
