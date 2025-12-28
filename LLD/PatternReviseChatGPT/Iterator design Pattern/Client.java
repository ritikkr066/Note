public class Client {
    public static void main(String[] args) {
        NameCollection collection = new NameCollection();
        Iterator<String> iterator = collection.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
