public class Client {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User u1 = new User("Ritik", chatRoom);
        User u2 = new User("Amit", chatRoom);
        User u3 = new User("Sohan", chatRoom);

        chatRoom.addUser(u1);
        chatRoom.addUser(u2);
        chatRoom.addUser(u3);

        u1.send("Hello!");

    }
}
