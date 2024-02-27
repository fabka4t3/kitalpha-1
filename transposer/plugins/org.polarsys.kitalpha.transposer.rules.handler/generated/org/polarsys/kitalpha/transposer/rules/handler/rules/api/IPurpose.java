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


package org.polarsys.kitalpha.transposer.rules.handler.rules.api;

import org.eclipse.core.runtime.IStatus;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPurpose</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPurpose#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.ApiPackage#getIPurpose()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IPurpose extends EObject {





	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.

	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.ApiPackage#getIPurpose_Name()
	 * @model
	 * @generated
	 */

	String getName();




	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPurpose#getName <em>Name</em>}' attribute.

	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */

	void setName(String value);






	/**

	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.polarsys.kitalpha.transposer.rules.handler.rules.api.IStatus"
	 * @generated
	 */

	IStatus validate();




} // IPurpose
