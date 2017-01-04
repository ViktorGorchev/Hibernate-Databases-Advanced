package app.repositories;

import app.domain.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicIngredientRepository extends JpaRepository<BasicIngredient,Long> {

    @Query(value = "SELECT m FROM Mint AS m")
    List<BasicIngredient> findAllMint();

    @Query(value = "SELECT fn.ingredients FROM FreshNuke AS fn")
    List<BasicIngredient> findAllIngredientsInFreshNuke();
}