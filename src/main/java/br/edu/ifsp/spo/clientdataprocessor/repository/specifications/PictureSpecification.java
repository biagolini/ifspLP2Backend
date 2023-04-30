package br.edu.ifsp.spo.clientdataprocessor.repository.specifications;

import br.edu.ifsp.spo.clientdataprocessor.entity.*;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PictureSpecification {

    // usuários ativos
    public static Specification<Picture> isActive() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isTrue(root.get(Picture_.isActive));
    }

    // userId
    public static Specification<Picture> userIdEquals(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Picture_.user).get(User_.id), info);
    }

    // email
    public static Specification<Picture> emailEquals(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Picture_.user).get(User_.email), "%" + info + "%");
    }


    public static Specification<Picture> likeGenericQuery(String queryString, Long userId) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(3);
            // Pesquisa por email
            if (queryString != null) predicates.add(emailEquals(queryString).toPredicate(root, query, criteriaBuilder));
            // Se houver dado de perfil, busca pelo perfil
            if (userId != null)
                predicates.add(userIdEquals(userId).toPredicate(root, query, criteriaBuilder));
            // Aceita apenas dados de usuários ativos
            predicates.add(criteriaBuilder.isTrue(root.get(Picture_.isActive)));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
