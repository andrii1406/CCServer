package ccserver.controller;

import ccserver.controller.config.ControllerKurses;
import ccserver.dto.KursesDTO;
import ccserver.pojo.Dates;
import jakarta.persistence.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/kurses")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerKurses {

    private final ControllerKurses eController;


    @Autowired
    public RestControllerKurses(ControllerKurses eController) {
        this.eController = eController;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody List<KursesDTO> dtoList) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(eController.create(dtoList), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody KursesDTO dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        dto.setId(id);
        return new ResponseEntity<>(eController.update(dto), HttpStatus.OK);
    }

    @PostMapping(value = "/{np}")
    public ResponseEntity<?> readByNpAndDt(@PathVariable(name = "np") Long np,
                                           @RequestBody Dates dates) throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(
                eController.readByNpAndDt(np ,dates.getDtB(), dates.getDtE()),
                HttpStatus.OK);
    }

    @PostMapping(value = "/delbynp/{np}")
    public ResponseEntity<?> deleteKursesByNpAndDt(@PathVariable(name = "np") Long np,
                                                   @RequestBody Dates dates) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        eController.deleteKursesByNpAndDt(np ,dates.getDtB(), dates.getDtE());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
