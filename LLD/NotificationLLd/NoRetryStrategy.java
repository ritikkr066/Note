public class NoRetryStrategy implements RetryStrategy{

    public boolean shouldRetry(int attempt){
        return false;
    }
    public long getWaitTime(int attempt){
        return 0;
    }
}