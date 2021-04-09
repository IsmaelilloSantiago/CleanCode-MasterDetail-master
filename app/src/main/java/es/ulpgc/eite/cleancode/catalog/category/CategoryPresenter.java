package es.ulpgc.eite.cleancode.catalog.category;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class CategoryPresenter implements CategoryContract.Presenter {

    public static String TAG = CategoryPresenter.class.getSimpleName();

    private WeakReference<CategoryContract.View> view;
    private CategoryState state;
    private CategoryContract.Model model;
    private CatalogMediator mediator;

    public CategoryPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoryState();
    }



    @Override
    public void fetchCategoryData() {
        // Log.e(TAG, "fetchProductListData()");

        // call the model


        state.category = model.fetchProductListData();
        view.get().onDataUpdated(state);



    }

    @Override
    public void selectProductListData(ProductItem item) {
        passDataToNextScreen(item);
        view.get().navigateToNextScreen();
    }

    private void passDataToNextScreen(ProductItem item) {
        
        mediator.setProduct(item);
    }




    @Override
    public void injectView(WeakReference<CategoryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoryContract.Model model) {
        this.model = model;
    }

}