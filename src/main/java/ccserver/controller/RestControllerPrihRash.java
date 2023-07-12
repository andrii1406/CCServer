package ccserver.controller;

import ccserver.controller.config.ControllerPrihRash;
import ccserver.dto.PrihRashDTO;
import ccserver.pojo.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/v1/prihrash")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerPrihRash {

    private final ControllerPrihRash eController;


    @Autowired
    public RestControllerPrihRash(ControllerPrihRash eController) {
        this.eController = eController;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody PrihRashDTO dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(eController.create(dto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody PrihRashDTO dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        dto.setId(id);
        return new ResponseEntity<>(eController.update(dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return new ResponseEntity<>(eController.delete(new PrihRashDTO(id)), HttpStatus.OK);
    }

    @PostMapping(value = "/{pr_id}/{npo}")
    public ResponseEntity<?> readByPrAndNpAndDt(@PathVariable(name = "pr_id") Long pr_id,
                                                @PathVariable(name = "npo") Long npo,
                                                @RequestBody Dates dates) throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(
                eController.readByPrAndNpAndDt(pr_id, npo, dates.getDtB(), dates.getDtE()),
                HttpStatus.OK);
    }

}
