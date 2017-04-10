package org.datacase.repository;

import org.datacase.model.City;
import org.datacase.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月10日
 * @Version v1.0
 */
public interface HotelDao extends JpaRepository<Hotel, Long> {
}
