package com.lb.collection;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
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
        tv.append("appVersion=");
        tv.append(getAppVersionName());
        tv.append("\n");
        tv.append("appMetaData=");
        tv.append(getAppMetaData(this, "MyMetaDataName"));
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

    public String getAppMetaData(Context context, String keyName) {
        String metaData = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            metaData = applicationInfo.metaData.getString(keyName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return metaData == null ? "" : metaData;
    }
}
