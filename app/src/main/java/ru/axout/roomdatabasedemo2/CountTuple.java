package ru.axout.roomdatabasedemo2;

import androidx.room.ColumnInfo;

public class CountTuple {
    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "count")
    public int count;
}
