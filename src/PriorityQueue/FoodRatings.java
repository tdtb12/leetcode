package PriorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/design-a-food-rating-system/?envType=daily-question&envId=2025-09-17
public class FoodRatings {

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean"));
    }

    private Map<String, PriorityQueue<Pair>> cuisineFoodMap;
    private Map<String, Integer> foodRatingMap;
    private Map<String, String> foodCuisineMap;

    class Pair {
        private String food;
        private int rating;

        public Pair(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFoodMap = new HashMap<>();
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();

        for (int i = 0; i < cuisines.length; i++) {

            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                    (a, b) -> {
                        if (a.rating == b.rating) {
                            return a.food.compareTo(b.food);
                        }
                        return Integer.compare(a.rating, b.rating) * -1;
                    }
            )).add(new Pair(foods[i], ratings[i]));
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(cuisines[i], foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cuisine = foodCuisineMap.get(food);

        cuisineFoodMap.get(cuisine).add(new Pair(food, newRating));
    }

    public String highestRated(String cuisine) {
        Pair highestPossible = cuisineFoodMap.get(cuisine).peek();

        while (foodRatingMap.get(highestPossible.food) != highestPossible.rating) {
            cuisineFoodMap.get(cuisine).poll();
            highestPossible = cuisineFoodMap.get(cuisine).peek();
        }

        return highestPossible.food;
    }
}
