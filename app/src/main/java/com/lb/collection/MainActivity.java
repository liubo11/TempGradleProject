package com.lb.collection;

import android.app.Activity;
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
        tv.setText("xxxxxxxxxxxxxxxxxxxxxxxxxx");
        setContentView(tv);
    }
}
