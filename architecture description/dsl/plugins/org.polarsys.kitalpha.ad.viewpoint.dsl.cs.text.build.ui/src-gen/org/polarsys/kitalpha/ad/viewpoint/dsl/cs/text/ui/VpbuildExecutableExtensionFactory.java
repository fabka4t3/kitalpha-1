/*******************************************************************************
 * Copyright (c) 2015, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.internal.VpbuildActivator;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class VpbuildExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return VpbuildActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return VpbuildActivator.getInstance().getInjector(VpbuildActivator.ORG_POLARSYS_KITALPHA_AD_VIEWPOINT_DSL_CS_TEXT_VPBUILD);
	}
	
}
