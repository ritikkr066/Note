class NotificationService {
    private NotificationStrategy strategy;

    public NotificationService(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void notifyUser(String msg) {
        strategy.send(msg);
    }
}
