package Course2.Homeworks.HomeWork3;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Words[] words = {
                new Words("cat"), new Words("cat"), new Words("cat"), new Words("dog"),
                new Words("dog"), new Words("dog"), new Words("mouse"), new Words("mouse"),
                new Words("mouse"), new Words("bird")
        };

        List<Words> lWords = new ArrayList<>(Arrays.asList(words));
        System.out.println(lWords);

        Set<Words> sWords = new LinkedHashSet<>(Arrays.asList(words));
        for (Words word : sWords) {
            System.out.println(word + ":" + Collections.frequency(lWords, word));
        }
        System.out.println(sWords);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Utkin", "224522");
        phonebook.add("Utkin", "228822");
        phonebook.add("Petrov", "227622");
        phonebook.add("Petrov", "222522");

        System.out.println(phonebook.getPhones("Utkin"));
        System.out.println(phonebook.getPhones("Petrov"));
    }
}
