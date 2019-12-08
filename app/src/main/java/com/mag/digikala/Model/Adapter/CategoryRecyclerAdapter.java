package com.mag.digikala.Model.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.mag.digikala.CategoryActivity;
import com.mag.digikala.Model.Category;
import com.mag.digikala.R;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryRecyclerViewHolder> {


    private List<Category> items;
    private Activity activity;

    public CategoryRecyclerAdapter(List<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activity = (Activity) parent.getContext();
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_green_category_item, parent, false);
        return new CategoryRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {

        private MaterialButton button;

        public CategoryRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.layout_green_cat__item);

        }

        public void bind(Category category) {

            button.setText(category.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.startActivity(CategoryActivity.newIntent(activity, ""));
                }
            });

        }

    }

    public void setCategoriesItems(List<Category> items) {
        this.items = items;
    }

}
