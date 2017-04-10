package org.datacase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月10日
 * @Version v1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;
    private String name;
    private String address;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
