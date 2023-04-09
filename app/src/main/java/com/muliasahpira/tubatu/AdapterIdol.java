package com.muliasahpira.tubatu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterIdol extends RecyclerView.Adapter<AdapterIdol.ViewHolderIdol>{

    private Context ctx;
    private ArrayList arrId, arrNama, arrTanggal;

    public AdapterIdol(Context ctx, ArrayList arrId, ArrayList arrNama, ArrayList arrTanggal){
        this.ctx = ctx;
        this.arrId = arrId;
        this.arrNama = arrNama;
        this.arrTanggal = arrTanggal;
    }
    @NonNull
    @Override
    public AdapterIdol.ViewHolderIdol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.list_item_idol, parent, false);
        return new ViewHolderIdol(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIdol.ViewHolderIdol holder, int position) {
        holder.tvId.setText(arrId.get(position).toString());
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvTanggal.setText(arrTanggal.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class ViewHolderIdol extends RecyclerView.ViewHolder {
        private TextView tvId, tvNama, tvTanggal;
        public ViewHolderIdol(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Intent varIntent = new Intent(ctx, Tampilctivity.class);
                    varIntent.putExtra("varId", tvId.getText().toString());
                    varIntent.putExtra("varNama", tvNama.getText().toString());
                    varIntent.putExtra("varTanggal", tvTanggal.getText().toString());
                    ctx.startActivity(varIntent);
                    return false;
                }
            });
        }
    }
}
