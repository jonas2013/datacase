package org.datacase.repository;

import org.datacase.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author Js
 * @Date 2017年04月10日
 * @Version v1.0
 */
public interface CityDao extends JpaRepository<City, Long> {

}
