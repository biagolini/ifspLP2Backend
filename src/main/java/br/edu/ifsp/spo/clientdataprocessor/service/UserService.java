package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.dto.UserDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.UserForm;
import br.edu.ifsp.spo.clientdataprocessor.dto.WrapperForm;
import br.edu.ifsp.spo.clientdataprocessor.entity.Picture;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeGender;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeState;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeTimeZone;
import br.edu.ifsp.spo.clientdataprocessor.repository.PictureRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.UserRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.enumeration.*;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.UserSpecification;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PictureRepository pictureRepository;

    private final TypeGenderRepository typeGenderRepository;

    private final TypeLocationRepository typeLocationRepository;

    private final TypePhoneNumberRepository typePhoneNumberRepository;

    private final TypeRegionRepository typeRegionRepository;

   private final TypeStateRepository typeStateRepository;

    private final TypeTimeZoneRepository typeTimeZoneRepository;

    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(UserSpecification.isActive(), pageable);
    }

    public Page<User> findAll(Pageable pageable, String query, Long idLocationType, Long idRegionType, Double latitudeMax, Double latitudeMin, Double longitudeMax, Double longitudeMin) {
        return this.userRepository.findAll(UserSpecification.likeGenericQuery(query,  idLocationType, idRegionType,  latitudeMax,  latitudeMin,  longitudeMax,  longitudeMin), pageable);
    }

    public Page<UserDto> fillMissingDtoData(Page<UserDto> givenPage) {
        for(UserDto item: givenPage.getContent()){
            User user = userRepository.findById(item.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            List<Picture> pictureList = pictureRepository.findByUser(user);
            if (!pictureList.isEmpty()) {
                Picture lastPicture = pictureList.get(pictureList.size() - 1);
                item.setThumbnailUrl(lastPicture.getLargeUrl());
            }
        }
        return givenPage;
    }

    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        UserDto response = new UserDto(user);
        return  response;
    }

    public void createUser(UserForm form) {
        Optional<User> conflictTestEmail = userRepository.findByEmail(form.getEmail());
        if(conflictTestEmail.isPresent() ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        TypeState typeState = typeStateRepository.findById(form.getIdTypeState()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        User newRegister = new User(form, typeState);
        userRepository.save(newRegister);
    }

    public void inactiveUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setIsActive(false);
        userRepository.save(user);
    }

    public void updateUser(Long id, UserForm form) {
        Optional <User> conflict = userRepository.findConflict(form.getEmail(),id);
        if(conflict.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        TypeState typeState = typeStateRepository.findById(form.getIdTypeState()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        user.update(form,typeState);
        userRepository.save(user);
    }


    public void createUserByJson(List<WrapperForm> form) {
        for (WrapperForm item : form) {
            // Criar usuario
            // Chave estrangeira
            Long idTypeGender = null;
            Long idLocationType = null;
            TypeState typeState = null;
            Long idTypeTimezone = null;
            // Dados
            String title = item.getName().title;
            String firstName = item.getName().first;
            String lastName = item.getName().last;
            String street = item.getLocation().street;
            String city = item.getLocation().city;
            String postcode = item.getLocation().postcode;
            Double latitude = null;
            Double longitude = null;
            try {
                latitude = Double.parseDouble(item.getLocation().coordinates.latitude);
                longitude = Double.parseDouble(item.getLocation().coordinates.longitude);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao ler dados de Latidute/Longitude");
            }
            String email = item.getEmail();
            LocalDateTime birthday = item.getDob().date;
            LocalDateTime registered = item.getRegistered().date;

            // Resolução genero
            System.out.println("Buscando por gênero: " + item.getGender());
            Optional<TypeGender> typeGender = this.typeGenderRepository.findByDescription(item.getGender());
            if(typeGender.isPresent()) {
                idTypeGender = typeGender.get().getId();
            } else {
                idTypeGender =  this.typeGenderRepository.findByDescription("Nao declarado").get().getId();
            }
            // Resolucao de tipo de localizacao
            System.out.println("Buscando por latitude e longitude: " + latitude + longitude);
            if(latitude == null && longitude == null) {
                if(latitude > -46.361899 && latitude < -34.276938 && longitude < -2.196998 && longitude <  -15.411580  ) {
                    //ESPECIAL
                    idLocationType =  this.typeLocationRepository.findByDescription("Especial").get().getId();
                } else if(latitude > -52.997614 && latitude < -44.428305 && longitude < -19.766959 && longitude <  -23.966413  ) {
                    //ESPECIAL
                    idLocationType =  this.typeLocationRepository.findByDescription("Especial").get().getId();
                } else if(latitude > -54.777426 && latitude < -46.603598 && longitude < -26.155681 && longitude < -34.016466  ) {
                    // NORMAL
                    idLocationType =  this.typeLocationRepository.findByDescription("Normal").get().getId();
                } else {
                    // TRABALHOSO
                    idLocationType =  this.typeLocationRepository.findByDescription("Trabalhoso").get().getId();
                }
            }
            // --------------------------------

            /* 
            // Resolucao de estado
            System.out.println("Buscando por estado: " + item.location.state);
            Optional<TypeState> typeState = this.typeStateRepository.findByDescription(item.location.state);
            if(typeGender.isPresent()) {
                idTypeState = typeGender.get().getId();
            } else {
                idTypeState =  this.typeGenderRepository.findByDescription("Nao declarado").get().getId();
            }
*/
            // Resolucao de TimeZone
            System.out.println("Buscando por TimeZone: " + item.location.timezone.offset + item.location.timezone.description);
            Optional<TypeTimeZone> typeTimezone = this.typeTimeZoneRepository.findByTimeZoneOffset(item.location.timezone.offset);
            if(typeTimezone.isPresent()) {
                idTypeTimezone = typeTimezone.get().getId();
            } else {
                typeTimezone = this.typeTimeZoneRepository.findByTimezoneDescription(item.location.timezone.description);

                if(typeTimezone.isEmpty()) {
                    idTypeTimezone =  this.typeTimeZoneRepository.findByTimezoneDescription("Nao declarado").get().getId();
                }
            }


            // Salvar usuario novo
            User user = new User(idTypeGender,  title,  firstName,  lastName,  idLocationType,  street,  city,  typeState,  postcode, latitude, longitude,  idTypeTimezone,  email,  birthday,  registered);
            userRepository.save(user);
                // Postar imagem (se existente)
//            Picture newRegister = new Picture(user, form);
//            pictureRepository.save(newRegister);
//
//            // Postar telefone (se existente)
//            PhoneNumber newRegister = new PhoneNumber(user, form);
//            phoneNumberRepository.save(newRegister);

        }
    }

    public void createCustomerByCsv(List<WrapperForm> form) {
        System.out.println(form);
    }



}
