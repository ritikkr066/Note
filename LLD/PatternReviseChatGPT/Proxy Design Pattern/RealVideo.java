// Step 2: Real Subject
public class RealVideo implements Video {

    private String fileName;

    public RealVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading video: " + fileName);
    }

    public void play() {
        System.out.println("Playing video: " + fileName);
    }
}
