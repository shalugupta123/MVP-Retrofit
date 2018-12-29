package registration.testing.firebase.com.retrofitmvp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Adapter.CountryAdapter;
import registration.testing.firebase.com.retrofitmvp.Core.GetDataContract;
import registration.testing.firebase.com.retrofitmvp.Core.Presenter;
import registration.testing.firebase.com.retrofitmvp.Model.CountryRes;
import registration.testing.firebase.com.retrofitmvp.R;
import registration.testing.firebase.com.retrofitmvp.database.AppDataBase;
import registration.testing.firebase.com.retrofitmvp.utilities.DataGenerator;
import registration.testing.firebase.com.retrofitmvp.utilities.Logger;

public class MainActivity extends Activity implements GetDataContract.View{
    private Presenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CountryAdapter countryAdapter;
    private GetDataContract.onGetDataListener mOnGetDatalistener;


    EditText etEnterName;
    Button btAddItem,mbtnItemvalue;
    TextView mtvGetName;
    List<CountryRes> allCountriesEditValue;
    ArrayList<CountryRes.Datum> showList;
    ArrayList<String> showListget;
    List<CountryRes.Datum> resource;

    int price[]={1,2,3,4,5,6,7};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
    }

    private void getView() {
        /*presentator */
        mPresenter = new Presenter(this);
        /*initiliaze of id*/
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        etEnterName = (EditText) findViewById(R.id.etEnterName);
        btAddItem = (Button) findViewById(R.id.btAddItem);
        mbtnItemvalue= (Button) findViewById(R.id.btnItemvalue);
        mtvGetName= (TextView) findViewById(R.id.tvGetName);
        linearLayoutManager = new LinearLayoutManager(this);

        /*initiliaze the arraylist*/
        showList=new ArrayList<CountryRes.Datum>();
        showListget= new ArrayList<String>();

        recyclerView.setLayoutManager(linearLayoutManager);
        btAddItem.setOnClickListener(new AddButtonClick());
        mbtnItemvalue.setOnClickListener(new AddItmeButtonClick());
    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d("Status", message);
    }


    @Override
    public void onGetDataSuccess(String message, List<CountryRes.Datum> allCountriesData) {

        /*add the value mannulay*/

        countryAdapter = new CountryAdapter(getApplicationContext(), allCountriesData);
        recyclerView.setAdapter(countryAdapter);

        /*set the data in the room*/
        AppDataBase database = AppDataBase.getAppDatabase(this);
        DataGenerator.with(database).generateCats(allCountriesData);
        Logger.displayCatsInLog(database.catDao().loadAll());
         resource = allCountriesData;
        showList.addAll(allCountriesData);
        countryAdapter.notifyDataSetChanged();


    }

    private class AddButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            mPresenter.getDataFromURL(getApplicationContext(), "");

        }
    }


    private class AddItmeButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Log.e("All_list_item","All_list_item"+resource.size());
            for (CountryRes.Datum number : resource) {
                System.out.println("Name = " + number.name);
                System.out.println("Price value= " + number.pantoneValue);

            }
            }
    }
}
