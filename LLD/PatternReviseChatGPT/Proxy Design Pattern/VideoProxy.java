// Step 3: Proxy
public class VideoProxy implements Video {

    private RealVideo realVideo;
    private String fileName;

    public VideoProxy(String fileName) {
        this.fileName = fileName;
    }

    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(fileName); // lazy init
        }
        realVideo.play();
    }
}
