package com.tbm.budget.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BudgetRepository {

    private static BudgetRepository bInstance;
    private BudgetDatabase database;
    private LiveData<List<SpendingItem>> itemList;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static BudgetRepository getInstance(Context context){
        if (bInstance == null) {
            bInstance = new BudgetRepository(context);
        }
        return bInstance;
    }

    private BudgetRepository(Context context){
        database = BudgetDatabase.getInstace(context);
        itemList = getAllItems();
    }

    /**
     * The method does not use executor because live data happens in the background
     * @return
     */
    public LiveData<List<SpendingItem>> getAllItems() {
        return  database.spendingDAO().getSpendingLIst();
    }

    public void insertItem (final SpendingItem spendingItem){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.spendingDAO().insert(spendingItem);
            }
        });
    }

    public void deleteItem (final SpendingItem item){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.spendingDAO().delete(item);
            }
        });
    }

    public void deleteAll (){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.spendingDAO().deleteAll();
            }
        });
    }

}
