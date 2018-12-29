package registration.testing.firebase.com.retrofitmvp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Activity.MainActivity;
import registration.testing.firebase.com.retrofitmvp.Model.CountryRes;
import registration.testing.firebase.com.retrofitmvp.R;
import registration.testing.firebase.com.retrofitmvp.database.AppDataBase;
import registration.testing.firebase.com.retrofitmvp.utilities.DataGenerator;
import registration.testing.firebase.com.retrofitmvp.utilities.Logger;

/**
 * Created by Ashish on 28-09-2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
    private Context context;
    private List<CountryRes.Datum> list = new ArrayList<>();
    private List<CountryRes> list_edit = new ArrayList<>();
    private RecyclerItemClickListener onRecyclerItemClickListener;
    int[] price;


    public CountryAdapter(Context context, List<CountryRes.Datum> list) {
        this.context = context;
        this.list = list;
        this.price = price;


    }

    @Override
    public CountryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView;
        layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(CountryAdapter.MyViewHolder holder, int position) {
        holder.tvCountryName.setText(list.get(position).name);
        holder.etPriceValue.setText(list.get(position).pantoneValue);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryName;
        EditText etPriceValue;
        LinearLayout llListItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvCountryName = (TextView) itemView.findViewById(R.id.tv_country_name);
            llListItem = (LinearLayout) itemView.findViewById(R.id.llListItem);
            etPriceValue= (EditText) itemView.findViewById(R.id.PriceValue);

        }
    }


}
