
package br.com.fabricio.desafioandroid.model;


import java.io.Serializable;
import java.math.BigDecimal;

public class Pricing implements Serializable {

    private Ota ota;
    private String airlineName;
    private Boolean isInternational;
    private String bestPriceAt;
    private String mmBestPriceAt;
    private BigDecimal savingPercentage;

    public Ota getOta() {
        return ota;
    }

    public void setOta(Ota ota) {
        this.ota = ota;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(Boolean isInternational) {
        this.isInternational = isInternational;
    }

    public String getBestPriceAt() {
        return bestPriceAt;
    }

    public void setBestPriceAt(String bestPriceAt) {
        this.bestPriceAt = bestPriceAt;
    }

    public String getMmBestPriceAt() {
        return mmBestPriceAt;
    }

    public void setMmBestPriceAt(String mmBestPriceAt) {
        this.mmBestPriceAt = mmBestPriceAt;
    }

    public BigDecimal getSavingPercentage() {
        return savingPercentage;
    }

    public void setSavingPercentage(BigDecimal savingPercentage) {
        this.savingPercentage = savingPercentage;
    }

}
