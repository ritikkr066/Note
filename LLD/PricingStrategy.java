interface PricingStrategy {
    double calculateFee(long entryTime,long exitTime);
}

class HourlyPricing implements PricingStrategy{
    private final double baseCharge=20;
    private final double perHourCharge=10;

    public double calculateFee(long entryTime,long exitTime){
        long duration=exitTime-entryTime;
        long hour=(long)Math.ceil(duration/(60.0*60.0*1000));
        return baseCharge + (hour*perHourCharge);
    }
}
