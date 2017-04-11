package org.datacase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月11日
 * @Version v1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
