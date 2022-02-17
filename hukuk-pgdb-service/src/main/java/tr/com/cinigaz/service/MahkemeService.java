package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.MahkemeDto;

import java.util.List;

public interface MahkemeService {
    MahkemeDto save(MahkemeDto dto);
    MahkemeDto update(MahkemeDto dto);
    Boolean delete(MahkemeDto dto);
    MahkemeDto getById(Long id);
    List<MahkemeDto> getAll();
}
