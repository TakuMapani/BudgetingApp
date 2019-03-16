package com.tbm.budget.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SpendingDAO {

    /**
     *The DAO needs to:
     * 1 get all items
     * 2 delete all items
     * 3 Delete certain item
     * 4 Insert item(s)
     * 5 retrive item by ID??
     */

    @Insert
    void insert(SpendingItem spendingItem);

    @Query("DELETE FROM spending_table")
    void deleteAll();

    @Delete
    void delete(SpendingItem item);

    @Query("SELECT * from spending_table")
    LiveData<List<SpendingItem>> getSpendingLIst();

    @Query("SELECT * FROM SPENDING_TABLE WHERE typeSpending = :type")
    LiveData<List<SpendingItem>> getSpendingByType(String type);


}
