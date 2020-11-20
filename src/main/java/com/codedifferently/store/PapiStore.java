// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the ArrayList Class from the org.junit package or folder
import java.util.ArrayList;
//This is importing the HashMap Class from the org.junit package or folder
import java.util.HashMap;
//This is importing the Map Class from the org.junit package or folder
import java.util.Map;

//This is a public class called PapiStore
public class PapiStore {

    //This is one of the states of the Object PapiStore. No one accept PapiStore has access to this state and it's
    //determining if the initial value of isStoreOpen is true or false.
    private boolean isStoreOpen;
    //This state is only accessible by PapiStore. It is a String Array called tabs used to determine who has a tab.
    private ArrayList<String> tabs;
    //This state is a Map which presents a set of keys and collection of values. The key is the String (or name) of the
    //person who owes money and the value is a Double for how much they owe. A key is an index that points to a value.
    Map<String, Double> owesPapiMoney;

    //This is a public constructor called PapiStore, named after the class it's apart of. This holds all of the
    //initial values of the states listed above.
    public PapiStore(){
        //"this." is used to connect directly to the "isStoreOpen" above. isStoreOpen's initial value is false.
        this.isStoreOpen = false;
        //We created the reference tabs above but tabs was not connected to an object. Here we connect tabs to a new
        //object ArrayList.
        this.tabs = new ArrayList();
        //From what I understand a HashMap is an implementation of the Map interface that allows for null values and
        //the null key because Map is a collection of key value pairs like String and Double.
        this.owesPapiMoney = new HashMap<>();
    }

    //This is another constructor for PapiStore with multiple states. This gives more than one option for the state's
    //initial value. In the parameters it includes another initial value option called isOpen and tabsIn.
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        //Another initial value for isStoreOpen. Now it's either false or isOpen.
        this.isStoreOpen = isOpen;
        //Another initial value for tabs. Now it's either new ArrayList() or tabsIn.
        this.tabs = tabsIn;
        //The reason this is located in both this constructor and the first constructor is because you can only use one
        //constructor at a time. If we choose to use this constructor then we can't use the first one.
        this.owesPapiMoney = new HashMap<>();
    }

    //This is a public method that doesn't return anything because it's void. It is called closeStore.
    public void closeStore(){

    }

    //This is a public method that doesn't return anything because it's void. It is called openStore. For this method
    //the state isStoreOpen is called and the value should be true because the store is open. Because this method is void
    //we need another helper method to be created. That method is "public boolean isStoreOpen()".
    public void openStore(){
        this.isStoreOpen = true;
    }

    //This public method is a boolean (returns true or false/binary output) called isStoreOpen. We test the return
    //isStoreOpen which should be true.
    public boolean isStoreOpen() {
        return isStoreOpen;
    }

    //This public method is a boolean called allowToUseTab that inputs a String called name.
    public Boolean allowToUseTab(String name){
        //A boolean called response equals a false value initially.
        Boolean response = false;
        //response will be false if the person (name) has an active tab & does not have an over due balance.
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
            //if the above parameters are true response will be true.
            response = true;
        //return the response.
        return response;
    }

    //This is a helper method because it is private. This method tracks if someone has an over due balance. It helps
    //the method above called allowToUseTab.
    private boolean hasAnOverDueBalance(String name){
        //if the person (name) doesn't owe money this method will return false because they don't have a balance due.
        if(!owesPapiMoney.containsKey(name))
            return false;
        //Created a Double called money to include decimals that equals the amount a person owes to Papi.
        Double money = owesPapiMoney.get(name);
        //Created a Boolean called owes that equals false initially.
        Boolean owes = false;
        //if the money the person owes is greater than 0.0 the Boolean owes will be true.
        if(money > 0.0)
            owes = true;
        //return owes to know if a person has a balance due.
        return owes;
    }

    //This is another helper method because it is private. This method tracks if someone has an active tab. It helps
    //the method above called allowToUseTab.
    private boolean hasAnActiveTab(String name){
        //for every string called tab with a collection of tabs are the parameters for this enhanced for loop.
        for (String tab : tabs){
            //if someone (name) has a tab this method will return true because they have an active tab.
            if (tab.equals(name))
                return true;
        }
        //else it will return false.
        return false;
    }

    //This is a public method that doesn't return anything because it is void. This method creates a new tab for anyone
    //who has one.
    public void createActiveTab(String name){
        this.tabs.add(name);
    }

    //I know overall this allows us to gain access to the heap.
    //I understand public means everyone has access to it, static means it doesn't
    //belong to any one object and only belongs to the specific class it's in. Void means nothing will be returned.
    //Main is a key word. With it this magic formula works and gives us direct
    //access to the heap.The parameters for main mean that any number of arguments can be accepted
    //in this string array.
    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
