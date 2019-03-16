package com.tbm.budget.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {SpendingItem.class} , version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class BudgetDatabase extends RoomDatabase {


    public static final String DATABASE_NAME = "budget.db";
    private static  volatile BudgetDatabase instance;
    public static final Object LOCK = new Object();

    public abstract SpendingDAO spendingDAO();

    public static BudgetDatabase getInstace(Context context){
        if (instance == null) {
            synchronized (LOCK){
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            BudgetDatabase.class, DATABASE_NAME).build();
                }
            }

        }
        return instance;
    }
}
