public class FixedRetryStrategy implements RetryStrategy {
    private final int maxAttempts;
    private final long delayMs;

    public FixedRetryStrategy(int maxAttempts,long delayMs){
        this.maxAttempts=maxAttempts;
        this.delayMs=delayMs;
    }

    public boolean shouldRetry(int attempt){
        return attempt < maxAttempts;
    }

    public long getWaitTime(int attempt){
        return delayMs;
    }
}
