package ccserver.controller;

import ccserver.controller.config.ControllerKursesPublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publickrs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerPublicKrs {

    private final ControllerKursesPublic eController;


    @Autowired
    public RestControllerPublicKrs(ControllerKursesPublic eController) {
        this.eController = eController;
    }

    @GetMapping(value = "/priemprod/{tv}")
    public ResponseEntity<?> readKursesPublicPriemsAndProdsByTv(@PathVariable(name = "tv") Long tv) throws NullPointerException, ClassCastException {
        return new ResponseEntity<>(
                eController.readKursesPublicPriemsAndProdsByTv(tv),
                HttpStatus.OK);
    }

}
