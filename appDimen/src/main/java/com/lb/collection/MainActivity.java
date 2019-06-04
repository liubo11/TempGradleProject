package com.lb.collection;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author LiuBo
 * @date 2019-05-29
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.append("xxxxxxxxxxxxxx"+getAppVersionName());
        tv.append("\n");
        try {
            tv.append(Class.forName("android.support.v7.widget.AppCompatButton").getName());
            tv.append("\n");
        } catch (Exception e) {
            e.printStackTrace();
            tv.append(e.toString());
            tv.append("\n");
        }
        setContentView(tv);
    }
    /**
     * 获取版本字符串
     */
    public String getAppVersionName() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName+"."+ packageInfo.getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "1.0.1";
    }
}
