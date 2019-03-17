
package br.com.fabricio.desafioandroid.model;

import java.io.Serializable;
import java.util.List;

public class Adult implements Serializable {

    private Integer quantity;
    private Double fare;
    private List<Fee> fees = null;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

}
