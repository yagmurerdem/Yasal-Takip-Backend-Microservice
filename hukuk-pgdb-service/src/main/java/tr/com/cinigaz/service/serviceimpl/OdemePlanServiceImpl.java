package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.OdemePlanıEntityDto;
import tr.com.cinigaz.entity.OdemePlanıEntity;
import tr.com.cinigaz.repo.OdemePlanıRepository;
import tr.com.cinigaz.service.OdemePlanService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OdemePlanServiceImpl implements OdemePlanService {

    private ModelMapper map;
    private OdemePlanıRepository repository;

    public OdemePlanServiceImpl(ModelMapper map, OdemePlanıRepository repository) {
        this.map = map;
        this.repository = repository;
    }

    @Override
    public OdemePlanıEntityDto save(OdemePlanıEntityDto dto) {
        OdemePlanıEntity gelen=map.map(dto,OdemePlanıEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("hüs");
        gelen = repository.save(gelen);
        map.map(dto,gelen);

        return dto;
    }

    @Override
    public OdemePlanıEntityDto update(OdemePlanıEntityDto dto) {
        OdemePlanıEntity gelen=map.map(dto,OdemePlanıEntity.class);
        gelen.setUpdatedAt(new Date());
        gelen.setUpdatedBy("hus");
        gelen =repository.save(gelen);
        map.map(dto,gelen);

        return dto;
    }

    @Override
    public Boolean delete(OdemePlanıEntityDto dto) {
        OdemePlanıEntity gelen=map.map(dto,OdemePlanıEntity.class);
        try {
            repository.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public OdemePlanıEntityDto getById(Long id) {
        Optional<OdemePlanıEntity> opt;
        opt = repository.findById(id);
        OdemePlanıEntityDto dto = new OdemePlanıEntityDto();
        map.map(dto,opt.get());
        return dto;
    }

    @Override
    public List<OdemePlanıEntityDto> getAll() {
        List<OdemePlanıEntity> ent1 = repository.findAll();
        List<OdemePlanıEntityDto> ent2= new ArrayList<>();
        for (OdemePlanıEntity a : ent1) {
            ent2.add(map.map(a, OdemePlanıEntityDto.class));
        }

        return ent2;
    }
}
