/*******************************************************************************
 * Copyright (c) 2018, 2021 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

package org.polarsys.kitalpha.massactions.tests.ju.test.helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.BeforeClass;
import org.junit.Test;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.column.primitive.DateColumn;
import org.polarsys.kitalpha.massactions.core.column.primitive.EnumColumn;
import org.polarsys.kitalpha.massactions.core.column.primitive.MAPrimitiveColumn;
import org.polarsys.kitalpha.massactions.core.extensionpoint.columnprovider.IMAColumnProvider;
import org.polarsys.kitalpha.massactions.core.extensions.columnprovider.AbstractMAColumnProvider;
import org.polarsys.kitalpha.massactions.core.helper.ColumnProviderHelper;
import org.polarsys.kitalpha.massactions.core.helper.CommonFeaturesHelper;
import org.polarsys.kitalpha.massactions.core.helper.container.PossibleFeature;
import org.polarsys.kitalpha.massactions.tests.ju.model.factory.RandomEntityFactory;
import org.polarsys.kitalpha.massactions.visualize.helpers.UnfoldRowObjectHelper;
import org.polarsys.kitalpha.massactions.visualize.helpers.container.UnfoldedRowObject;

import TestModel.Man;
import TestModel.Person;
import TestModel.Woman;

/**
 * A class that tests the {@link UnfoldRowObjectHelper} utility class.
 * 
 * @author Sandu Postaru
 *
 */
public class UnfoldRowObjectTests {

    private static final int MAN_NB_OF_CHILDREN = 4;

    private static final int MAN_NB_OF_FRIENDS = 12;

    private static final int WOMAN_NB_OF_CHILDREN = 3;

    private static final int WOMAN_NB_OF_FRIENDS = 15;

    private static List<IMAColumn> columns;

    private static List<EObject> data;

    /**
     * Initializes all of the common data for all of the tests. This includes the test data and the tested columns.
     */
    @BeforeClass
    public static void initializeColumnProvider() {
        IMAColumnProvider columnProvider = new UnfoldColumnProvider();

        // create a first entity with two collection columns
        Man man = RandomEntityFactory.getInstance().createRandomMan();
        List<Person> manChildren = IntStream.range(0, MAN_NB_OF_CHILDREN).mapToObj(i -> RandomEntityFactory.getInstance().createRandomMan()).collect(Collectors.toList());
        RandomEntityFactory.getInstance().addAllChildren(man, manChildren);

        List<Person> manFriends = IntStream.range(0, MAN_NB_OF_FRIENDS).mapToObj(i -> RandomEntityFactory.getInstance().createRandomWoman()).collect(Collectors.toList());
        RandomEntityFactory.getInstance().addAllFriends(man, manFriends);

        // create a second entity with two collection columns
        Woman woman = RandomEntityFactory.getInstance().createRandomWoman();
        List<Person> womanChildren = IntStream.range(0, WOMAN_NB_OF_CHILDREN).mapToObj(i -> RandomEntityFactory.getInstance().createRandomMan()).collect(Collectors.toList());
        RandomEntityFactory.getInstance().addAllChildren(woman, womanChildren);

        List<Person> womanFriends = IntStream.range(0, WOMAN_NB_OF_FRIENDS).mapToObj(i -> RandomEntityFactory.getInstance().createRandomWoman()).collect(Collectors.toList());
        RandomEntityFactory.getInstance().addAllFriends(woman, womanFriends);

        data = Arrays.asList(man, woman);
        Collection<PossibleFeature> commonPossibleFeatures = CommonFeaturesHelper.getCommonPossibleFeatures(data);
        columns = new ArrayList<>(columnProvider.getColumnValues(commonPossibleFeatures, data));

        // initialize the data
        for (int i = 0; i < columns.size(); i++) {
            IMAColumn column = columns.get(i);
            column.setIndex(i);
            column.dataChanged(data);
        }
    }

    /**
     * Tests the extracted indexes. Ensures that for each column containing a collection we extract as many indexes as
     * elements in the collection.
     */
    @Test
    public void rowObjectColumnIndexesAllVisible() {

        for (EObject element : data) {
            List<Set<Integer>> rowObjectColumnIndexes = UnfoldRowObjectHelper.extractRowObjectColumnIndexes(element, columns, Collections.emptySet());

            for (IMAColumn column : columns) {
                int columnNumber = column.getIndex();
                Set<Integer> columnIndexes = rowObjectColumnIndexes.get(columnNumber);

                Object columnData = column.getDataValue(element);

                if (columnData instanceof Collection<?>) {
                    Collection<?> columnDataCollection = (Collection<?>) columnData;

                    assertEquals(columnDataCollection.size(), columnIndexes.size());
                } else {
                    assertEquals(1, columnIndexes.size());
                }
            }
        }
    }

    /**
     * Tests the extracted indexes. Ensures that for each hidden column we extract one single index.
     */
    @Test
    public void rowObjectColumnIndexesAllHidden() {

        Set<Integer> hiddenColumns = IntStream.range(0, columns.size()).boxed().collect(Collectors.toSet());

        for (EObject element : data) {
            List<Set<Integer>> rowObjectColumnIndexes = UnfoldRowObjectHelper.extractRowObjectColumnIndexes(element, columns, hiddenColumns);

            for (IMAColumn column : columns) {
                int columnNumber = column.getIndex();
                Set<Integer> columnIndexes = rowObjectColumnIndexes.get(columnNumber);

                assertEquals(1, columnIndexes.size());
            }
        }
    }

    /**
     * Test that all unfolded row objects contain one single element, contained in the original column data
     */
    @Test
    public void rowObjectUnfoldedObjects() {

        Set<Integer> hiddenColumns = Collections.emptySet();

        for (EObject element : data) {
            List<Set<Integer>> rowObjectColumnIndexes = UnfoldRowObjectHelper.extractRowObjectColumnIndexes(element, columns, hiddenColumns);

            int expectedNbOfUnfoldedObjects = rowObjectColumnIndexes.stream().map(Set::size).reduce(1, (size1, size2) -> size1 * size2);
            Set<EObject> unfoldedObjects = UnfoldRowObjectHelper.createUnfoldedObjects(element, columns, hiddenColumns);

            // test the number of objects according to the Cartesian product
            assertEquals(expectedNbOfUnfoldedObjects, unfoldedObjects.size());

            for (IMAColumn column : columns) {
                int columnIndex = column.getIndex();

                for (EObject object : unfoldedObjects) {
                    // test that we only obtained unfolded objects
                    assertTrue(object instanceof UnfoldedRowObject);
                    UnfoldedRowObject unfoldedRowObject = (UnfoldedRowObject) object;

                    Object foldedColumnData = column.getDataValue(unfoldedRowObject.getSource());
                    Object unfoldedColumnData = unfoldedRowObject.getDataValue(columnIndex);

                    // test that if the original column data was a collection,
                    // then the unfolded object contains an element in that
                    // collection
                    if (foldedColumnData instanceof Collection<?>) {
                        Collection<?> foldedColumnDataCollection = (Collection<?>) foldedColumnData;
                        assertTrue(foldedColumnDataCollection.contains(unfoldedColumnData));
                    } else {
                        assertEquals(foldedColumnData, unfoldedColumnData);
                    }
                }
            }
        }
    }

    /**
     * A dummy column provider used for testing purposes.
     */
    public static class UnfoldColumnProvider extends AbstractMAColumnProvider {

        @Override
        public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> commonPossibleFeatures, Collection<EObject> data) {

            List<IMAColumn> columns = new ArrayList<>();

            for (PossibleFeature possibleFeature : commonPossibleFeatures) {

                EStructuralFeature feature = possibleFeature.getFeature();
                MAPrimitiveColumn column = null;

                if (ColumnProviderHelper.isDateType(feature)) {
                    column = new DateColumn();
                } else if (ColumnProviderHelper.isEnumType(feature)) {
                    column = new EnumColumn();
                } else {
                    column = new MAPrimitiveColumn();
                }

                column.setPossibleFeature(possibleFeature);
                columns.add(column);
            }

            return columns;
        }
    }

}
