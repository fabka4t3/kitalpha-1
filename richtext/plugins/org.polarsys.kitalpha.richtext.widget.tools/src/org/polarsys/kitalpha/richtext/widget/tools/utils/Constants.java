/*******************************************************************************
 * Copyright (c) 2017, 2021 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.richtext.widget.tools.utils;

import java.net.URL;

import org.polarsys.kitalpha.richtext.common.util.MDERichTextHelper;
import org.polarsys.kitalpha.richtext.widget.tools.internal.Activator;

/**
 * 
 * @author Faycal Abka
 * @author Minh Tu Ton That
 *
 */
public class Constants {

	//Default supported Links
	public static final String URL = "http"; //$NON-NLS-1$
	public static final String URL_SECURE = URL + "s"; //$NON-NLS-1$
	public static final String FILE = "file"; //$NON-NLS-1$
	public static final String LOCAL = "local"; //$NON-NLS-1$
	public static final String MODEL_ELEMENT = "modelElement"; //$NON-NLS-1$
	public static final String DIAGRAM_ELEMENT = "modelDiagram"; //$NON-NLS-1$
	public static final String UNKNOWN = "unknonwn"; //$NON-NLS-1$

	public static final String URL_LABEL = "URL"; //$NON-NLS-1$
	public static final String FILE_LABEL = "File (absolute path) (not recommended)"; //$NON-NLS-1$
	public static final String FILE_LOCAL_LABEL = "File (project relative path) (not recommended)"; //$NON-NLS-1$
	public static final String MODEL_ELEMENT_LABEL = "Model Element"; //$NON-NLS-1$
	public static final String DIAGRAM_ELEMENT_LABEL = "Diagram Element"; //$NON-NLS-1$
	
	 //URL CONSTANTS
    public static final URL EDIT_ICON = MDERichTextHelper.getURL(Activator.PLUGIN_ID, "icons/edit.gif"); 		//$NON-NLS-1$
    public static final URL CLEAR_ICON = MDERichTextHelper.getURL(Activator.PLUGIN_ID, "icons/clear.gif"); 		//$NON-NLS-1$
    public static final URL ADD_LINK_ICON = MDERichTextHelper.getURL(Activator.PLUGIN_ID, "icons/add_link.gif"); 	//$NON-NLS-1$
    public static final URL ADD_IMAGE_ICON = MDERichTextHelper.getURL(Activator.PLUGIN_ID, "icons/add_image.gif"); 	//$NON-NLS-1$
	public static final URL SAVE_IMAGE_ICON = MDERichTextHelper.getURL(Activator.PLUGIN_ID, "icons/save_image.gif"); 	//$NON-NLS-1$
	public static final URL REFRESH_IMAGE_ICON = MDERichTextHelper.getURL(Activator.PLUGIN_ID, "icons/refresh.gif");   //$NON-NLS-1$

}
