package tr.com.cinigaz.service.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.HacizDto;
import tr.com.cinigaz.entity.AvukatEntity;
import tr.com.cinigaz.entity.HacizEntity;
import tr.com.cinigaz.exception.NotFound;
import tr.com.cinigaz.repo.HacizRepository;
import tr.com.cinigaz.service.HacizService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Configuration

public class HacizServiceImpl implements HacizService {
    private HacizRepository hacizRepository;
    private ModelMapper modelMapper;

    public HacizServiceImpl(HacizRepository hacizRepository, ModelMapper modelMapper) {
        this.hacizRepository = hacizRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HacizDto hacizEkle(HacizDto hacizDto) {
        HacizEntity hacizEntity = modelMapper.map(hacizDto, HacizEntity.class);
        hacizEntity.setCreatedBy("yağmur"); // TODO : Yetki yapısında kulanıcı gelecek.
        hacizEntity.setCreatedAt(new Date());
        hacizEntity = hacizRepository.save(hacizEntity);
        hacizDto = modelMapper.map(hacizEntity, HacizDto.class);
        if (hacizDto.equals(hacizDto)) {
            return hacizDto;
        } else {
            return new HacizDto();
        }
    }

    @Override
    public HacizDto hacizGetirId(Long hacizId) {
        Optional<HacizEntity> hacizentity = hacizRepository.findById(hacizId);
        if (hacizentity.isPresent()) {
            return modelMapper.map(hacizentity.get(), HacizDto.class);
        }
        throw new NotFound("Haciz Bulunamadı");


    }

    @Override
    public HacizDto hacizGuncelle(HacizDto hacizdto) {
        HacizEntity gelen = modelMapper.map(hacizdto, HacizEntity.class);
        gelen.setUpdatedBy("yağmur");
        gelen.setUpdatedAt(new Date());
        gelen = hacizRepository.save(gelen);
        hacizdto = modelMapper.map(gelen, HacizDto.class);
        return hacizdto;
    }

    @Override
    public Boolean hacizSil(HacizDto hacizDto) {
        HacizEntity gelen = modelMapper.map(hacizDto, HacizEntity.class);
        try {
            hacizRepository.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<HacizDto> hacizGetir() {

        List<HacizEntity> hacizentities = hacizRepository.findAll();
        List<HacizDto> dtos = hacizentities.stream().map(hacizentity -> modelMapper.map(hacizentity, HacizDto.class)).collect(Collectors.toList());
        return dtos;
    }


}

