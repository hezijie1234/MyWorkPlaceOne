package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyClass {
    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         *创建一个模板对象。也可以理解为整个数据库操作的纲要
         * 参数1：自动生成的类的前缀
         * 参数2：数据库的版本号
         * 参数3：自动生成的类的包名
         */
        Schema schema = new Schema("android", 1, "android.hezijie.com.greendap");
        //创建表和Java Bean对象
        Entity userEntity = schema.addEntity("User");
        //添加属性
        userEntity.addIdProperty().primaryKey().autoincrement();
        userEntity.addStringProperty("user_name");
        userEntity.addIntProperty("user_age");

        //执行自动生成对象的User类
        try {
            /**
             * 参数1：Schema对象
             * 参数2：自动生成的Java类的具体位置
             */
            new DaoGenerator().generateAll(schema,"../MyWorkPlaceOne/day40greendao_base/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
