package pl.pizzaservice.pizzaorder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Pizza> getAll() {
        List<Pizza> query = jdbcTemplate.query("Select id, name, ingredients FROM pizza",
                BeanPropertyRowMapper.newInstance(Pizza.class));

        return query;
    }

    public Pizza getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, ingredients FROM pizza WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(Pizza.class), id);
    }

    public int save(List<Pizza> pizzas) {
        pizzas.forEach(pizza -> jdbcTemplate.update("INSERT INTO pizza(name, ingredients) VALUES(?,?)",
               pizza.getName(), pizza.getIngredients() ));

        return 1;
    }
    public int update(Pizza pizza) {
        return jdbcTemplate.update("UPDATE pizza SET name=?, ingredients? WHERE id=?",
                pizza.getName(), pizza.getIngredients(), pizza.getId());
    }

    public int delete (int id) {
        return jdbcTemplate.update("DELETE FROM pizza WHERE id=?", id);
    }
}
