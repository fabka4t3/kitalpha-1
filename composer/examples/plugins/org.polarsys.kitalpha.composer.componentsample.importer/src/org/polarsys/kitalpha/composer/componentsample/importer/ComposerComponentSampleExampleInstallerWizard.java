/*******************************************************************************
 * Copyright (c) 2015, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.composer.componentsample.importer;

import org.eclipse.egf.common.ui.wizard.AllZipsBundleExampleWizard;

/**
 * @author THomas Guiu
 *
 */
public class ComposerComponentSampleExampleInstallerWizard extends AllZipsBundleExampleWizard {

	@Override
	protected String getBundleId() {
		return "org.polarsys.kitalpha.composer.componentsample.importer"; //$NON-NLS-1$
	}

}
