package es.ulpgc.eite.cleancode.catalog.category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;
import es.ulpgc.eite.cleancode.catalog.products.ProductListAdapter;
import es.ulpgc.eite.cleancode.catalog.products.ProductListScreen;

public class CategoryActivity
        extends AppCompatActivity implements CategoryContract.View {

    public static String TAG = CategoryActivity.class.getSimpleName();

    private CategoryContract.Presenter presenter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //getSupportActionBar().setTitle(R.string.app_name);
        Log.e(TAG,"LLEGO");

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.category_title));
        }

        listView = findViewById(R.id.product_list);

    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */

        // do the setup
        CategoryScreen.configure(this);

        // do some work
        presenter.fetchCategoryData();
    }



    @Override
    public void onDataUpdated(CategoryViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        listView.setAdapter(new ProductListAdapter(
                        this, viewModel.category, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        ProductItem item = (ProductItem) view.getTag();
                        presenter.selectProductListData(item);
                    }
                })
        );
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(CategoryContract.Presenter presenter) {
        this.presenter = presenter;
    }
}