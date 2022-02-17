package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.OdemePlanıEntityDto;
import tr.com.cinigaz.service.serviceimpl.OdemePlanServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(name = ApiAdresses.OdemePlaniControllerAdress.ANA, value = ApiAdresses.OdemePlaniControllerAdress.ANA)
public class OdemePlanController {

    private OdemePlanServiceImpl service;

    public OdemePlanController(OdemePlanServiceImpl service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses.OdemePlaniControllerAdress.TUMLISTE)
    ResponseEntity<List<OdemePlanıEntityDto>> getall() {

        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.OdemePlaniControllerAdress.EKLE)
    ResponseEntity<OdemePlanıEntityDto> ekleplan(@Valid @RequestBody OdemePlanıEntityDto dto) {

        return ResponseEntity.ok(service.save(dto));

    }

    @PutMapping(ApiAdresses.OdemePlaniControllerAdress.DEGISTIR)
    ResponseEntity<OdemePlanıEntityDto> guncelle(@Valid @RequestBody OdemePlanıEntityDto dto) {

        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping(ApiAdresses.OdemePlaniControllerAdress.SIL)
    ResponseEntity<Boolean> delete(@Valid @RequestBody OdemePlanıEntityDto dto2){

        return ResponseEntity.ok(service.delete(dto2));
    }

    @GetMapping(ApiAdresses.OdemePlaniControllerAdress.CEK)
    public ResponseEntity<OdemePlanıEntityDto> getbyıd(@Valid @PathVariable("id") Long id) {

        return ResponseEntity.ok(service.getById(id));
    }
}
