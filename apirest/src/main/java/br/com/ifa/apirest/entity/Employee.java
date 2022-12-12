package br.com.ifa.apirest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
//import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity


public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    //@CreatedDate
   //@GeneratedValue(strategy = GenerationType.AUTO)
   //private Date data;
   ////private Date
}
