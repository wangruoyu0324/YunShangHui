/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.cloudbusinessdiscount.configparams;

import com.cloudbusinessdiscount.IApp;

public class AppConfigManager {

	public static AppConfigPB getInitedAppConfig() {
		if (IApp.appConfigPB == null) {
			AppConfigPB appConfigPB = new AppConfigPB();
			appConfigPB.init(IApp.mContext);
			IApp.appConfigPB = appConfigPB;
		}
		return IApp.appConfigPB;
	}
}
