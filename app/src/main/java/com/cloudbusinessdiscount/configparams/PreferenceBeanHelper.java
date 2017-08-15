/*******************************************************************************
 * Copyright (c) 2013, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p/>
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.cloudbusinessdiscount.configparams;

import android.content.Context;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class PreferenceBeanHelper {

    private PreferencesUtils preferencesUtils;

    public void init(Context context) {
        preferencesUtils = PreferencesUtils.getPreferencesUtilsInstance(context);
    }

    /**
     * 更新某一个值到sp
     */
    public void updatePrefer(String field, Object value) throws Exception {
        Field temp = this.getClass().getDeclaredField(field);
        FieldUtils.setValueToFiled(temp, this, value.toString());
        preferencesUtils.saveOne(this, temp);
    }

    public void updatePreferAll() throws Exception {
        preferencesUtils.save(this);

    }

    /**
     * 初始化sharedpreferences
     */
    public void loadFromPref() throws Exception {
        preferencesUtils.getObjectFromSp(this.getClass(), this);
    }

    public void clearPref() throws Exception {
        preferencesUtils.clear(this);
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!Modifier.isFinal(field.getModifiers()))
                FieldUtils.setDefValueToFiled(field, this);
        }
    }


    public abstract boolean isDataInvalid();

    /**
     * 设置sharedpreferences数据无效
     */
    public abstract void setDataInvalid();

}
