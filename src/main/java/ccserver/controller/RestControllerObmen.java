package ccserver.controller;

import ccserver.controller.config.ControllerObmen;
import ccserver.dto.ObmenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/v1/obmen")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerObmen {

    private final ControllerObmen eController;


    @Autowired
    public RestControllerObmen(ControllerObmen eController) {
        this.eController = eController;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> readAll() throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(eController.readAll(), HttpStatus.OK);
    }

}
