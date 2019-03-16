package com.tbm.budget.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "spending_table")

public class SpendingItem {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    private Integer spendingID;

    private String typeSpending;

    public String getSpendingDescription() {
        return spendingDescription;
    }

    public void setSpendingDescription(String spendingDescription) {
        this.spendingDescription = spendingDescription;
    }

    private String spendingDescription;
    private double amount;

    /**
     * The date class needs a converter class as SQL does not support date
     */
    private Date date;


    public void setSpendingID(@NonNull Integer spendingID) {
        this.spendingID = spendingID;
    }

    @NonNull
    public Integer getSpendingID() {
        return spendingID;
    }

    public String getTypeSpending() {
        return typeSpending;
    }

    public void setTypeSpending(String typeSpending) {
        this.typeSpending = typeSpending;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate() {
        this.date = date;
    }


    public SpendingItem(@NonNull Integer spendingID, String typeSpending, String spendingDescription, double amount, Date date) {
        this.spendingID = spendingID;
        this.typeSpending = typeSpending;
        this.spendingDescription = spendingDescription;
        this.amount = amount;
        this.date = date;
    }

    @Ignore
    public SpendingItem(String typeSpending, String spendingDescription, double amount, Date date) {
        this.typeSpending = typeSpending;
        this.spendingDescription = spendingDescription;
        this.amount = amount;
        this.date = date;
    }
}
