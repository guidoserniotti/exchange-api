public class ExchangeRateResponse {
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private String result;

    public String getBaseCode() {
        return base_code;
    }

    public String getTargetCode() {
        return target_code;
    }

    public double getConversionRate() {
        return conversion_rate;
    }

    public String getResult() {
        return result;
    }
}