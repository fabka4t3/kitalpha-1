/*******************************************************************************
 * Copyright (c) 2014, 2018 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.helper.conf;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.Configuration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.ConfigurationElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.ExtensionGeneratrionConfiguration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.Generation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.configuration.DiagramGenerationConfiguration;

/**
 * @author Boubekeur Zendagui
 */

public class DiagramGenerationConfigurationHelper {
	
	public static boolean generateVSM(EObject anyModelElement){
		Configuration vpConf = VpDslConfigurationHelper.getViewpointConfiguration(anyModelElement);
		EList<ConfigurationElement> vpConfigurationElements = vpConf.getVpConfigurationElements();
		if (vpConfigurationElements != null && !vpConfigurationElements.isEmpty())
		{
			for (ConfigurationElement configurationElement : vpConfigurationElements) 
			{
				if (configurationElement instanceof Generation)
				{
					EList<ExtensionGeneratrionConfiguration> ownedExtGenConf = ((Generation) configurationElement).getOwnedExtensionGenConf();
					if (ownedExtGenConf != null && !ownedExtGenConf.isEmpty())
					{
						for (ExtensionGeneratrionConfiguration extGenConf : ownedExtGenConf) 
						{
							if (extGenConf instanceof DiagramGenerationConfiguration)
							{
								return ((DiagramGenerationConfiguration) extGenConf).isOverwriteVSM();
							}
						}
					}
				}
			}
		}
		return true;
	}

}
