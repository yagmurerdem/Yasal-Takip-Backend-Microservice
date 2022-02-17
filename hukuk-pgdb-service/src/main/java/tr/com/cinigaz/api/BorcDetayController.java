package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.BorcAndBorcDetayDto;
import tr.com.cinigaz.service.BorcAndBorcDetayService;
import tr.com.cinigaz.service.serviceimpl.BorcAndBorcDetayServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(name = ApiAdresses.BorcDetayControllerAdress.ANA, value = ApiAdresses.BorcDetayControllerAdress.ANA)
public class BorcDetayController {

    private BorcAndBorcDetayServiceImpl service;


    public BorcDetayController(BorcAndBorcDetayServiceImpl service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses.BorcDetayControllerAdress.CEK)
    public ResponseEntity<BorcAndBorcDetayDto> getid(@Valid @PathVariable Long id) {

        return ResponseEntity.ok(service.getBorcAndBorcDetayByBorcId(id));
    }

    @PostMapping(ApiAdresses.BorcDetayControllerAdress.EKLE)
    public ResponseEntity<BorcAndBorcDetayDto> saveBorc(@Valid @RequestBody BorcAndBorcDetayDto dto) {
        return ResponseEntity.ok(service.saveBorcDetay(dto));
    }

    @GetMapping(ApiAdresses.BorcDetayControllerAdress.TUMLISTE)
    public ResponseEntity<List<BorcAndBorcDetayDto>> getAllBorc() {
        return ResponseEntity.ok(service.getAll());
    }


}


