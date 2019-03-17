
package br.com.fabricio.desafioandroid.model;

import java.io.Serializable;
import java.util.List;

public class CarryOn implements Serializable {

    private Integer weight;
    private List<Integer> prices = null;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }

}
