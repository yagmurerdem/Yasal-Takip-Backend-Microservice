package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.IhaleDto;
import tr.com.cinigaz.service.serviceimpl.YetkiServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/Ihale")
public class YetkiController {

    private YetkiServiceImpl ihaleService;

    public YetkiController(YetkiServiceImpl ihaleService) {
        this.ihaleService = ihaleService;
    }

    @PostMapping(ApiAdresses.YetkiControllerAdress.EKLE)
    public ResponseEntity<IhaleDto> IhaleEkle(@RequestBody IhaleDto ihaleDto) {
        IhaleDto ihaledto = ihaleService.ihaleEkle(ihaleDto);
        return ResponseEntity.ok(ihaledto);
    }

    @GetMapping(ApiAdresses.YetkiControllerAdress.CEK)
    public ResponseEntity<IhaleDto> IhaleGetirId(@PathVariable("ihale_id") @Valid Long  ihaleId) {
        return ResponseEntity.ok(ihaleService.ihaleGetirId(ihaleId));
    }

    @PutMapping(ApiAdresses.YetkiControllerAdress.DEGISTIR)
    public ResponseEntity<IhaleDto> ihaleGuncelle(@Valid  @RequestBody IhaleDto ihaleDto) {
        IhaleDto ihaleDtos = ihaleService.ihaleGuncelle(ihaleDto);
        return ResponseEntity.ok(ihaleDtos);
    }
    @DeleteMapping(ApiAdresses.YetkiControllerAdress.SIL)
    public ResponseEntity<Boolean> ihaleSil(@Valid @RequestBody IhaleDto ihaleDto)
    {
        return ResponseEntity.ok((ihaleService.ihaleSil(ihaleDto)));
    }
    @GetMapping(ApiAdresses.YetkiControllerAdress.TUMLISTE)
    public ResponseEntity<List<IhaleDto>> ihaleGetir()
    {
        return ResponseEntity.ok(ihaleService.ihaleGetir());
    }
}