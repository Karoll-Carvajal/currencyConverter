package operations;

import client.Api;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.Map;

public class CurrencyConverter {
    //Declaration of variables
    @SerializedName("base_code")
    private String base_code;
    @SerializedName("conversion_rates")
    private String conversion_rates;
    private String targetCurrency = "";
    private String  baseCurrency = "";
    private String address = "";

    //Methods
    public double convert(double amount, String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        Map<String, Double> exchangeRates = Api.getApi(baseCurrency);
        double conversionRate = exchangeRates.get(targetCurrency);
        return amount * conversionRate;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(String conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CurrencyConverter{" +
                "base_code='" + base_code + '\'' +
                ", conversion_rates='" + conversion_rates + '\'' +
                '}';
    }
}
