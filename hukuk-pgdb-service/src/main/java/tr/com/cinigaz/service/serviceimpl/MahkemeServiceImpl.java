package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.MahkemeDto;
import tr.com.cinigaz.entity.MahkemeEntity;
import tr.com.cinigaz.repo.MahkemeRepsitory;
import tr.com.cinigaz.service.MahkemeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class MahkemeServiceImpl implements MahkemeService {

    private ModelMapper map;
    private MahkemeRepsitory repository;

    public MahkemeServiceImpl(ModelMapper map, MahkemeRepsitory repository) {
        this.map = map;
        this.repository = repository;
    }


    @Override
    public MahkemeDto save(MahkemeDto dto) {
        MahkemeEntity gelen = map.map(dto,MahkemeEntity.class);
        gelen = repository.save(gelen);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("hüs");
        map.map(gelen,dto);
        return dto;
    }

    @Override
    public MahkemeDto update(MahkemeDto dto) {
        MahkemeEntity gelen = map.map(dto,MahkemeEntity.class);
        gelen = repository.save(gelen);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("hüs");
        map.map(gelen,dto);
        return dto;
    }

    @Override
    public Boolean delete(MahkemeDto dto) {
        MahkemeEntity gelen = map.map(dto,MahkemeEntity.class);
        try {
            repository.delete(gelen);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public MahkemeDto getById(Long id) {
        Optional<MahkemeEntity> opt = repository.findById(id);
        MahkemeDto dto = new MahkemeDto();
        map.map(dto,opt.get());
        return dto;
    }

    @Override
    public List<MahkemeDto> getAll() {
        List<MahkemeEntity> ent = repository.findAll();
        List<MahkemeDto> dto = new ArrayList<>();
        for(MahkemeEntity a : ent)
            dto.add(map.map(a,MahkemeDto.class));
        return dto;
    }
}
