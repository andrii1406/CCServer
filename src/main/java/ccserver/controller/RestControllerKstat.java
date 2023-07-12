package ccserver.controller;

import ccserver.controller.config.ControllerKstat;
import ccserver.dto.KstatDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/kstat")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerKstat {

    private final ControllerKstat eController;


    @Autowired
    public RestControllerKstat(ControllerKstat eController) {
        this.eController = eController;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> readAll() throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(eController.readAll(), HttpStatus.OK);
    }

}
