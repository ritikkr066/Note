// step-3 Flyweight Factory (IMPORTANT)

import java.util.HashMap;
import java.util.Map;

class BulletFactory {
    private static final Map<String, BulletType> cache = new HashMap<>();

    static BulletType getBulletType(String color, String texture) {
        String key = color + texture;
        System.out.println("BulletType of "+color+" color & "+texture+" texture ");
        return cache.computeIfAbsent(
            key, k -> new BulletType(color, texture)
        );
    }
}
