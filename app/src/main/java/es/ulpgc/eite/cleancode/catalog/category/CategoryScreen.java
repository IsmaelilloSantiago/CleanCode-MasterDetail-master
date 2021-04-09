package es.ulpgc.eite.cleancode.catalog.category;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;

public class CategoryScreen {

    public static void configure(CategoryContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);



        CatalogMediator mediator = CatalogMediator.getInstance();



        CategoryContract.Presenter presenter = new CategoryPresenter(mediator);
        CategoryContract.Model model = new CategoryModel();
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}