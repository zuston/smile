/*******************************************************************************
 * Copyright (c) 2010 Haifeng Li
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package smile.math;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Haifeng Li
 */
public class SparseArrayTest {
    public SparseArrayTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of all methods, of class SparseArrayTest.
     */
    @Test
    public void testAll() {
        System.out.println("SparseArray");
        SparseArray a = new SparseArray();
        assertEquals(true, a.isEmpty());

        a.set(1, 0.5);
        a.set(2, 1.0);
        assertEquals(2, a.size());
        assertEquals(0.0, a.get(0), 1E-15);
        assertEquals(0.5, a.get(1), 1E-15);
        assertEquals(1.0, a.get(2), 1E-15);
        assertEquals(false, a.isEmpty());

        a.remove(1);
        assertEquals(1, a.size());
        assertEquals(0.0, a.get(1), 1E-15);
        assertEquals(1.0, a.get(2), 1E-15);
        assertEquals(false, a.isEmpty());


        a.remove(1);
        assertEquals(1, a.size());
        assertEquals(0.0, a.get(1), 1E-15);
        assertEquals(1.0, a.get(2), 1E-15);
        assertEquals(false, a.isEmpty());

        SparseArray.Entry e = a.stream().findFirst().get();
        assertEquals(1, a.stream().count());
        assertEquals(2, e.i);
        assertEquals(1.0, e.x, 1E-15);

        a.set(0, 4);
        e = a.stream().findFirst().get();
        assertEquals(2, a.stream().count());
        assertEquals(2, e.i);
        assertEquals(1.0, e.x, 1E-15);

        a.sort();
        e = a.stream().findFirst().get();
        assertEquals(2, a.stream().count());
        assertEquals(0, e.i);
        assertEquals(4.0, e.x, 1E-15);
    }
}