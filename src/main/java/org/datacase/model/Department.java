package org.datacase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="department", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    private Set<Employee> employees = new HashSet<Employee>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
