package com.projects.birthweather.domain.birthdata;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Table(name="birthweather")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class BirthData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Given data
    private String name;
    private String city;
    private String country;
    private String date;

    // Changed data
    private String latitude;
    private String longitude;

    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<Double> precipitation;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<Integer> cloud;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<Integer> humidity;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<Double> temperature;


    public BirthData(BirthDataRequestDTO data) {
        this.name = data.name();
        this.date = data.date();
        this.city = data.city();
        this.country = data.country();
    }

}
