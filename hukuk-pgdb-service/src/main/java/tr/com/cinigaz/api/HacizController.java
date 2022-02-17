package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.DosyaMevzuatDto;
import tr.com.cinigaz.dto.HacizDto;
import tr.com.cinigaz.service.serviceimpl.HacizServiceImpl;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/Haciz")
public class HacizController {

    private HacizServiceImpl hacizService;
    public HacizController(HacizServiceImpl hacizService) {
        this.hacizService = hacizService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<HacizDto> hacizEkle(@RequestBody HacizDto hacizDto) {
        HacizDto hacizdto = hacizService.hacizEkle(hacizDto);
        return ResponseEntity.ok(hacizdto);
    }

    @GetMapping(ApiAdresses.HacizControllerAdress.CEK)
    public ResponseEntity<HacizDto> hacizGetirId(@PathVariable("haciz_id") @Valid Long  hacizId) {
        return ResponseEntity.ok(hacizService.hacizGetirId(hacizId));
    }

    @PutMapping(ApiAdresses.HacizControllerAdress.DEGISTIR)
    public ResponseEntity<HacizDto>  hacizGuncelle(@Valid  @RequestBody HacizDto hacizdto){
        HacizDto haciz = hacizService.hacizGuncelle(hacizdto);
        return ResponseEntity.ok((haciz));

    }
    @DeleteMapping(ApiAdresses.HacizControllerAdress.SIL)
    public ResponseEntity<Boolean> hacizSil(@Valid @RequestBody HacizDto hacizDto)
    {
        return ResponseEntity.ok(hacizService.hacizSil(hacizDto));
    }
    @GetMapping(ApiAdresses.HacizControllerAdress.TUMLISTE)
    public ResponseEntity<List<HacizDto>> hacizGetir()
    {
        return ResponseEntity.ok(hacizService.hacizGetir());
    }
}
