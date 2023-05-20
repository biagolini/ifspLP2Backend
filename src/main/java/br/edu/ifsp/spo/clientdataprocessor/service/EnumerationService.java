package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.dto.enumeration.*;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.*;
import br.edu.ifsp.spo.clientdataprocessor.repository.enumeration.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EnumerationService {

    private final TypeGenderRepository typeGenderRepository;
    private final TypeLocationRepository typeLocationRepository;
    private final TypeLoginRepository typeLoginRepository;
    private final TypeNationalityRepository typeNationalityRepository;
    private final TypePhoneNumberRepository typePhoneNumberRepository;
    private final TypeRegionRepository  typeRegionRepository;
    private final TypeStateRepository  typeStateRepository;
    private final TypeTimeZoneRepository typeTimeZoneRepository;

    public List<TypeGenderDto> getGender(){
        List<TypeGender> listTypes = typeGenderRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypeGenderDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypeGenderDto(listTypes.get(i) ));
        }
        return listReturn;
    }

    public List<TypeLocationDto> getLocation(){
        List<TypeLocation> listTypes = typeLocationRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypeLocationDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypeLocationDto(listTypes.get(i) ));
        }
        return listReturn;
    }


    public List<TypeLoginDto> getLogin(){
        List<TypeLogin> listTypes = typeLoginRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypeLoginDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypeLoginDto(listTypes.get(i) ));
        }
        return listReturn;
    }

    public List<TypeNationalityDto> getNationality(){
        List<TypeNationality> listTypes = typeNationalityRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypeNationalityDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypeNationalityDto(listTypes.get(i) ));
        }
        return listReturn;
    }

    public List<TypePhoneNumberDto> getPhoneNumber(){
        List<TypePhoneNumber> listTypes = typePhoneNumberRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypePhoneNumberDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypePhoneNumberDto(listTypes.get(i) ));
        }
        return listReturn;
    }

    public List<TypeRegionDto> getRegion(){
        List<TypeRegion> listTypes = typeRegionRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypeRegionDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypeRegionDto(listTypes.get(i) ));
        }
        return listReturn;
    }


    public List<TypeStateDto> getState(){
        List<TypeState> listTypes = typeStateRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypeStateDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypeStateDto(listTypes.get(i) ));
        }
        return listReturn;
    }

    public List<TypeTimeZoneDto> getTimeZone(){
        List<TypeTimeZone> listTypes = typeTimeZoneRepository.findAll();
        if(listTypes.size()==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<TypeTimeZoneDto> listReturn = new ArrayList<>();
        for (int i = 0; i < listTypes.size(); i++) {
            listReturn.add(new TypeTimeZoneDto(listTypes.get(i) ));
        }
        return listReturn;
    }

}
