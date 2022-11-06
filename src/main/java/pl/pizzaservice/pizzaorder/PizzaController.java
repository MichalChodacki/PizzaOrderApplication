package pl.pizzaservice.pizzaorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping("/")

    public List<Pizza> getAll() {
         return pizzaRepository.getAll();
    }

    @GetMapping("/{id}")
    public Pizza getById(@PathVariable("id")int id) {
        return pizzaRepository.getById(id);
    }

    @PostMapping("/")
    public int add(@RequestBody List<Pizza> pizzas) {
       return pizzaRepository.save(pizzas);
    }
    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Pizza updatedPizza) {
        Pizza pizza = pizzaRepository.getById(id);

        if (pizza !=null){
            pizza.setName(updatedPizza.getName());
            pizza.setIngredients(updatedPizza.getIngredients());

            pizzaRepository.update(pizza);

            return 1;

        }else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Pizza updatedPizza) {
        Pizza pizza = pizzaRepository.getById(id);

        if (pizza !=null) {
            if (updatedPizza.getName() !=null) pizza.setName(updatedPizza.getName());
            if (updatedPizza.getIngredients() != null) pizza.setIngredients(updatedPizza.getIngredients());

            pizzaRepository.update(pizza);

            return 1;
        }   else {
            return -1;
        }

    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return pizzaRepository.delete(id);

    }
}
