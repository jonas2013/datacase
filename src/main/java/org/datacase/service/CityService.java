package org.datacase.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.datacase.model.City;
import org.datacase.model.QCity;
import org.datacase.repository.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月10日
 * @Version v1.0
 */
@Service
public class CityService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CityDao cityDao;

    public List<City> findAll(String hotelName) {
        QCity cityEntity = QCity.city;
        JPAQuery<City> query = new JPAQuery<>(em);
        BooleanExpression express = cityEntity.state.eq("1");
        if (StringUtils.hasText(hotelName)) {
            express = express.and(cityEntity.hotels.any().name.likeIgnoreCase('%' + hotelName + '%'));
        }
        return query.select(cityEntity).from(cityEntity).where(express).fetch();
    }

    public List<City> findAll() {
        return cityDao.findAll();
    }
}
