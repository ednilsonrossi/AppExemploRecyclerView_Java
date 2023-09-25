package br.edu.ifsp.dmo.recyclerviewexemplo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterPersonalizado extends RecyclerView.Adapter<AdapterPersonalizado.ViewHolder> {

    private List<AlgoImportante> dataset;
    private DeleteItemClickListener listener;

    public AdapterPersonalizado(List<AlgoImportante> dataset, DeleteItemClickListener clickListener) {
        this.dataset = dataset;
        listener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlgoImportante algoImportante = dataset.get(position);
        holder.tituloTextView.setText("Elemento: " + algoImportante.getId());
        holder.sequenciaTextView.setText("# " + algoImportante.getId());
        holder.deleteImageView.setOnClickListener(v -> {listener.onDeleteImageClick(position);});
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tituloTextView;
        public TextView sequenciaTextView;
        public ImageView deleteImageView;

        public ViewHolder(View itemView){
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.textview_titulo);
            sequenciaTextView = itemView.findViewById(R.id.textview_sequencia);
            deleteImageView = itemView.findViewById(R.id.image_delete);
        }
    }
}
