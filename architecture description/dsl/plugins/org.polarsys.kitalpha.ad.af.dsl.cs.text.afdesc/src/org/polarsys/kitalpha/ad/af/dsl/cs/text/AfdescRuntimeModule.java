/*******************************************************************************
 * Copyright (c) 2014, 2021 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.af.dsl.cs.text;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.polarsys.kitalpha.ad.af.dsl.cs.naming.AfdescQualifiedNameProvider;
import org.polarsys.kitalpha.ad.af.dsl.cs.text.scoping.AfdescContainerManager;
import org.polarsys.kitalpha.ad.af.dsl.cs.text.scoping.AfdescGlobalScopeProvider;

/**
 * 
 * @author Amine Lajmi
 *
 */
public class AfdescRuntimeModule extends org.polarsys.kitalpha.ad.af.dsl.cs.text.AbstractAfdescRuntimeModule {

	@Override
	public Class<? extends org.eclipse.xtext.resource.IContainer.Manager> bindIContainer$Manager() {
		return AfdescContainerManager.class;
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return AfdescGlobalScopeProvider.class;
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return AfdescQualifiedNameProvider.class;
	}
	
}
