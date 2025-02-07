package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok annotations
@Data // Lombok annotation to generate Getters, Setters, toString, equals, and hashCode
@AllArgsConstructor
@NoArgsConstructor

//JPA annotations
@Entity //map to table in database
@Table(name = "customer") //table name in database

public class Customer {
    @Id //Primary key
    private int id;
    private String name;
    private String email;
}
