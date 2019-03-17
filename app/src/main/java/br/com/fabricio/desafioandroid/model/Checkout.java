
package br.com.fabricio.desafioandroid.model;


import java.io.Serializable;

public class Checkout implements Serializable {

    private String type;
    private String target;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
