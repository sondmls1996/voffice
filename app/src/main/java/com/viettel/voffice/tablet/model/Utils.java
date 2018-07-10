package com.viettel.voffice.tablet.model;

import android.view.View;
import android.view.ViewGroup;

public class Utils {

    public static View setWidthLeft(View v){
        ViewGroup.LayoutParams params = v.getLayoutParams();
        params.width = (int)Constant.WIDTH_LEFT_TITLE/3;
        v.setLayoutParams(params);
        return v;
    }

}
