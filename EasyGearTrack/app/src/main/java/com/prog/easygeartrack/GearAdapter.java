package com.prog.easygeartrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GearAdapter extends RecyclerView.Adapter<GearAdapter.GearViewHolder> {

    private List<GearItem> gearItemList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class GearViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewCategory;
        public TextView textViewCondition;
        public TextView textViewDelete;

        public GearViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewGearName);
            textViewCategory = itemView.findViewById(R.id.textViewGearCategory);
            textViewCondition = itemView.findViewById(R.id.textViewGearCondition);
            textViewDelete = itemView.findViewById(R.id.buttonDelete);

            textViewDelete.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(position);
                    }
                }
            });
        }
    }

    public GearAdapter(List<GearItem> gearList) {
        gearItemList = gearList;
    }

    @NonNull
    @Override
    public GearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gear_item_layout, parent, false);
        GearViewHolder evh = new GearViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull GearViewHolder holder, int position) {
        GearItem currentItem = gearItemList.get(position);

        holder.textViewName.setText(currentItem.getName());
        holder.textViewCategory.setText(currentItem.getCategory());
        holder.textViewCondition.setText(currentItem.getCondition());
    }

    @Override
    public int getItemCount() {
        return gearItemList.size();
    }

    // 添加更新数据集的方法
    public void updateGearList(List<GearItem> newList) {
        gearItemList.clear();
        gearItemList.addAll(newList);
        notifyDataSetChanged();
    }
}
