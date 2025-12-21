import java.io.FileWriter;
import java.util.ArrayList;

class DocumentEditor{
    private ArrayList<String>documentsEditor;
    private String renderDocuments;

    public DocumentEditor(){
        documentsEditor=new ArrayList<>();
        renderDocuments = "";
    }

    public void addText(String text){
        documentsEditor.add(text);
    }

    public void addImage(String imagePath){
        documentsEditor.add(imagePath);
    }

    public String renderDocument(){
        if(renderDocuments.isEmpty()){
            StringBuilder result=new StringBuilder();
            for(String element : documentsEditor){
                if(element.length()>4 && ((element.endsWith(".jpg")) || (element.endsWith(".png")))){
                    result.append("["+"image path is " +element+ "]\n");
                }else{
                    result.append(element+"\n");
                }
            }
            renderDocuments=result.toString();
        }
        return  renderDocuments;
    }

    public void saveToFile(){
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved successfully");
        } catch (Exception e) {
            System.out.println("Error :  unable to save file");
        }
    }
}

public class DocumentEditorClient{
    public static void main(String[] args){
        DocumentEditor editor=new DocumentEditor();
        editor.addText("Ritik kumar is ...");
        editor.addImage("ritik.png");
        editor.addText("thank you");
        editor.addText("nice experiance");
        editor.addImage("b.png");

        editor.saveToFile();

        System.out.println(editor.renderDocument());
    }
}