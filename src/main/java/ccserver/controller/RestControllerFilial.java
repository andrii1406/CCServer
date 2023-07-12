package ccserver.controller;

import ccserver.controller.config.ControllerFilial;
import ccserver.dto.FilialDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/filial")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerFilial {

    private final ControllerFilial eController;


    @Autowired
    public RestControllerFilial(ControllerFilial eController) {
        this.eController = eController;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> readAll() throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(eController.readAll(), HttpStatus.OK);
    }

}
