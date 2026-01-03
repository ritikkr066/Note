public class Client {
    public static void main(String[] args) {
        BulletType redBullet = BulletFactory.getBulletType("Red", "Metal");

        for (int i = 0; i < 100000; i++) {
            new Bullet(i, i, redBullet); // Only 1 BulletType, 100k Bullets.
        }
    }
}
