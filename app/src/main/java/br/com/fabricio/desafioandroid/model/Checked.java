
package br.com.fabricio.desafioandroid.model;

import java.io.Serializable;
import java.util.List;

public class Checked implements Serializable {

    private Object weight;
    private List<Object> prices = null;

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public List<Object> getPrices() {
        return prices;
    }

    public void setPrices(List<Object> prices) {
        this.prices = prices;
    }

}
