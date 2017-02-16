package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

/**
 * Created by Administrator on 2017/2/15 0015.
 */

public class CartClass {

    public static void main(String[] args) {
        Schema schema = new Schema("Cart",1,"android.hezijie.com.cart");
        Entity product = schema.addEntity("Product");
        product.addIdProperty().primaryKey().autoincrement();
        product.addStringProperty("productName");
        product.addLongProperty("productNum");
        product.addIntProperty("productPrice");
        try {
            new DaoGenerator().generateAll(schema,"../MyWorkPlaceOne/day40shoppingcart/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
