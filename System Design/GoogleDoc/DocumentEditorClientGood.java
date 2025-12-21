import java.io.FileWriter;
import java.util.ArrayList;

interface DocumentElement{
    public abstract String  render();
}

class TextElement implements DocumentElement{
    private String text;
    
    public TextElement(String text){
        this.text=text;
    }

    @Override
    public String render(){
        return text;
    }
}

class ImageElement implements DocumentElement{
    private String imagePath;

    public ImageElement(String imagePath){
        this.imagePath=imagePath;
    }

    @Override
    public String render(){
        return("[ "+"Image path is "+imagePath+" ]");
    }
}

class NewLine implements DocumentElement{
    @Override
    public String render(){
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement{
    @Override
    public String render(){
        return "\t";
    }
}


// document class is responsible for holding a collection of elements
class Document{
    private ArrayList<DocumentElement> documentElements=new ArrayList<>();

    public void addElement(DocumentElement element){
        documentElements.add(element);
    }

    //render the document by concatenating the render output of all elements
    public String render(){
        StringBuilder result = new StringBuilder();
        for(DocumentElement element : documentElements){
            result.append(element.render());
        }
        return result.toString();
    }
}

//persistant interface
interface Persistant {
    void save(String data);
}

class FileStorage implements Persistant{
    @Override
    public void save(String data){
        try {
            FileWriter outFile=new FileWriter("doc.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved Succeesfully");
        } catch (Exception e) {
            System.out.println("Error! unable to save ");
        }
    }
}

class DBStorage implements Persistant{
    @Override
    public void save(String data){
        System.out.println("Data is saved Successfully in database");
    }
}

//DocumentEditor class managing client interaction
class DocumentEditor {
    private Document document;
    private Persistant storage;
    private String renderDocument = "";

    public DocumentEditor(Document document,Persistant storage){
        this.document=document;
        this.storage=storage;
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath){
        document.addElement(new ImageElement(imagePath));
    }

    public void addNewLine(){
        document.addElement(new NewLine());
    }
    public void addnewTabSpace(){
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument(){
        if(renderDocument.isEmpty()){
            renderDocument = document.render();
        }
        return renderDocument;
    }

    public void saveDocument(){
        storage.save(renderDocument());
    }
}




public class DocumentEditorClientGood {
    public static void main(String[] args) {
        Document document=new Document();
        Persistant persistant=new DBStorage();

        DocumentEditor editor=new DocumentEditor(document, persistant);

        editor.addText("Hello everyone ");
        editor.addNewLine();
        editor.addImage("cow.png");
        editor.addNewLine();
         editor.addText("thank You");
        editor.addnewTabSpace();
        editor.addImage("picture.jpg");

        System.out.println(editor.renderDocument());
        editor.saveDocument();
    }
}
