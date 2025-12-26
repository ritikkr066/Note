public class Client {
    public static void main(String[] args) {

        File file1 = new File("resume.pdf");
        File file2 = new File("photo.png");

        Folder documents = new Folder("Documents");
        documents.add(file1);
        documents.add(file2);

        Folder root = new Folder("Root");
        root.add(documents);

        root.showDetails();
    }
}
