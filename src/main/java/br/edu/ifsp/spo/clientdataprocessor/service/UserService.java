package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.dto.UserDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.UserForm;
import br.edu.ifsp.spo.clientdataprocessor.dto.WrapperForm;
import br.edu.ifsp.spo.clientdataprocessor.dto.enumeration.TypeLocationDto;
import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import br.edu.ifsp.spo.clientdataprocessor.entity.Picture;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeGender;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeLocation;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeState;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeTimeZone;
import br.edu.ifsp.spo.clientdataprocessor.repository.PhoneNumberRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.PictureRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.UserRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.enumeration.*;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.UserSpecification;
import br.edu.ifsp.spo.clientdataprocessor.util.PhoneNumberUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.Normalizer;
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PictureRepository pictureRepository;

    private final PhoneNumberRepository phoneNumberRepository;

    private final TypePhoneNationalityRepository typePhoneNationalityRepository;

    private final TypeGenderRepository typeGenderRepository;

    private final TypeLocationRepository typeLocationRepository;

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
        Long idLocationType = this.resolveLocationType(form.getLatitude(),  form.getLongitude());
        User newRegister = new User(form, typeState, idLocationType);
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
        Long idLocationType = this.resolveLocationType(form.getLatitude(),  form.getLongitude());
        user.update(form,typeState, idLocationType);
        userRepository.save(user);
    }


    public void createUserByJson(List<WrapperForm> form) {
        for (WrapperForm item : form) {
            // Criar usuario
            // Dados
            String title = item.getName().title;
            String firstName = item.getName().first;
            String lastName = item.getName().last;
            String street = item.getLocation().street;
            String city = item.getLocation().city;
            String postcode = item.getLocation().postcode;
            String nationality = item.getNationality();
            Double latitude = null;
            Double longitude = null;
            try {
                latitude = Double.parseDouble(item.getLocation().coordinates.latitude);
                longitude = Double.parseDouble(item.getLocation().coordinates.longitude);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao ler dados de Latidute/Longitude");
            }
            String email = item.getEmail();
            LocalDateTime birthday = LocalDateTime.from(item.getDob().date);
            LocalDateTime registered = LocalDateTime.from(item.getRegistered().date);

            // Chaves estrangeiras e objetos a serem resolvidos
            Long idTypeGender = null;
            Long idLocationType = null;
            Long idTypeTimezone = null;
            TypeState typeState = null;

            // Resolução genero
            System.out.println("Buscando gênero = " + item.getGender());
            // Mapeando strings para um formato uniforme
            String genderDescription = item.getGender();
            if (genderDescription.equalsIgnoreCase("Male")) {
                genderDescription = "M";
            } else if (genderDescription.equalsIgnoreCase("Female")) {
                genderDescription = "F";
            }
            Optional<TypeGender> typeGender = this.typeGenderRepository.findByDescription(item.getGender());
            if(typeGender.isPresent()) {
                idTypeGender = typeGender.get().getId();
            } else {
                idTypeGender =  this.typeGenderRepository.findByDescription("Nao declarado").get().getId();
            }

            // Resolucao de tipo de localizacao
            System.out.println("Buscando latitude = " + latitude + " e longitude = " + longitude);
            idLocationType = this.resolveLocationType(latitude,  longitude);

            // Resolução estado
            System.out.println("Buscando estado = " + item.getLocation().state);

            String descricaoEstado = item.getLocation().state;
            String estadoSemAcentos = removerCaracteresEspeciais(descricaoEstado);
            String estadoEmIngles = traduzirCaracteresEspeciais(estadoSemAcentos);

            Optional<TypeState> optionalTypeState = this.typeStateRepository.findByDescription(item.getLocation().state);
            if (optionalTypeState.isPresent()) {
                typeState = optionalTypeState.get();
            } else if ((optionalTypeState = this.typeStateRepository.findByDescription(estadoSemAcentos)).isPresent()) {
                typeState = optionalTypeState.get();
            } else if ((optionalTypeState = this.typeStateRepository.findByDescription(estadoEmIngles)).isPresent()) {
                typeState = optionalTypeState.get();
            } else {
                typeState = this.typeStateRepository.findByDescription("Nao declarado").get();
            }

            // Resolucao de TimeZone
            try {
                // Resolucao de TimeZone
                String offset = item.location.timezone.offset;

                // Substituindo o possivel sinal negativo para facilitar o parseamento
                offset = offset.replace("-", "");

                // Split em horas e minutos
                String[] offsetParts = offset.split(":");
                int hours = Integer.parseInt(offsetParts[0]);
                int minutes = Integer.parseInt(offsetParts[1]);

                // Checagem se o offset está dentro do range permitido
                if (hours < 0 || hours > 12 || minutes < 0 || minutes > 59) {
                    throw new DateTimeParseException("Offset fora do range permitido", offset, 0);
                }

                System.out.println("Buscando Timezone offset = " + item.location.timezone.offset + " e  description = " + item.location.timezone.description);
                Optional<TypeTimeZone> typeTimezone = this.typeTimeZoneRepository.findByTimeZoneOffset(item.location.timezone.offset);
                if(typeTimezone.isPresent()) {
                    idTypeTimezone = typeTimezone.get().getId();
                } else {
                    typeTimezone = this.typeTimeZoneRepository.findByTimezoneDescription(item.location.timezone.description);

                    if(typeTimezone.isEmpty()) {
                        idTypeTimezone =  this.typeTimeZoneRepository.findByTimezoneDescription("Nao declarado").get().getId();
                    }
                }
            } catch (DateTimeParseException e) {
                System.out.println("Offset inválido. Definindo para nulo.");
                item.location.timezone.offset = null;
            }
            // Salvar/atualizar usuario
            Optional<User> conflictTestEmail = userRepository.findByEmail(item.getEmail());
            User user = new User();
            if(conflictTestEmail.isPresent() ) {
                // Fazer update
                user = conflictTestEmail.get();
                if (idTypeGender != null ) user.setIdTypeGender(idTypeGender);
                if (title != null ) user.setTitle(title);
                if (firstName != null ) user.setFirstName(firstName);
                if (lastName != null ) user.setLastName(lastName);
                if (idLocationType != null ) user.setIdLocationType(idLocationType);
                if (street != null ) user.setStreet(street);
                if (city != null ) user.setCity(city);
                if (typeState != null ) user.setTypeState(typeState);
                if (postcode != null ) user.setPostcode(postcode);
                if (latitude != null ) user.setLatitude(latitude);
                if (longitude != null ) user.setLongitude(longitude);
                if (idTypeTimezone != null ) user.setIdTypeTimezone(idTypeTimezone);
                if (birthday != null ) user.setBirthday(birthday);
                if (registered != null ) user.setRegistered(registered);
                System.out.println("USER " + conflictTestEmail.get() + "WAS UPDATED");
            } else {
                user = new User(idTypeGender,  title,  firstName,  lastName,  idLocationType,  street,  city,  typeState,  postcode, latitude, longitude,  idTypeTimezone,  email,  birthday,  registered);
            }

            userRepository.save(user);

            // Postar imagem (se existente)
            if(item.getPicture().large != null || item.getPicture().medium != null || item.getPicture().thumbnail != null ){
                Picture newRegister = new Picture(user,  item.getPicture().large, item.getPicture().medium, item.getPicture().thumbnail );
                pictureRepository.save(newRegister);
            }

            // Postar telefone (se existente)
            if(item.getPhone() != null ) {
                PhoneNumberUtil formattedPhone = new PhoneNumberUtil(this.typePhoneNationalityRepository, item.getPhone(), nationality );
                PhoneNumber newPhoneFixo = new PhoneNumber(user,  formattedPhone.getPhoneNumber() , 1L, formattedPhone.getIdPhoneNumberNationality());
                phoneNumberRepository.save(newPhoneFixo);
            }
            if(item.getCell() != null ) {
                PhoneNumberUtil formattedPhone = new PhoneNumberUtil(this.typePhoneNationalityRepository, item.getPhone(), nationality );
                PhoneNumber newPhoneMovel = new PhoneNumber(user,  formattedPhone.getPhoneNumber()  , 2L, formattedPhone.getIdPhoneNumberNationality());
                phoneNumberRepository.save(newPhoneMovel);
            }
        }
    }

    public Long resolveLocationType(Double latitude, Double longitude){
        Long idLocationType = null;
        if(latitude != null && longitude != null) {
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
        return idLocationType;
    }

    public void createCustomerByCsv(MultipartFile file) throws IOException, RuntimeException {
        List<WrapperForm> form = new ArrayList<>();
        try (Reader reader = new InputStreamReader(file.getInputStream(), "ISO-8859-1");
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim());) {

            for (CSVRecord record : csvParser) {
                try {
                    WrapperForm item = new WrapperForm(record);
                    form.add(item);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Erro ao processar registro CSV: " + e.getMessage(), e);
                }
            }
        }
        this.createUserByJson(form);
    }


    public TypeLocationDto resolveLocation(Double latitude, Double longitude) {
        TypeLocation typeLocation = new TypeLocation();
        if(latitude != null && longitude != null) {
            if(latitude < -34.276938 && latitude > -46.361899  && longitude < -2.196998 &&  longitude > -15.411580) {
                //ESPECIAL
                // Latitude  (NS) vai de -34.276938 ate -46.361899
                // Longitude (LO) vai de -02.196998 ate -15.411580
                System.out.println("Resolução 01 - especial");
                typeLocation =  this.typeLocationRepository.findByDescription("Especial").get();

            } else if(latitude < -44.428305 && latitude > -52.997614 && longitude < -19.766959 && longitude >  -23.966413) {
                //ESPECIAL
                // Latitude  (NS) vai de -44.428305 ate -52.997614
                // Longitude (LO) vai de -19.766959 ate -23.966413
                System.out.println("Resolução 02 - especial");
                typeLocation =  this.typeLocationRepository.findByDescription("Especial").get();
            } else if(latitude < -46.603598 && latitude > -54.777426 &&  longitude < -26.155681 && longitude < -34.016466) {
                // NORMAL
                // Latitude  (NS) vai de -46.603598 ate -54.777426
                // Longitude (LO) vai de -26.155681 ate -34.016466
                System.out.println("Resolução 03 - normal");
                typeLocation =  this.typeLocationRepository.findByDescription("Normal").get();
            } else {
                // TRABALHOSO
                // Latitude  (NS) vai de -44.428305 ate -52.997614
                // Longitude (LO) vai de -19.766959 ate -23.966413
                System.out.println("Resolução 04 - trabahoso");
                typeLocation =  this.typeLocationRepository.findByDescription("Trabalhoso").get();
            }
        }
        TypeLocationDto response = new TypeLocationDto(typeLocation);
        return response;
    }

    public static String removerCaracteresEspeciais(String input) {
        String semAcentos = Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        String semCaracteresEspeciais = semAcentos
                .replaceAll("[^\\p{Alnum}]+", "_")
                .replaceAll("_+", "_")
                .replaceAll("^_|_$", "");

        String lowercase = semCaracteresEspeciais.toLowerCase();

        return lowercase;
    }

    public static String traduzirCaracteresEspeciais(String input) {
        // Mapear caracteres especiais para caracteres equivalentes em inglês
        String traducao = input
                .replaceAll("á", "a")
                .replaceAll("à", "a")
                .replaceAll("ã", "a")
                .replaceAll("â", "a")
                .replaceAll("é", "e")
                .replaceAll("ê", "e")
                .replaceAll("í", "i")
                .replaceAll("ó", "o")
                .replaceAll("ô", "o")
                .replaceAll("õ", "o")
                .replaceAll("ú", "u")
                .replaceAll("ü", "u")
                .replaceAll("ç", "c");

        return traducao;
    }
}
