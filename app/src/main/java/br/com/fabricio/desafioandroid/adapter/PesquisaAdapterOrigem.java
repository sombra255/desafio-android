package br.com.fabricio.desafioandroid.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.fabricio.desafioandroid.R;
import br.com.fabricio.desafioandroid.model.All;
import br.com.fabricio.desafioandroid.model.Inbound;
import br.com.fabricio.desafioandroid.model.Outbound;

import static br.com.fabricio.desafioandroid.utils.FormatarDataHora.*;

/**
 * Created by Fabricio on 12/03/2019.
 */

public class PesquisaAdapterOrigem extends RecyclerView.Adapter<PesquisaAdapterOrigem.MyViewHolder>{

    private All all = new All();

    public PesquisaAdapterOrigem(All all) {
        this.all = all;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pesquisa, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        try {
                Inbound inbound = all.getInbound().get(position);
                if(inbound.getPricing().getOta() != null) {
                    holder.txtOrigem.setText(inbound.getFrom());
                    holder.txtDestino.setText(inbound.getTo());
                    holder.txtValor.setText(inbound.getPricing().getOta().getSaleTotal().toString());
                    holder.txtHorarioSaida.setText(formatarData(inbound.getDepartureDate()));
                    holder.txtHorarioChegada.setText(formatarData(inbound.getArrivalDate()));
                    holder.txtTempo.setText(formataHora(inbound.getDuration()));
                    holder.txtQntParadas.setText(inbound.getStops().toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        holder.btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Click "+holder.txtValor.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return all.getInbound().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtOrigem;
        TextView txtDestino;
        TextView txtValor;
        TextView txtHorarioSaida;
        TextView txtHorarioChegada;
        AppCompatButton btnComprar;
        TextView txtTempo;
        TextView txtQntParadas;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtOrigem = itemView.findViewById(R.id.list_item_pesquisa_txt_origem);
            txtDestino = itemView.findViewById(R.id.list_item_pesquisa_txt_destino);
            txtValor = itemView.findViewById(R.id.list_item_pesquisa_txt_valor);
            txtHorarioSaida = itemView.findViewById(R.id.list_item_pesquisa_txt_horario_saida);
            txtHorarioChegada = itemView.findViewById(R.id.list_item_pesquisa_txt_horario_chegada);
            btnComprar = itemView.findViewById(R.id.list_item_pesquisa_btn_comprar);
            txtTempo = itemView.findViewById(R.id.list_item_pesquisa_txt_tempo);
            txtQntParadas = itemView.findViewById(R.id.list_item_pesquisa_txt_qnt_paradas);

        }
    }
}
