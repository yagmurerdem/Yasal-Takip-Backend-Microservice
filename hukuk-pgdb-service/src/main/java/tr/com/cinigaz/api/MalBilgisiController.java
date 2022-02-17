package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.MalBilgisiDto;
import tr.com.cinigaz.service.serviceimpl.MalBilgisiImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(name= ApiAdresses.MalBilgisiControllerAdress.ANA,value = ApiAdresses.MalBilgisiControllerAdress.ANA)
public class MalBilgisiController {

    private MalBilgisiImpl service;


    public MalBilgisiController(MalBilgisiImpl service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses.MalBilgisiControllerAdress.TUMLISTE)
    ResponseEntity<List<MalBilgisiDto>> getir(){

        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping(ApiAdresses.MalBilgisiControllerAdress.EKLE)
    ResponseEntity<MalBilgisiDto> ekle(@Valid @RequestBody MalBilgisiDto dto){
        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping(ApiAdresses.MalBilgisiControllerAdress.DEGISTIR)
    ResponseEntity<MalBilgisiDto> guncelle(@Valid @RequestBody MalBilgisiDto dto){
        return ResponseEntity.ok(service.update(dto));
    }
    @DeleteMapping(ApiAdresses.MalBilgisiControllerAdress.SIL)
    ResponseEntity<Boolean> delete(@Valid @RequestBody MalBilgisiDto dto){

        return ResponseEntity.ok(service.delete(dto));
    }
    @GetMapping(ApiAdresses.MalBilgisiControllerAdress.CEK)
    ResponseEntity<MalBilgisiDto> getbyid(@Valid @PathVariable("id") Long id)
    {
        return ResponseEntity.ok(service.getById(id));

    }
}
