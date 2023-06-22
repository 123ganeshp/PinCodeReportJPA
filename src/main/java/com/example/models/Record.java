package com.example.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "records")
public class Record {
        @Id
        private String zipCode;
        private String placeName;
        private String country;
        private String stateCode;
        private String state;
        private String city;
        private String district;
        private String village;


}
