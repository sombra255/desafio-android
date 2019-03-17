
package br.com.fabricio.desafioandroid.model;


import java.io.Serializable;

public class Ota implements Serializable {

    private Adult adult;
    private Luggage luggage;
    private Checkout checkout;
    private String familyCode;
    private Double fareTotal;
    private Double saleTotal;

    public Ota(Double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Adult getAdult() {
        return adult;
    }

    public void setAdult(Adult adult) {
        this.adult = adult;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public Double getFareTotal() {
        return fareTotal;
    }

    public void setFareTotal(Double fareTotal) {
        this.fareTotal = fareTotal;
    }

    public Double getSaleTotal() {
        if(saleTotal == null){
            return Double.valueOf("0");
        }
        return saleTotal;
    }

    public void setSaleTotal(Double saleTotal) {
        this.saleTotal = saleTotal;
    }

}
