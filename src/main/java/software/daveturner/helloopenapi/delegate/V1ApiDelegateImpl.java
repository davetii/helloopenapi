package software.daveturner.helloopenapi.delegate;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import software.daveturner.helloopenapi.api.*;

@Component
public class V1ApiDelegateImpl  implements V1ApiDelegate {
    @Override
    public ResponseEntity<String> sayHello(String name) {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }
}
