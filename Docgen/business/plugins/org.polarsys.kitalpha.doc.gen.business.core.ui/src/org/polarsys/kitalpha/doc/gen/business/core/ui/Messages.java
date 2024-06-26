/*******************************************************************************
 * Copyright (c) 2014, 2021 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.doc.gen.business.core.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.polarsys.kitalpha.doc.gen.business.core.ui.messages"; //$NON-NLS-1$
	public static String InvokeActivityHelper_Error;
	public static String InvokeActivityHelper_HTML_Documentation_Generation;
	public static String InvokeActivityHelper_DocumentationGenerationCancelled;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
