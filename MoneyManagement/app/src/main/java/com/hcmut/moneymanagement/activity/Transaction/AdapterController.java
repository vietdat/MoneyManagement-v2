package com.hcmut.moneymanagement.activity.Transaction;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.hcmut.moneymanagement.models.ExpenseCategoryModel;
import com.hcmut.moneymanagement.models.IncomeCategoryModel;
import com.hcmut.moneymanagement.models.WalletModel;
import com.hcmut.moneymanagement.objects.Category;

public class AdapterController {

    private Context context;

    private WalletModel walletModel;
    private IncomeCategoryModel incomeCategoryModel;
    private ExpenseCategoryModel expenseCategoryModel;

    private ArrayAdapter<String> transactionTypeAdapter;
    private ArrayAdapter<String> walletAdapter;
    private ArrayAdapter<String> incomeAdapter;
    private ArrayAdapter<String> expenseAdapter;

    public AdapterController(Context context) {
        this.context = context;

        // Transaction Type Adapter
        String[] transactionTypes = {"Income", "Expense", "Saving", "Transfer"};
        transactionTypeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, transactionTypes);
        transactionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Wallet Adapter
        walletModel = new WalletModel();
        walletModel.initNameAdapter(context);
        walletAdapter = walletModel.getNameAdapter();

        // Income Category Adapter
        incomeCategoryModel = new IncomeCategoryModel();
        incomeCategoryModel.initSpinnerAdapter(context);
        incomeAdapter = incomeCategoryModel.getNameAdapter();

        // Expense Category Adapter
        expenseCategoryModel = new ExpenseCategoryModel();
        expenseCategoryModel.initSpinnerAdapter(context);
        expenseAdapter = expenseCategoryModel.getNameAdapter();

    }

    public ArrayAdapter getTransactionTypesAdapter() {
        return transactionTypeAdapter;
    }

    public ArrayAdapter getWalletAdapter(){
        return  walletAdapter;
    }

    public ArrayAdapter getIncomeCategoryAdapter(){
        return incomeAdapter;
    }

    public ArrayAdapter getExpenseCategoryAdapter(){
        return expenseAdapter;
    }

    public void addIncomeCategory(String input){
        Category category = new Category(input);
        incomeCategoryModel.add(category);
    }

    public void addExpenseCategory(String input){
        Category category = new Category(input);
        expenseCategoryModel.add(category);
    }

}
