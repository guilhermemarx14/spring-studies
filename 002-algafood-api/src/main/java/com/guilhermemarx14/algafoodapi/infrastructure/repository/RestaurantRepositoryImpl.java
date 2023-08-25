package com.guilhermemarx14.algafoodapi.infrastructure.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import com.guilhermemarx14.algafoodapi.domain.repository.CustomRestaurantRepository;
import com.guilhermemarx14.algafoodapi.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.*;

import static com.guilhermemarx14.algafoodapi.infrastructure.repository.spec.RestarurantsSpec.*;

@Repository
public class RestaurantRepositoryImpl implements CustomRestaurantRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Lazy
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findByNameAndFreight(String name, BigDecimal freightRateBegin, BigDecimal freightRateEnd) {
        var jpql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        jpql.append("from Restaurant r where 0=0");

        if (StringUtils.hasLength(name)) {
            jpql.append(" and r.name like :name");
            params.put("name", "%" + name + "%");
        }

        if (!Objects.isNull(freightRateBegin)) {
            jpql.append(" and r.freightRate >= :freightRateBegin");
            params.put("freightRateBegin", freightRateBegin);
        }

        if (Objects.nonNull(freightRateEnd)) {
            jpql.append(" and r.freightRate <= :freightRateEnd");
            params.put("freightRateEnd", freightRateEnd);
        }

        var query = entityManager.createQuery(jpql.toString(), Restaurant.class);

        for (var entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

    public List<Restaurant> findCriteria(String name, BigDecimal freightRateBegin, BigDecimal freightRateEnd) {
        var predicates = new ArrayList<Predicate>();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);

        Root<Restaurant> root = criteria.from(Restaurant.class);

        if (StringUtils.hasLength(name)) {
            Predicate namePredicate = builder.like(root.get("name"), "%" + name + "%");
            predicates.add(namePredicate);
        }

        if (Objects.nonNull(freightRateBegin)) {
            Predicate freightRateBeginPredicate =
                    builder.greaterThanOrEqualTo(root.get("freightRate"), freightRateBegin);
            predicates.add(freightRateBeginPredicate);
        }

        if (Objects.nonNull(freightRateEnd)) {
            Predicate freightRateEndPredicate = builder.lessThanOrEqualTo(root.get("freightRate"), freightRateEnd);
            predicates.add(freightRateEndPredicate);
        }

        criteria.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Restaurant> typedQuery = entityManager.createQuery(criteria);

        return typedQuery.getResultList();


    }

    @Override
    public List<Restaurant> findByFreightNotZero(String name) {
        return restaurantRepository.findAll(freightRateNonZero().and(nameContaining(name)));
    }
}
