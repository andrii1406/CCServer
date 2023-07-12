package ccserver.controller;

import ccserver.controller.config.ControllerPriemProd;
import ccserver.dto.PriemProdDTO;
import ccserver.pojo.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/v1/priemprod")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerPriemProd {

    private final ControllerPriemProd eController;


    @Autowired
    public RestControllerPriemProd(ControllerPriemProd eController) {
        this.eController = eController;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody PriemProdDTO dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(eController.create(dto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody PriemProdDTO dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        dto.setId(id);
        return new ResponseEntity<>(eController.update(dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return new ResponseEntity<>(eController.delete(new PriemProdDTO(id)), HttpStatus.OK);
    }

    @PostMapping(value = "/{pp_id}/{np}")
    public ResponseEntity<?> readByPpAndNpAndDt(@PathVariable(name = "pp_id") Long pp_id,
                                                @PathVariable(name = "np") Long np,
                                                @RequestBody Dates dates) throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(
                eController.readByPpAndNpAndDt(pp_id, np ,dates.getDtB(), dates.getDtE()),
                HttpStatus.OK);
    }

}
