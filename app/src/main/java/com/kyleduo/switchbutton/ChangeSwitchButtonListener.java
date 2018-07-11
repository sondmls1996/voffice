/**
 * Copyright 2015 Viettel Telecome. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.kyleduo.switchbutton;

import com.leaking.slideswitch.SlideSwitch;

public interface ChangeSwitchButtonListener {
	void onChanged(SlideSwitch switchButton, String action);
}
