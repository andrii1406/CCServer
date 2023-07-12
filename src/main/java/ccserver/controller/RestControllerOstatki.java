package ccserver.controller;

import ccserver.controller.config.ControllerOstatki;
import ccserver.dto.OstatkiDTO;
import ccserver.pojo.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/v1/ostatki")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerOstatki {

    private final ControllerOstatki eController;


    @Autowired
    public RestControllerOstatki(ControllerOstatki eController) {
        this.eController = eController;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody OstatkiDTO dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(eController.create(dto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody OstatkiDTO dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        dto.setId(id);
        return new ResponseEntity<>(eController.update(dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return new ResponseEntity<>(eController.delete(new OstatkiDTO(id)), HttpStatus.OK);
    }

    @PostMapping(value = "/{np}")
    public ResponseEntity<?> readByNpAndDt(@PathVariable(name = "np") Long np,
                                           @RequestBody Dates dates) throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(
                eController.readByNpAndDt(np ,dates.getDtB(), dates.getDtE()),
                HttpStatus.OK);
    }

}
