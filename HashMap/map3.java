import java.util.*;
public class map3 {

    public static void main(String[] args) {
        // Create a LinkedHashMap to store country and number of players
        LinkedHashMap<String, Integer> countryPlayers = new LinkedHashMap<>();

        // Adding entries (country, number of players)
        countryPlayers.put("India", 15);
        countryPlayers.put("Australia", 12);
        countryPlayers.put("England", 10);
        countryPlayers.put("South Africa", 8);
        countryPlayers.put("New Zealand", 7);

        // Display the LinkedHashMap
        for (Map.Entry<String, Integer> entry : countryPlayers.entrySet()) {
            System.out.println("Country: " + entry.getKey() + ", Number of Players: " + entry.getValue());
        }


}
}
