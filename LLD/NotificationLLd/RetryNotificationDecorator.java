public class RetryNotificationDecorator extends NotificationDecorator {
    private final RetryStrategy retryStrategy;

    public RetryNotificationDecorator(Notification notification,RetryStrategy retryStrategy){
        super(notification);
        this.retryStrategy=retryStrategy;
    }

    public void send(String message){
        int attempt=0;
        while (true) {
            try {
                attempt++;
                wrappedNotification.send(message);
                System.out.println("Notification sent successfully");
                break;
            } catch (Exception e) {
                if(!retryStrategy.shouldRetry(attempt)){
                    System.out.println("Retry exhausted. Giving up ");
                    throw e;
                }

                try {
                    Thread.sleep(retryStrategy.getWaitTime(attempt));
                } catch (Exception ex) {
                   Thread.currentThread().interrupt();
                   throw new RuntimeException(ex);
                }
            }
        }
    }
}
