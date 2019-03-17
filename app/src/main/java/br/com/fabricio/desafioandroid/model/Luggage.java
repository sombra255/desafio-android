
package br.com.fabricio.desafioandroid.model;


import java.io.Serializable;

public class Luggage implements Serializable {

    private CarryOn carryOn;
    private Checked checked;

    public CarryOn getCarryOn() {
        return carryOn;
    }

    public void setCarryOn(CarryOn carryOn) {
        this.carryOn = carryOn;
    }

    public Checked getChecked() {
        return checked;
    }

    public void setChecked(Checked checked) {
        this.checked = checked;
    }

}
