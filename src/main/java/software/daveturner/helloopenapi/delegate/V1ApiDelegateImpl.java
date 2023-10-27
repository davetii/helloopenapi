package software.daveturner.helloopenapi.delegate;


import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;
import reactor.core.publisher.*;
import software.daveturner.helloopenapi.api.*;
import software.daveturner.helloopenapi.client.api.*;
import software.daveturner.helloopenapi.model.*;

import java.util.*;

@Service
public class V1ApiDelegateImpl implements V1ApiDelegate {

    private final Map<String, Person> people = new HashMap<>();

    private final DefaultApi client;

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
    public Mono<ResponseEntity<String>> sayHello(String name, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>("Hello " + name, HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Flux<Person>>> getAllPersons(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok(Flux.fromIterable(people.values())));
    }

    @Override
    public Mono<ResponseEntity<Person>> readPerson(String name, ServerWebExchange exchange) {
        Person p = people.get(name);
        if (p == null) { return Mono.just(ResponseEntity.notFound().build()); }
        return Mono.just(ResponseEntity.ok(p));
    }

    @Override
    public Mono<ResponseEntity<Void>> deletePerson(String name, ServerWebExchange exchange) {
        int initKeys = people.keySet().size();
        people.remove(name);
        if(initKeys == people.keySet().size()) { return Mono.just(ResponseEntity.notFound().build()); }
        return Mono.just(ResponseEntity.noContent().build());
    }

    @Override
    public Mono<ResponseEntity<Person>> createPerson(Mono<Person> person, ServerWebExchange exchange) {
        return createUpdatePerson(person);
    }

    @Override
    public Mono<ResponseEntity<Person>> updatePerson(Mono<Person> person, ServerWebExchange exchange) {
        return createUpdatePerson(person);
    }

    public Mono<ResponseEntity<Person>> createUpdatePerson(Mono<Person> person) {
        return person.map( p -> {
            people.put(p.getName(), p);
            return ResponseEntity.ok(p);
        });
    }

    public Mono<List<String>> readRoles() {
        return client.readRoles().collectList();
    }
}
