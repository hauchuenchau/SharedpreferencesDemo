
package com.cnlive.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

public class SharedPreferencesHelper {

    public static SharedPreferencesHelper instance;
    protected Context mContext;
    protected SharedPreferences sharedPreferences;


    private SharedPreferencesHelper(Context context) {
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(context.getPackageName(), 0);
    }

    /**
     * 线程安全调用
     *
     * @param context
     * @return
     */
    public static synchronized SharedPreferencesHelper getInstance(Context context) {
        if (null == context) return null;
        if (null == instance)
            instance = new SharedPreferencesHelper(context.getApplicationContext());
        return instance;
    }

    /**
     * 获取保存数据的方法，我们根据默认值的到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        return sharedPreferences.getString(key, "");
    }

    public Boolean getBoolValue(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public Boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public Long getLong(String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public int getIntValue(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public int getIntValue(String key, int deft) {
        return sharedPreferences.getInt(key, deft);
    }


    /**
     * 保存数据的方法，拿到数据保存数据的基本类型，然后根据类型调用不同的保存方法
     *
     * @param key
     * @param value
     */
    public void setValue(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void setValue(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void setValue(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void setValue(String key, long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key
     */
    public void remove(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 清除所有的数据
     */
    public void clear() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public Set<String> getSaveKeys() {
        return sharedPreferences.getAll().keySet();
    }

    /**
     * 返回所有的键值对
     *
     * @return
     */
    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }

    /**
     * 查询某个key是否存在
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }
}
