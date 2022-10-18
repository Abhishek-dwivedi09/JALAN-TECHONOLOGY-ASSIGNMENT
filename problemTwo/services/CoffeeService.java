package problemTwo.services;

import problemTwo.model.Coffee;

import java.util.List;

public interface CoffeeService {
    List<Coffee> displayAvailableCoffees();

    Boolean orderCoffee(String coffeeName, List<String> addOnes, String userId);

    Double generateBillByUserId(String userId);
}
