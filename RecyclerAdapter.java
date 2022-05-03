package com.example.nidaapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {
    Context context;
    List<category>categoryList;

    public RecyclerAdapter(Context context, List<category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_row_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        category category =categoryList.get(position);
        holder.imageView.setImageResource(category.getCatImage());
        holder.tvName.setText(category.getCatName());
        holder.tvPrice.setText(""+category.getCatfee());
        holder.tvDescription.setText(""+category.getCatDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You selected: "+category.getCatName()+"\nFrom: "+category.getCatfee()+"\nWith: "+category.getCatDescription(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public class VH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName,tvPrice,tvDescription;

        public VH(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.myImage);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvDescription=itemView.findViewById(R.id.tvDescription);
        }
    }
}
