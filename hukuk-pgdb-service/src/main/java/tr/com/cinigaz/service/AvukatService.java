package tr.com.cinigaz.service;


import tr.com.cinigaz.dto.AvukatDto;

import java.util.List;

public interface AvukatService {
    AvukatDto save(AvukatDto dto);
    AvukatDto update(AvukatDto dto);
    Boolean delete(Integer sicilNo);
    AvukatDto getById(Integer id);
    List<AvukatDto> getAll();
}
