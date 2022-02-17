package tr.com.cinigaz.service.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import tr.com.cinigaz.dto.AvukatDto;
import tr.com.cinigaz.dto.BorcDto;
import tr.com.cinigaz.dto.DosyaMevzuatDto;
import tr.com.cinigaz.entity.AvukatEntity;
import tr.com.cinigaz.entity.BorcEntity;
import tr.com.cinigaz.entity.DosyaMevzuatEntity;
import tr.com.cinigaz.exception.NotFound;
import tr.com.cinigaz.repo.DosyaMevzuatRepository;
import tr.com.cinigaz.service.DosyaMevzuatService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DosyaMevzuatServiceImpl implements DosyaMevzuatService {

    private DosyaMevzuatRepository dosyaMevzuatRepository;
    private ModelMapper modelMapper;

    public DosyaMevzuatServiceImpl(DosyaMevzuatRepository dosyaMevzuatRepository,ModelMapper modelMapper)
    {
        this.dosyaMevzuatRepository=dosyaMevzuatRepository;
        this.modelMapper=modelMapper;

    }

    @Override
    public DosyaMevzuatDto dosyaMevzuatEkle(DosyaMevzuatDto dosyaMevzuatDto) {
        DosyaMevzuatEntity dosyaMevzuatEntity=modelMapper.map(dosyaMevzuatDto,DosyaMevzuatEntity.class);
        dosyaMevzuatEntity.setCreatedAt(new Date());
        dosyaMevzuatEntity.setCreatedBy("yagmur");
        dosyaMevzuatEntity=dosyaMevzuatRepository.save(dosyaMevzuatEntity);
        dosyaMevzuatDto=modelMapper.map(dosyaMevzuatEntity,DosyaMevzuatDto.class);
        return dosyaMevzuatDto;
    }

    @Override
    public List<DosyaMevzuatDto> dosyaMevzuatGetir() {
        List<DosyaMevzuatEntity> dosyaMevzuatEntities=dosyaMevzuatRepository.findAll();
        List<DosyaMevzuatDto> dtos = dosyaMevzuatEntities.stream().map(dosyamevzuatentity -> modelMapper.map(dosyamevzuatentity, DosyaMevzuatDto.class)).collect(Collectors.toList());
        return dtos;
    }


    @Override
    public DosyaMevzuatDto dosyaMevzuatGuncelle(DosyaMevzuatDto dosyaMevzuatDto) {
        DosyaMevzuatEntity dosyamevzuat = modelMapper.map(dosyaMevzuatDto, DosyaMevzuatEntity.class);
        dosyamevzuat.setUpdatedBy("yağmur");
        dosyamevzuat.setUpdatedAt(new Date());
        dosyamevzuat = dosyaMevzuatRepository.save(dosyamevzuat);
        dosyaMevzuatDto = modelMapper.map(dosyamevzuat, DosyaMevzuatDto.class);
        return dosyaMevzuatDto;
    }


//    @Override
//    public DosyaMevzuatDto dosyaMevzuatGuncelle(Long dosyaMevzuatId, DosyaMevzuatDto dosyamevzuatdto) {
//        Optional<DosyaMevzuatEntity> dosyamevzuat = dosyaMevzuatRepository.findById(dosyaMevzuatId);
//        if (dosyamevzuat.isPresent()) {
//            dosyamevzuat.get().setTakipBasvuruHarc(dosyamevzuatdto.getTakipBasvuruHarc());
//            dosyamevzuat.get().setTakipPesinHarc(dosyamevzuatdto.getTakipPesinHarc());
//            dosyamevzuat.get().setUpdatedAt(new Date());
//            dosyamevzuat.get().setUpdatedBy("yağmur");
//            dosyamevzuatdto=modelMapper.map(dosyaMevzuatRepository.save(dosyamevzuat.get()), DosyaMevzuatDto.class);
//            return dosyamevzuatdto;
//        }
//        throw new NotFound("Hizmet Türü Bulunamadı");
//    }

    @Override
    public Boolean dosyaMevzuatSil(DosyaMevzuatDto dosyaMevzuatDto) {
        DosyaMevzuatEntity gelen = modelMapper.map(dosyaMevzuatDto, DosyaMevzuatEntity.class);
        try {
            dosyaMevzuatRepository.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public DosyaMevzuatDto dosyaMevzuatGetirId(Long dosyaMevzuatId) {
        Optional<DosyaMevzuatEntity> dosyamevzuat = dosyaMevzuatRepository.findById(dosyaMevzuatId);
        if (dosyamevzuat.isPresent()) {
            return modelMapper.map(dosyamevzuat .get(), DosyaMevzuatDto.class);
        }
        throw new NotFound("Hizmet Türü Bulunamadı");
    }



}
