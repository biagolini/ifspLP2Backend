package br.edu.ifsp.spo.clientdataprocessor.repository.specifications;

import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import br.edu.ifsp.spo.clientdataprocessor.entity.User_;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    // usuários ativos
    public static Specification<User> isActive() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isTrue(root.get(User_.isActive));
    }

    // idLocationType
    public static Specification<User> idLocationTypedEquals(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(User_.idLocationType), info);
    }

    // idRegionType
    public static Specification<User> idRegionTypeEquals(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(User_.idRegionType), info);
    }

    // latitudeMax
    public static Specification<User> latitudeMaxLessThan(Double info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get(User_.latitude), info);
    }

    // latitudeMin
    public static Specification<User> latitudeMinGreaterThan(Double info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(User_.latitude), info);
    }


    // longitudeMax
    public static Specification<User> longitudeMaxLessThan(Double info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get(User_.latitude), info);
    }

    // longitudeMin
    public static Specification<User> longitudeGreaterThan(Double info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(User_.latitude), info);
    }

    // Search in email, firstName or lastName
    public static Specification<User> searchInEmailNameSurname(String info) {
        return (root, query, criteriaBuilder) -> {
            Predicate emailLike = criteriaBuilder.like(root.get(User_.email), "%" + info + "%");
            Predicate firstNameLike = criteriaBuilder.like(root.get(User_.firstName), "%" + info + "%");
            Predicate lastNameLike = criteriaBuilder.like(root.get(User_.lastName), "%" + info + "%");
            return criteriaBuilder.or(emailLike, firstNameLike, lastNameLike);
        };
    }


    public static Specification<User> likeGenericQuery(String queryString, Long idLocationType, Long idRegionType, Double latitudeMax, Double latitudeMin, Double longitudeMax, Double longitudeMin) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            // Pesquisa por email, firstName ou lastName
            if (queryString != null) {
                predicates.add(searchInEmailNameSurname(queryString).toPredicate(root, query, criteriaBuilder));
            }
            // Filtra tipo de localização igual valor especificado
            if (idLocationType != null) predicates.add(idLocationTypedEquals(idLocationType).toPredicate(root, query, criteriaBuilder));
            // Filtra tipo de região igual valor especificado
            if (idRegionType != null) predicates.add(idRegionTypeEquals(idRegionType).toPredicate(root, query, criteriaBuilder));
            // Filtra latitude máxima menor que o valor especificado
            if (latitudeMax != null) predicates.add(latitudeMaxLessThan(latitudeMax).toPredicate(root, query, criteriaBuilder));
            // Filtra latitude mínima maior que o valor especificado
            if (latitudeMin != null) predicates.add(latitudeMinGreaterThan(latitudeMin).toPredicate(root, query, criteriaBuilder));
            // Filtra longitude máxima menor que o valor especificado
            if (longitudeMax != null) predicates.add(longitudeMaxLessThan(longitudeMax).toPredicate(root, query, criteriaBuilder));
            // Filtra longitude mínima maior que o valor especificado
            if (longitudeMin != null) predicates.add(longitudeGreaterThan(longitudeMin).toPredicate(root, query, criteriaBuilder));
            // Aceita apenas dados de usuários ativos
            predicates.add(isActive().toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }


}
