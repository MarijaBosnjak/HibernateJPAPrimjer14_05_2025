package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Ingredient;
import org.example.model.Meal;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meals");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Meal meal = new Meal("Pizza");
        meal.addIngredient(new Ingredient("Cheese"));
        meal.addIngredient(new Ingredient("Tomato"));
        meal.addIngredient(new Ingredient("Dough"));

        em.persist(meal);
        tx.commit();

        System.out.println("=== Dohvaćanje svih jela ===");
        List<Meal> meals = em.createQuery("SELECT m FROM Meal m", Meal.class).getResultList();

        for (Meal m : meals) {
            System.out.println("Meal: " + m.getName());
            for (Ingredient i : m.getIngredients()) {
                System.out.println("  - Ingredient: " + i.getName());
            }
        }

        em.close();
        emf.close();
    }
}