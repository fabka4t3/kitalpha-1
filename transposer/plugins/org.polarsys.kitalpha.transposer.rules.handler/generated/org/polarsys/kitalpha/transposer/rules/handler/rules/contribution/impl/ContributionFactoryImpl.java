/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/


package org.polarsys.kitalpha.transposer.rules.handler.rules.contribution.impl;


import org.polarsys.kitalpha.transposer.rules.handler.rules.contribution.*;

import org.polarsys.kitalpha.transposer.rules.handler.rules.contribution.spec.ContributedPurposeSpec;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContributionFactoryImpl extends EFactoryImpl implements ContributionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContributionFactory init() {
		try {
			ContributionFactory theContributionFactory = (ContributionFactory)EPackage.Registry.INSTANCE.getEFactory(ContributionPackage.eNS_URI);
			if (theContributionFactory != null) {
				return theContributionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ContributionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContributionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ContributionPackage.CONTRIBUTED_PURPOSE: return createContributedPurpose();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ContributedPurpose createContributedPurpose() {
		ContributedPurposeImpl contributedPurpose = new ContributedPurposeSpec();
		return contributedPurpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContributionPackage getContributionPackage() {
		return (ContributionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ContributionPackage getPackage() {
		return ContributionPackage.eINSTANCE;
	}

} //ContributionFactoryImpl
