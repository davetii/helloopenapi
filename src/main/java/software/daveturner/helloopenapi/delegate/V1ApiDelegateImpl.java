package software.daveturner.helloopenapi.delegate;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import software.daveturner.helloopenapi.api.*;
import software.daveturner.helloopenapi.client.api.*;
import software.daveturner.helloopenapi.model.*;

import java.util.*;

@Service
public class V1ApiDelegateImpl  implements V1ApiDelegate {

    private final DefaultApi client;
    private final Map<String, Person> people = new HashMap<>();
    public V1ApiDelegateImpl() {
        people.put("Diana", newPerson("Diana", "spouse"));
        people.put("Mary", newPerson("Mary", "child"));
        people.put("David", newPerson("David", "child"));
        people.put("Wendie", newPerson("Wendie", "sibling"));
        client = new DefaultApi();
    }

    private Person newPerson(String n, String r) {
        Person p = new Person();
        p.setName(n);
        p.setRole(r);
        return p;
    }

    @Override
    public ResponseEntity<String> sayHello(String name) {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(new ArrayList<>(people.values()));
    }

    @Override
    public ResponseEntity<Person> createPerson(Person person) {
        return createUpdatePerson(person);
    }

    @Override
    public ResponseEntity<Person> updatePerson(Person person) {
        return createUpdatePerson(person);
    }

    public ResponseEntity<Person> createUpdatePerson(Person person) {
        List<String> allowedRoles = readRoles();
        if(allowedRoles.contains(person.getRole())) {
            people.put(person.getName(), person);
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Void> deletePerson(String name) {
        int initKeys = people.keySet().size();
        people.remove(name);
        if(initKeys == people.keySet().size()) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Person> readPerson(String name) {
        Person p = people.get(name);
        if (p == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(people.get(name));
    }

    public List<String> readRoles() {
        return client.readRoles();
    }
}
