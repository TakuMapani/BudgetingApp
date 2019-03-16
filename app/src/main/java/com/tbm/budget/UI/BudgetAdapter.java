package com.tbm.budget.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tbm.budget.R;
import com.tbm.budget.database.SpendingItem;

import java.util.List;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {

    private final List<SpendingItem> spendingList;
    private final Context context;

    public BudgetAdapter (List<SpendingItem> itemList, Context context){
        this.context = context;
        this.spendingList = itemList;
    }

    @NonNull
    @Override
    public BudgetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.spending_list_item, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetAdapter.ViewHolder holder, int position) {
        final SpendingItem item = spendingList.get(position);
        holder.spendingItemView.setText(item.getSpendingDescription());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView spendingItemView;
        private final FloatingActionButton spendingTypeFAB;

        public ViewHolder(View itemView) {
            super(itemView);
            spendingItemView = itemView.findViewById(R.id.spending_list_item);
            spendingTypeFAB = itemView.findViewById(R.id.fab);
        }
    }
}
