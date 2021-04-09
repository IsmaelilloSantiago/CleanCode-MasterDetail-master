package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();

  private final List<ProductItem> itemList = new ArrayList<>();
  private final int COUNT = 20;

  public ProductListModel() {
    // Add some sample items
    for (int index = 1; index <= COUNT; index++) {
      addProduct(createProduct(index));
    }
  }

  @Override
  public List<ProductItem> fetchProductListData() {
    Log.e(TAG, "fetchProductListData()");
    return itemList;
  }

  private void addProduct(ProductItem item) {
    itemList.add(item);
  }


  private ProductItem createProduct(int position) {
    String content = "Product " + position;

    return new ProductItem(
        position, content, fetchProductDetails(position)
    );

  }


  private String fetchProductDetails(int position) {
    String content = "Details about Product:  " + position;
    StringBuilder builder = new StringBuilder();
    builder.append(content);

    for (int index = 0; index < position; index++) {
      builder.append("\nMore details information here.");
    }

    return builder.toString();
  }

}
