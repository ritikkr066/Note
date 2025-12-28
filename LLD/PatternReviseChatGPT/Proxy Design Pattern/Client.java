public class Client {
    public static void main(String[] args) {

        Video video = new VideoProxy("movie.mp4");

        // video not loaded yet
        video.play();
        video.play();
    }
}
