package br.edu.ifsp.spo.clientdataprocessor.util;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypePhoneNationality;
import br.edu.ifsp.spo.clientdataprocessor.repository.enumeration.TypePhoneNationalityRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class PhoneNumberUtil {

    private String phoneNumber;

    private Long idPhoneNumberNationality;

    private final TypePhoneNationalityRepository typePhoneNationalityRepository;

    // Constructor
    public PhoneNumberUtil(TypePhoneNationalityRepository typePhoneNationalityRepository, String phoneNumber, String description) {
        this.typePhoneNationalityRepository = typePhoneNationalityRepository;

        // If phoneNumber is an empty string, we set phoneNumber and idPhoneNumberNationality to their default values
        if (phoneNumber.equals("")) {
            this.phoneNumber = "";
            this.idPhoneNumberNationality = null; // or some default value when phoneNumber is ""
        } else {
            String countryCode = "";

            // Remove non-numeric characters from the phone number
            String onlyNumbers = phoneNumber.replaceAll("\\D+","");

            Optional<TypePhoneNationality> optionalTypePhoneNationality;

            // Based on description value, we fetch data from typePhoneNationalityRepository
            if (description == null || description.equals("")) {
                optionalTypePhoneNationality = this.typePhoneNationalityRepository.findByCountryAbbreviation("Desconhecido");
            } else {
                optionalTypePhoneNationality = this.typePhoneNationalityRepository.findByCountryAbbreviation(description);

                if (!optionalTypePhoneNationality.isPresent()) {
                    optionalTypePhoneNationality = this.typePhoneNationalityRepository.findByCountryDescription(description);
                }

                if (!optionalTypePhoneNationality.isPresent()) {
                    optionalTypePhoneNationality = this.typePhoneNationalityRepository.findByCode(description);
                }
            }

            // If optionalTypePhoneNationality has a value, we extract the countryCode and idPhoneNumberNationality
            // Otherwise, we set them to the default "Desconhecido" values
            if(optionalTypePhoneNationality.isPresent()) {
                countryCode = optionalTypePhoneNationality.get().getCode();
                this.idPhoneNumberNationality = optionalTypePhoneNationality.get().getId();
            } else {
                Optional<TypePhoneNationality> optionalUnknown = this.typePhoneNationalityRepository.findByCountryAbbreviation("Desconhecido");
                if (optionalUnknown.isPresent()) {
                    countryCode = optionalUnknown.get().getCode();
                    this.idPhoneNumberNationality = optionalUnknown.get().getId();
                } else {
                    // Handle the case where there is no "Desconhecido" value present
                    // Maybe throw an exception, or set countryCode and idPhoneNumberNationality to some default value
                }
            }

            // Combine the countryCode with the remaining digits from the phoneNumber
            this.phoneNumber = countryCode + onlyNumbers;
        }
    }
}
