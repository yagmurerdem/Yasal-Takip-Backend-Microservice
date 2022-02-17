package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.OdemeDto;
import tr.com.cinigaz.entity.OdemeEntity;
import tr.com.cinigaz.repo.OdemeRepository;
import tr.com.cinigaz.service.OdemeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class OdemeServiciImpl implements OdemeService {

    private OdemeRepository repository;
    private ModelMapper map;

    public OdemeServiciImpl(OdemeRepository repository, ModelMapper map) {
        this.repository = repository;
        this.map = map;
    }

    @Override
    public OdemeDto save(OdemeDto dto) {
        OdemeEntity gelen = new OdemeEntity();
        map.map(dto,gelen);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("hüs");
        gelen=repository.save(gelen);
        map.map(gelen,dto);
        return dto;
    }

    @Override
    public OdemeDto update(OdemeDto dto) {
        OdemeEntity gelen = map.map(dto, OdemeEntity.class);
        gelen.setUpdatedAt(new Date());
        gelen.setUpdatedBy("hüs");
        gelen = repository.save(gelen);
        map.map(gelen, dto);
        return dto;
    }

    @Override
    public Boolean delete(OdemeDto dto) {
        OdemeEntity gelen = map.map(dto, OdemeEntity.class);
        try {
            repository.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public OdemeDto getById(Long id) {
            Optional<OdemeEntity> opt;
            opt = repository.findById(id);
            OdemeDto dto = new OdemeDto();
            map.map(opt.get(),dto);
            return dto;
    }

    @Override
    public List<OdemeDto> getAll() {
        List<OdemeEntity> ent1;
        ent1=repository.findAll();
        List<OdemeDto> dto = new ArrayList<>();
        for(OdemeEntity a :ent1) {
            dto.add(map.map(a, OdemeDto.class));
        }
        return dto;
    }
}
