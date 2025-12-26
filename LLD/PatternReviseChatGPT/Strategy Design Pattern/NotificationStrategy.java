interface NotificationStrategy {
    void send(String message);
}

class EmailStrategy implements NotificationStrategy {
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}
