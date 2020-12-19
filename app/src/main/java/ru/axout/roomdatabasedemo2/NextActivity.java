package ru.axout.roomdatabasedemo2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.axout.roomdatabasedemo.R;

import java.util.List;

/*
В MainActivity мы заполняем БД,
в NextActivity выводится кол-во уникальных строк из БД.
 */

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Initialize BD
        RoomDB database = RoomDB.getInstance(this);
        // Хранение данных БД в data list (Store database value in data list)
        List<CountTuple> countTupleList = database.mainDao().getCountTuple();

        RecyclerView recyclerView = findViewById(R.id.recycler_view_next);
        // Инициализация менеджера линейного макета (Initialize linear layout manager)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // Установка менеджера макета
        recyclerView.setLayoutManager(linearLayoutManager);
        // Инициализация adapter
        CountTupleAdapter adapter = new CountTupleAdapter(countTupleList);
        // Set adapter
        recyclerView.setAdapter(adapter);
    }
}
