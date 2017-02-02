package pt.ezn.apps.servicereports;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Emilio on 02/02/2017.
 * ServiceReports
 */

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ExpensesViewHolder> {

    private Context mcontext;
    private ArrayList<DailyExpense> dailyExpenseList;

    //construtor do adapter
    public ExpensesAdapter(Context context, ArrayList<DailyExpense> expenseList){
        this.mcontext = context;
        this.dailyExpenseList = expenseList;

    }

    //seter para o caso de queremos atribuir valores a context e serviceActivitList sem ser pelo construtor
    public void setMcontext(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setServiceActivitList(ArrayList<DailyExpense> expensesActivitList) {
        this.dailyExpenseList = expensesActivitList;
    }


    @Override
    public ExpensesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.expense_cardview_layout, parent, false);
        ExpensesAdapter.ExpensesViewHolder expensesViewHolder = new ExpensesAdapter.ExpensesViewHolder(view);
        return expensesViewHolder;
    }

    @Override
    public void onBindViewHolder(ExpensesViewHolder holder, int position) {
        //criar um objecto expense da position do arraylist
        DailyExpense dailyExpense = dailyExpenseList.get(position);
        //colocar no cardview os valores do objecto serviceactivity
        holder.tvExpenseDate.setText(dailyExpense.getDate());
        Float tempfl = dailyExpense.getTotalExpenses();
        String total = String.valueOf(tempfl);
        holder.tvExpenseTotal.setText(total);
        holder.tvExpenseDate.setText(dailyExpense.getDate());

    }

    @Override
    public int getItemCount() {
        if (dailyExpenseList != null){
            return dailyExpenseList.size();
        }
        return 0;
    }

    public static class ExpensesViewHolder extends RecyclerView.ViewHolder {
        public CardView expenseCardView;
        public TextView tvExpenseDate;
        public TextView tvExpenseTotal;

        public ExpensesViewHolder(View itemView) {
            super(itemView);
            expenseCardView = (CardView) itemView.findViewById(R.id.cardview_expense);
            tvExpenseDate = (TextView) itemView.findViewById(R.id.tvExpenseCVDate);
            tvExpenseTotal = (TextView) itemView.findViewById(R.id.tvExpenseCVTotal);
        }
    }


}
