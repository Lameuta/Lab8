package com.example.lab8;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City acity = new City("Edmonton", "AB");
        list.addCity(acity);
        assertEquals(list.hasCity(acity),true);
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City acity1 = new City("Calgary", "AB");
        list.addCity(acity1);
        list.deleteCity(acity1);
        assertEquals(list.hasCity(acity1),false);
        assertThrows( IllegalArgumentException.class, () -> {
            list.deleteCity(acity1); });
    }

    @Test
    public void countCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("a", "SK"));
        list.addCity(new City("b", "SK"));
        list.addCity(new City("c", "SK"));
        assertEquals(list.getCount(),listSize + 4);
    }



}
