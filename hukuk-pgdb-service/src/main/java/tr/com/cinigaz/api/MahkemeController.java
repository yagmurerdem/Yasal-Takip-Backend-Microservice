package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.MahkemeDto;
import tr.com.cinigaz.service.serviceimpl.MahkemeServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(name = ApiAdresses.MahkemeControllerAdress.ANA,value = ApiAdresses.MahkemeControllerAdress.ANA)
public class MahkemeController {

    private MahkemeServiceImpl service;

    public MahkemeController(MahkemeServiceImpl service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses.MahkemeControllerAdress.TUMLISTE)
    ResponseEntity<List<MahkemeDto>> hepsi(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping(ApiAdresses.MahkemeControllerAdress.EKLE)
    ResponseEntity<MahkemeDto> ekle(@Valid @RequestBody MahkemeDto dto){

        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping(ApiAdresses.MahkemeControllerAdress.DEGISTIR)
    ResponseEntity<MahkemeDto> guncelle(@Valid @RequestBody MahkemeDto dto){

        return ResponseEntity.ok(service.update(dto));
    }
    @DeleteMapping(ApiAdresses.MahkemeControllerAdress.SIL)
    ResponseEntity<Boolean> delete(@Valid @RequestBody MahkemeDto dto){
        return ResponseEntity.ok(service.delete(dto));
    }
    @GetMapping(ApiAdresses.MahkemeControllerAdress.CEK)
    ResponseEntity<MahkemeDto> getbyid(@Valid @PathVariable("id") Long id){

        return ResponseEntity.ok(service.getById(id));
    }

}
