package Course2.Homeworks.HomeWork3;

import java.util.*;

public class Phonebook {

    private Map<String, Set<String>> map = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (map.containsKey(surname)) {
            map.get(surname).add(phoneNumber);
        } else {
            Set<String> number = new HashSet<>();
            number.add(phoneNumber);
            map.put(surname, number);
        }
    }

    public Set<String> getPhones(String surname) {
        return map.getOrDefault(surname, Collections.emptySet());
    }

}
