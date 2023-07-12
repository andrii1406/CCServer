package ccserver.controller;

import ccserver.controller.config.ControllerCurrency;
import ccserver.dto.CurrencyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/currency")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerCurrency {

    private final ControllerCurrency eController;


    @Autowired
    public RestControllerCurrency(ControllerCurrency eController) {
        this.eController = eController;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> readAll() throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(eController.readAll(), HttpStatus.OK);
    }

}
