package tr.com.cinigaz.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.MalBilgisiDto;
import tr.com.cinigaz.entity.MalBilgisiEntity;
import tr.com.cinigaz.repo.MalBilgisiRepository;
import tr.com.cinigaz.service.MalBilgisiService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class MalBilgisiImpl implements MalBilgisiService {

    private ModelMapper map;
    private MalBilgisiRepository repository;

    public MalBilgisiImpl(ModelMapper map, MalBilgisiRepository repository) {
        this.map = map;
        this.repository = repository;
    }

    @Override
    public MalBilgisiDto save(MalBilgisiDto dto) {
        MalBilgisiEntity gelen = map.map(dto,MalBilgisiEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("hus");
        gelen=repository.save(gelen);
        map.map(gelen,dto);
        return dto;

    }

    @Override
    public MalBilgisiDto update(MalBilgisiDto dto) {
        MalBilgisiEntity gelen = map.map(dto,MalBilgisiEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("hus");
        gelen=repository.save(gelen);
        map.map(gelen,dto);
        return dto;
    }

    @Override
    public Boolean delete(MalBilgisiDto dto) {
        MalBilgisiEntity gelen = map.map(dto,MalBilgisiEntity.class);
        try {
            repository.delete(gelen);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MalBilgisiDto getById(Long id) {
        Optional<MalBilgisiEntity> opt = repository.findById(id);
        MalBilgisiDto dto =new MalBilgisiDto();
        map.map(dto,opt.get());
        return dto;
    }

    @Override
    public List<MalBilgisiDto> getAll() {
        List<MalBilgisiEntity> ent = repository.findAll();
        List<MalBilgisiDto> dto = new ArrayList<>();
        for (MalBilgisiEntity a : ent){
         dto.add(map.map(a,MalBilgisiDto.class));
        }
        return dto;
    }
}
