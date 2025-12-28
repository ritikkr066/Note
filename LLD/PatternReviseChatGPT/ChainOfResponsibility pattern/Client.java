public class Client {
    public static void main(String[] args) {
        SupportHandler level1 = new LevelOneSupport();
        SupportHandler level2 = new LevelTwoSupport();
        SupportHandler level3 = new LevelThreeSupport();

        level1.setNext(level2);
        level2.setNext(level3);

        level1.handleRequest(3);
    }
}
