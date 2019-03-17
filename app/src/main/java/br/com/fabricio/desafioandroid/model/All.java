
package br.com.fabricio.desafioandroid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class All implements Serializable {

    private List<Outbound> outbound = new ArrayList<>();
    private List<Inbound> inbound = new ArrayList<>();

    public List<Outbound> getOutbound() {
        return outbound;
    }

    public void setOutbound(List<Outbound> outbound) {
        this.outbound = outbound;
    }

    public List<Inbound> getInbound() {
        return inbound;
    }

    public void setInbound(List<Inbound> inbound) {
        this.inbound = inbound;
    }

}
