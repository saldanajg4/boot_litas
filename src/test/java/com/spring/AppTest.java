package com.spring;

import static org.junit.Assert.assertTrue;

import com.spring.entity.Ingredient;
import com.spring.entity.Item;
import com.spring.service.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Order_Repository repository;
    Item_Repository item_repository;
    Section_Repository section_repository;
    Category_Repository category_repository;
    Ingredient_Repository ingredient_repository;
    @Before
    public void setup(){

    }
    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
