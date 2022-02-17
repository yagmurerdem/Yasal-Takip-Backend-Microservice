package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.service.serviceimpl.AvukatServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = ApiAdresses.AvukatControllerAdress.ANA, value = ApiAdresses.AvukatControllerAdress.ANA)
public class AvukatController {
    private AvukatServiceImpl service;

    public AvukatController(AvukatServiceImpl service) {
        this.service = service;
    }


    @GetMapping(ApiAdresses.AvukatControllerAdress.TUMLISTE)
    public ResponseEntity<List<AvukatDto>> getAllAvukat() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.AvukatControllerAdress.EKLE)
    public ResponseEntity<AvukatDto> saveAvukat(@Valid @RequestBody AvukatDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping(ApiAdresses.AvukatControllerAdress.DEGISTIR)
    public ResponseEntity<AvukatDto>  putAvukat(@Valid  @RequestBody AvukatDto dto){
        AvukatDto updated_avukat = service.update(dto);
        return ResponseEntity.ok((updated_avukat));

    }
    @DeleteMapping(ApiAdresses.AvukatControllerAdress.SIL+"/{s}")
    public ResponseEntity<Boolean> deleteAvukat(@Valid @PathVariable("s") Integer sicilNo){
        return ResponseEntity.ok((service.delete(sicilNo)));
    }
    @GetMapping(ApiAdresses.AvukatControllerAdress.CEK)
    public ResponseEntity<AvukatDto> getbyid(@Valid @PathVariable("id") Integer id){
     return ResponseEntity.ok(service.getById(id));
    }

}


