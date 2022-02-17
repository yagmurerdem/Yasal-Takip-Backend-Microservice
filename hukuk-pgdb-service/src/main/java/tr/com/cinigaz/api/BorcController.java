package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.BorcDto;
import tr.com.cinigaz.service.serviceimpl.BorcServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(name = ApiAdresses.BorcControllerAdress.ANA, value = ApiAdresses.BorcControllerAdress.ANA)
public class BorcController {

    private BorcServiceImpl service;

    public BorcController(BorcServiceImpl service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses.BorcControllerAdress.TUMLISTE)
    public ResponseEntity<List<BorcDto>> getAllBorc() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.BorcControllerAdress.EKLE)
    public ResponseEntity<BorcDto> saveBorc(@Valid @RequestBody BorcDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(ApiAdresses.BorcControllerAdress.DEGISTIR)
    public ResponseEntity<BorcDto> updateBorc(@Valid @RequestBody BorcDto dto){
        return ResponseEntity.ok(service.save(dto));
    }
    @DeleteMapping(ApiAdresses.BorcControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteBorc(@Valid @RequestBody BorcDto dto){

        return ResponseEntity.ok(service.delete(dto));
    }
    @GetMapping(ApiAdresses.BorcControllerAdress.CEK)
    public ResponseEntity<BorcDto> getid(@Valid @PathVariable Integer id){

        return ResponseEntity.ok(service.getById(id));
    }

}
