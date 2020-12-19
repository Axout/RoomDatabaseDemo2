package ru.axout.roomdatabasedemo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.axout.roomdatabasedemo.R;

import java.util.List;

public class CountTupleAdapter extends RecyclerView.Adapter<CountTupleAdapter.ViewHolder> {
    // Инициализируем переменные
    private List<CountTuple> countTupleList;

    // Конструктор
    public CountTupleAdapter(List<CountTuple> countTupleList) {
        this.countTupleList = countTupleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountTupleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_next, parent,false);
        return new CountTupleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CountTupleAdapter.ViewHolder holder, int position) {
        // Initialize main data
        final CountTuple data = countTupleList.get(position);
        // Установка текса в text view
        holder.textViewText.setText(data.text);
        holder.textViewCount.setText(String.valueOf(data.count));
    }

    @Override
    public int getItemCount() {
        return countTupleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewText, textViewCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewText = itemView.findViewById(R.id.tv_text);
            textViewCount = itemView.findViewById(R.id.tv_count);
        }
    }
}
