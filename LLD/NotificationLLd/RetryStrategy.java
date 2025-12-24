public interface RetryStrategy {
    boolean shouldRetry(int attempt);
    long getWaitTime(int attempt);
}
