package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.HacizDto;
import tr.com.cinigaz.dto.KurumDto;

import java.util.List;

public interface KurumService {
    KurumDto kurumEkle(KurumDto kurumDto);
    KurumDto kurumGetirId(Long kurumId);
    KurumDto kurumGuncelle(KurumDto kurumDto);
    Boolean kurumSil(KurumDto kurumDto);
    List<KurumDto> kurumGetir();
}
