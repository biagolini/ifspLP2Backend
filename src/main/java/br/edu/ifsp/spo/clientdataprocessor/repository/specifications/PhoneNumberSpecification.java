package br.edu.ifsp.spo.clientdataprocessor.repository.specifications;

import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber_;
import br.edu.ifsp.spo.clientdataprocessor.entity.User_;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class PhoneNumberSpecification {

    // usuários ativos
    public static Specification<PhoneNumber> isActive() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isTrue(root.get(PhoneNumber_.isActive));
    }

    // phoneNumberType
    public static Specification<PhoneNumber> phoneNumberTypeEquals(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(PhoneNumber_.idPhoneNumberType), info);
    }

    // userId
    public static Specification<PhoneNumber> userIdEquals(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(PhoneNumber_.user).get(User_.id), info);
    }

    // email
    public static Specification<PhoneNumber> emailEquals(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(PhoneNumber_.user).get(User_.email), "%" + info + "%");
    }


    public static Specification<PhoneNumber> likeGenericQuery(String queryString, Long idPhoneNumberType, Long userId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(4);
            // Pesquisa por email
            if (queryString != null) predicates.add(emailEquals(queryString).toPredicate(root, query, criteriaBuilder));
            // Se houver dado de perfil, busca pelo perfil
            if (idPhoneNumberType != null)
                predicates.add(phoneNumberTypeEquals(idPhoneNumberType).toPredicate(root, query, criteriaBuilder));
            if (userId != null)
                predicates.add(userIdEquals(userId).toPredicate(root, query, criteriaBuilder));
            // Aceita apenas dados de usuários ativos
            predicates.add(criteriaBuilder.isTrue(root.get(PhoneNumber_.isActive)));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
