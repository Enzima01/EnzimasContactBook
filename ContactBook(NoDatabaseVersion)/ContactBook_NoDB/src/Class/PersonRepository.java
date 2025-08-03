package Class;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private static List<Person> people = new ArrayList<>();
    private static int idCounter = 1;

    public static void addPerson(Person p) {
        p.setId(idCounter++);
        people.add(p);
    }

    public static List<Person> getAll() {
        return new ArrayList<>(people);
    }

    public static void removePerson(Person p) {
        people.remove(p);
    }

    public static void updatePerson(Person updatedPerson) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == updatedPerson.getId()) {
                people.set(i, updatedPerson); // substitui o antigo
                return;
            }
        }
    }

    public static Person getById(int id) {
        for (Person p : people) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}

