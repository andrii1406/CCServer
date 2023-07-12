package ccserver.controller;

import ccserver.controller.config.ControllerKursesPublic;
import ccserver.dto.KursesPublicDTO;
import ccserver.pojo.ThRow;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerHTML {

    private final ControllerKursesPublic eController;

    private final DecimalFormat df = new DecimalFormat( "#.####" );


    @Autowired
    public RestControllerHTML(ControllerKursesPublic eController) {
        this.eController = eController;
    }

    @GetMapping(value = "")
    public ModelAndView index_html() {
        return new ModelAndView("index");
    }

    //Эндпоинт для скачивания картинок
    @GetMapping(value = "public/files/{fileName}")
    public ResponseEntity<?> getImageAsResponseEntity(@PathVariable(name = "fileName") String fn) throws IOException {
        byte[] media = null;
        HttpHeaders headers = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        try {
            InputStream in = getClass().getResourceAsStream("/static/" + fn);
            if (in != null) {
                media = IOUtils.toByteArray(in);
                httpStatus = HttpStatus.OK;
                headers.setCacheControl(CacheControl.noCache().getHeaderValue());
                headers.setContentType(MediaType.IMAGE_JPEG);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        return new ResponseEntity<>(media, headers, httpStatus);
    }

    //Публичные валютные курсы - загрузка данных осуществляется в коде JavaScript
    @GetMapping(value = "public")
    public ModelAndView public_kurses_js() {
        return new ModelAndView("krs_js");
    }

    //Публичные валютные курсы - страница создаётся на сервере генератором Thymeleaf
    @GetMapping(value = "public/{tv}")
    public ModelAndView public_kurses_tl(@PathVariable(name = "tv") Long tv) {
        ModelAndView krsHtml = new ModelAndView("krs_tl");
        krsHtml.addObject("tv", tv);

        List<ThRow> rows = new ArrayList<>();
        List<KursesPublicDTO> list = eController.readKursesPublicPriemsAndProdsByTv(tv);

        list.forEach((value) -> {
            String vl = value.getK().getVl().getVl();

            int index = -1;
            int i = 0;
            for (ThRow val : rows) {
                if (Objects.equals(val.getPvl(), vl)) index = i;
                i++;
            }

            String krs = df.format(value.getK().getKrs());
            krs = krs.replace(',','.');
            long ppId = value.getK().getPp().getId();

            if(index >= 0) {
                if (ppId == 0)
                    rows.get(index).setP0(krs);
                else
                    rows.get(index).setP1(krs);
            }
            else {
                if (ppId == 0)
                    rows.add(new ThRow(krs, "", vl));
                else
                    rows.add(new ThRow("", krs, vl));
            }
        });

        krsHtml.addObject("rows", rows);

        return krsHtml;
    }

}
