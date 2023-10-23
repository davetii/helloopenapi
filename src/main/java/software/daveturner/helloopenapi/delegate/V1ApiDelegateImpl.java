package software.daveturner.helloopenapi.delegate;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import software.daveturner.helloopenapi.api.*;
import software.daveturner.helloopenapi.model.*;

import java.util.*;

@Component
public class V1ApiDelegateImpl  implements V1ApiDelegate {

    Map<String, Person> people = new HashMap<>();
    public V1ApiDelegateImpl() {
        people.put("Diana", newPerson("Diana", "Wife"));
        people.put("Mary", newPerson("Mary", "Daughter"));
        people.put("David", newPerson("David", "Son"));
        people.put("Wendie", newPerson("Wendie", "Sister"));
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
        return ResponseEntity.ok(new ArrayList<Person>(people.values()));
    }
}
