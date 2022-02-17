package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.OdemeDto;
import tr.com.cinigaz.service.serviceimpl.OdemeServiciImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(name = ApiAdresses.OdemeControllerAdress.ANA,value = ApiAdresses.OdemeControllerAdress.ANA)
public class OdemeController {

    private OdemeServiciImpl service;

    public OdemeController(OdemeServiciImpl service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses.OdemeControllerAdress.TUMLISTE)
    ResponseEntity<List<OdemeDto>> odemeler(){

        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping(ApiAdresses.OdemeControllerAdress.EKLE)
    ResponseEntity<OdemeDto> ekleodeme(@Valid @RequestBody OdemeDto dto){

        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(ApiAdresses.OdemeControllerAdress.DEGISTIR)
    ResponseEntity<OdemeDto> update(@Valid @RequestBody OdemeDto dto){

        return ResponseEntity.ok(service.update(dto));
    }
    @DeleteMapping(ApiAdresses.OdemeControllerAdress.SIL)
    ResponseEntity<Boolean> delete(@Valid @RequestBody OdemeDto dto){

        return ResponseEntity.ok(service.delete(dto));
    }

    @GetMapping(ApiAdresses.OdemeControllerAdress.CEK)
    ResponseEntity<OdemeDto> getById(@Valid @PathVariable("id") Long id){

        return ResponseEntity.ok(service.getById(id));
    }


}
