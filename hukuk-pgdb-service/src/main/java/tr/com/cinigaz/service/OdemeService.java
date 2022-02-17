package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.OdemeDto;

import java.util.List;

public interface OdemeService {
    OdemeDto save(OdemeDto dto);
    OdemeDto update(OdemeDto dto);
    Boolean delete(OdemeDto dto);
    OdemeDto getById(Long id);
    List<OdemeDto> getAll();
}
