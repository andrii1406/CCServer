package ccserver.controller;

import ccserver.controller.config.ControllerOperation;
import ccserver.dto.OperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/v1/operation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerOperation {

    private final ControllerOperation eController;


    @Autowired
    public RestControllerOperation(ControllerOperation eController) {
        this.eController = eController;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> readAll() throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(eController.readAll(), HttpStatus.OK);
    }

}
