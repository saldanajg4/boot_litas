package com.spring;

import com.spring.entity.*;
import com.spring.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Hello world!
 *
 */
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@EnableJpaAuditing
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
    @Bean
    public CommandLineRunner demo(final Order_Repository repository, final Item_Repository item_repository,
                                  final Section_Repository section_repository, Category_Repository category_repository,
                                  final Ingredient_Repository ingredient_repository){

            return (args) -> {
                section_repository.save(new Section("kitchen"));
                section_repository.save(new Section("Bar"));
                Category cat = new Category();
                cat.setCategory_name("postres");
                category_repository.save(cat);
                category_repository.save(new Category("bebidas"));
                category_repository.save(new Category("salsas"));
                category_repository.save(new Category("sandwiches"));
                category_repository.save(new Category("antojitos"));
                category_repository.save(new Category("caldos"));

                ingredient_repository.save(new Ingredient("crema"));
                ingredient_repository.save(new Ingredient("fajita"));
                ingredient_repository.save(new Ingredient("lechuga"));
                ingredient_repository.save(new Ingredient("chicharron"));
                ingredient_repository.save(new Ingredient("pollo"));
                ingredient_repository.save(new Ingredient("aguacate"));
                ingredient_repository.save(new Ingredient("queso"));
                ingredient_repository.save(new Ingredient("guacamole"));
                ingredient_repository.save(new Ingredient("cebolla"));

//                Section sec = section_repository.findById(2L).get();

//                flan item
                Item item = new Item();
                item.setItem_name("chocoflan");
                item.setDescription("pastel de choco");
                item.setPrice(3.00);
                item.setSectionObject(section_repository.findById(2L).get());
                item.setCategoryObject(category_repository.findById(1L).get());
//                this is only needed for OneToMany
//                Ingredient ingredient1 = new Ingredient();
//                ingredient1.setName("whip cream");
//                ingredient1.setItem(item);
//
//                Ingredient ingredient2 = new Ingredient();
//                ingredient2.setName("honey");
//                ingredient2.setItem(item);
//
//                //add ingredients to item
//                item.getIngredientSet().add(ingredient1);
//                item.getIngredientSet().add(ingredient2);
                item.setIngredientSet(this.getIngredients(ingredient_repository,1,3));//this item will have
                                                                            //crema, fajita, lechuga

                //save item
                item_repository.save(item);

//                huarache item
                item = new Item();
                item.setItem_name("huarache");
                item.setDescription("made out of fresh corn dough filled with your choice of meat or vegetables");
                item.setPrice(10.00);
                item.setSectionObject(section_repository.findById(1L).get());
                item.setCategoryObject(category_repository.findById(5L).get());
//                ingredient1 = new Ingredient();
//                ingredient1.setName("lechuga");
//                ingredient1.setItem(item);
//
//                ingredient2 = new Ingredient();
//                ingredient2.setName("aguacate");
//                ingredient2.setItem(item);
//
//                //add ingredients to item
//                item.getIngredientSet().add(ingredient1);
//                item.getIngredientSet().add(ingredient2);
                //add section to item
                item.setIngredientSet(this.getIngredients(ingredient_repository,3,5));//this item will have
                                                        //pollo, aguacate, queso
                //save item
                item_repository.save(item);

                //tostada regia
                item = new Item();
                item.setItem_name("Tostada Regia");
                item.setDescription("made out of fresh corn deep fried tortilla");
                item.setPrice(10.00);
                item.setSectionObject(section_repository.findById(1L).get());
                item.setCategoryObject(category_repository.findById(5L).get());
//                ingredient1 = new Ingredient();
//                ingredient1.setName("guacamole");
//                ingredient1.setItem(item);
//
//                ingredient2 = new Ingredient();
//                ingredient2.setName("pollo");
//                ingredient2.setItem(item);
//
//                //add ingredients to item
//                item.getIngredientSet().add(ingredient1);
//                item.getIngredientSet().add(ingredient2);

                item.setIngredientSet(this.getIngredients(ingredient_repository,2,7));//this item will have

                item_repository.save(item);


//                Quesadilla
                item = new Item();
                item.setItem_name("Quesadilla");
                item.setDescription("made out of fresh corn tortilla");
                item.setPrice(10.00);
                item.setSectionObject(section_repository.findById(1L).get());
                item.setCategoryObject(category_repository.findById(5L).get());

                item.setIngredientSet(this.getIngredients(ingredient_repository,4,9));//this item will have
                item_repository.save(item);





//            Item( String name, String desc, double price, Customer_Order customer_order){

//                item_repository.save(new Item("choco flan", "flan con pastel de chocolate", 3.00, "postres", "bar"));
//                item_repository.save(new Item("Tacos", "Tortilla hecha a mano con opcion de carnes", 2.00, "antojitos","kitchen"));
//                item_repository.save(new Item("Agua Fresca Gde.", "pura fruta natural", 3.00, "bebidas", "bar"));
//                item_repository.save(new Item("pozole", "verde hecho a base de verduras frescas y mole verde, servido con taquitos dorados de papa", 10.00, "caldos","kitchen"));
//                item_repository.save(new Item("huarache", "made out of fresh corn dough filled with your choice of meat or vegetables", 8.50, "antojitos","kitchen"));
//                item_repository.save(new Item("quesadilla", "made out of fresh corn dough folded with your choice of meat or vegetables", 9.50, "antojitos","kitchen"));

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                Customer_Order order = new Customer_Order();
                order.setCustomer("miguel");
                order.setOrdered_At(dateFormat.format(date));
                order.setComments("there will be a to go order also.");


                Customer_Order order2 = new Customer_Order();
                order2.setCustomer("pablo");
                order2.setOrdered_At(dateFormat.format(date));
                order2.setComments("va junto con lo de mama");


//            Item item = new Item();
//            item.setItem_name("huarache");
//            item.setDescription("made out of fresh corn dough filled with your choice of meat or vegetables");
//            item.setPrice(8.50);
//
//            Item item2 = new Item();
//            item2.setItem_name("quesadilla");
//            item2.setDescription("made out of fresh corn dough folded with your choice of meat or vegetables");
//            item2.setPrice(9.50);

                Set<Item> itemList = getItems(item_repository, 1, 3);

                order.setItemList(itemList);
                order.setTotal(itemList);
                repository.save(order);

                itemList = getItems(item_repository, 2, 3);
                order2.setItemList(itemList);
                order2.setTotal(itemList);
                repository.save(order2);


//            repository.save(new Customer_Order("Miguel",20.50, dateFormat.format(date), "there will be a to go order also.",null));
//            repository.save(new Customer_Order("jose",37.50, dateFormat.format(date), "dessert on the way."));
//            repository.save(new Customer_Order("ana",80.50, dateFormat.format(date), "waiting for more people"));
//
//            item_repository.save(new Item(1,"huarache","made out of fresh corn dough filled with your choice of meat or vegetables",null));
//            item_repository.save(new Item(1,"quesadilla","made out of fresh corn dough folded with your choice of meat or vegetables"));
//
//            for (Customer_Order customerOrder : repository.findAll()){
//                log.info("Customer_Order: " + customerOrder.toString());
//            }
            };

    }

    private Set<Item> getItems(Item_Repository item_repository,int from, int to) {
        Set<Item> itemList = new HashSet<Item>();
        for(long i = from ; i <=to; i++){
            Optional<Item> item =item_repository.findById(i);
            if(item.isPresent())
                itemList.add(item.get());
        }
        return itemList;
    }

    private Set<Ingredient> getIngredients(Ingredient_Repository ingredient_repository,int from, int to) {
        Set<Ingredient> IngredientList = new HashSet<Ingredient>();
        for(long i = from ; i <=to; i++){
            Optional<Ingredient> item =ingredient_repository.findById(i);
            if(item.isPresent())
                IngredientList.add(item.get());
        }
        return IngredientList;
    }


}
