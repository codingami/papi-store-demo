// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the Assert Class from the org.junit package or folder
import org.junit.Assert;
//This is importing the Before Class from the org.junit package or folder
import org.junit.Before;
//This is importing the Test Class from the org.junit package or folder
import org.junit.Test;

// This is a public class called PapiStoreTest
    public class PapiStoreTest {

        //This calls the object PapiStore and creates a variable called papiStore.
        PapiStore papiStore;

        //setting up a structure to make sure each gets the exact same clean data. This way you don't have to call each
        //method repeatedly in the tests. This and the @Test annotation are also called fixtures.
        @Before
        public void setup(){
            papiStore = new PapiStore();
            //creating an active tab for Jamal.
            papiStore.createActiveTab("Jamal");
            //creating an active tab for Victor.
            papiStore.createActiveTab("Victor");
            //Jamal currently doesn't owe any money but we opened a tab for him because we trust him :)
            papiStore.owesPapiMoney.put("Jamal", 0.0);
            //Victor owes $7.0.
            papiStore.owesPapiMoney.put("Victor", 7.0);
        }

        //This is an annotation for unit testing.
        @Test
        //This test is public but doesn't return anything and is called OpenStoreTest to test if the openStore method works.
        public void OpenStoreTest(){
            //Given
            //reference the object PapiStore and ask if it's open by calling the method. You do need to call this method
            //because it hasn't been included in the @Before structure above.
            papiStore.openStore();

            //When
            //the expected boolean is true.
            Boolean expected = true;
            //
            Boolean actual = papiStore.isStoreOpen();

            //Then
            //Assert.assertEquals(expected, actual);
            //Use assertTrue because expected boolean always has default true. So instead test if the actual is true.
            Assert.assertTrue(actual);
        }

        @Test
        public void allowToUseTabTestSuccess(){
            // given
            //don't need to call anything here because the private helper methods used for allowToUseTab are being
            //called above in the @Before structure.


            // when
            Boolean expected = true;
            //the actual is testing whether or not the name Jamal will be true because we want Jamal to be allowed
            //to use a tab if necessary.
            Boolean actual = papiStore.allowToUseTab("Jamal");

            // then
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void allowToUseTabTestFail(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            Boolean expected = false;
            //the actual is testing whether or not the name Victor will be false because we don't want Victor to be
            //allowed to use a tab if necessary. Sorry Victor!
            Boolean actual = papiStore.allowToUseTab("Victor");

            // then
            ////Use assertFalse because expected boolean always has default false. So instead test if the actual is false.
            Assert.assertFalse(actual);
        }
}
