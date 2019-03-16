package com.tbm.budget.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.tbm.budget.database.BudgetRepository;
import com.tbm.budget.database.SpendingItem;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<SpendingItem>> spendList;
    private BudgetRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = BudgetRepository.getInstance(application.getApplicationContext());
        spendList = repository.getAllItems();
    }

    public void insert(SpendingItem item){
        repository.insertItem(item);
    }

    public void deleteItem (SpendingItem item){
        repository.deleteItem(item);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
