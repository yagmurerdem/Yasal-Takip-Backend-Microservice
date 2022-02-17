package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.IhaleDto;
import tr.com.cinigaz.dto.KurumDto;

import java.util.List;

public interface YetkiService {
    IhaleDto ihaleEkle(IhaleDto ihaleDto);
    IhaleDto ihaleGetirId(Long ihaleId);
    IhaleDto ihaleGuncelle(IhaleDto ihaleDto);
    Boolean ihaleSil(IhaleDto ihaleDto);
    List<IhaleDto> ihaleGetir();
}
