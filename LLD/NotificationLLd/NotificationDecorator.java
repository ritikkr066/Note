public abstract class NotificationDecorator implements Notification {
    protected final Notification wrappedNotification;
    
    protected NotificationDecorator (Notification  notification){
        this.wrappedNotification=notification;
    }
}
