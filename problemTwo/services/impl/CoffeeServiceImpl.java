package problemTwo.services.impl;
import problemTwo.model.Coffee;
import problemTwo.services.CoffeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoffeeServiceImpl implements CoffeeService {
    private static HashMap<String, List<Coffee>> coffeeOrderByUserId = new HashMap<>();
    private static HashMap<Coffee, Double> priceList = getPriceMap();

    @Override
    public List<Coffee> displayAvailableCoffees() {
        return getCoffeesList();
    }

    @Override
    public Boolean orderCoffee(String coffeeName, List<String> addOnes, String userId) {
        Coffee coffee = Coffee.builder().coffeeName(coffeeName).addOnes(addOnes).build();
        List<Coffee> coffeeOrders = coffeeOrderByUserId.getOrDefault(userId, new ArrayList<>());
        coffeeOrders.add(coffee);
        coffeeOrderByUserId.put(userId, coffeeOrders);
        return true;
    }

    @Override
    public Double generateBillByUserId(String userId) {
        if(!coffeeOrderByUserId.containsKey(userId)){
            System.out.println("NO ORDER FOUND FOR THIS USER");
            return 0.00;
        }
        List<Coffee> userOrders = coffeeOrderByUserId.get(userId);

        Double billAmount = 0.00;
        for(Coffee coffee : userOrders){
            if(!priceList.containsKey(coffee)){
                System.out.println("PLEASE ADD PRICE FOR THIS COFFEE TYPE");
            }
            billAmount += priceList.get(coffee);
        }
        return billAmount;
    }

    private static HashMap<Coffee, Double> getPriceMap() {
        HashMap<Coffee, Double> priceMap = new HashMap<>();
        Coffee coffee = Coffee.builder().coffeeName("latte").addOnes(List.of("milk", "cream")).build();
        priceMap.put(coffee, 225.00);
        Coffee coffee1 = Coffee.builder().coffeeName("latte").addOnes(List.of("milk", "cream", "latte")).build();
        priceMap.put(coffee1, 225.00);
        Coffee coffee2 = Coffee.builder().coffeeName("latte").addOnes(List.of("milk")).build();
        priceMap.put(coffee2, 100.00);
        Coffee coffee3 = Coffee.builder().coffeeName("latte").addOnes(List.of("milk", "cream")).build();
        priceMap.put(coffee3, 225.00);
        Coffee coffee4 = Coffee.builder().coffeeName("latte").addOnes(List.of("milk", "cream", "latte")).build();
        priceMap.put(coffee4, 225.00);
        Coffee coffee5 = Coffee.builder().coffeeName("latte").addOnes(List.of("milk")).build();
        priceMap.put(coffee5, 100.00);
        return  priceMap;
    }

    private static List<Coffee> getCoffeesList() {
        // we can add all available coffees list here
        List<Coffee> coffees = new ArrayList<>();
        Coffee coffee5 = Coffee.builder().coffeeName("latte").addOnes(List.of("milk")).build();
        Coffee coffee2 = Coffee.builder().coffeeName("latte").addOnes(List.of("milk")).build();
        coffees.add(coffee5);
        coffees.add(coffee2);
        return coffees;
    }
}
