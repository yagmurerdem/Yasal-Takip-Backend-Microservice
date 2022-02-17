package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.HacizDto;
import tr.com.cinigaz.dto.KurumDto;
import tr.com.cinigaz.service.KurumService;
import tr.com.cinigaz.service.serviceimpl.HacizServiceImpl;
import tr.com.cinigaz.service.serviceimpl.KurumServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/Kurum")
public class KurumController {

    private KurumServiceImpl kurumService;

    public KurumController(KurumServiceImpl kurumService) {
        this.kurumService = kurumService;
    }

    @PostMapping(ApiAdresses.KurumControllerAdress.EKLE)
    public ResponseEntity<KurumDto> kurumEkle(@RequestBody KurumDto kurumDto) {
        KurumDto kurumdto = kurumService.kurumEkle(kurumDto);
        return ResponseEntity.ok(kurumdto);
    }

    @GetMapping(ApiAdresses.KurumControllerAdress.CEK)
    public ResponseEntity<KurumDto> kurumGetirId(@PathVariable("kurum_id") @Valid Long  kurumId) {
        return ResponseEntity.ok(kurumService.kurumGetirId(kurumId));
    }

    @PutMapping(ApiAdresses.KurumControllerAdress.DEGISTIR)
    public ResponseEntity<KurumDto> kurumGuncelle(@Valid @RequestBody KurumDto kurumDto) {
        KurumDto kurumDtos = kurumService.kurumGuncelle(kurumDto);
        return ResponseEntity.ok(kurumDtos);
    }

    @DeleteMapping(ApiAdresses.KurumControllerAdress.SIL)
    public ResponseEntity<Boolean> kurumSil(@Valid @RequestBody KurumDto kurumDto)
    {
        return ResponseEntity.ok((kurumService.kurumSil(kurumDto)));
    }
    @GetMapping(ApiAdresses.KurumControllerAdress.TUMLISTE)
    public ResponseEntity<List<KurumDto>> kurumGetir()
    {
        return ResponseEntity.ok(kurumService.kurumGetir());
    }
}