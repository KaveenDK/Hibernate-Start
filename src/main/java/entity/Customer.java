package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data // Lombok annotation to generate Getters, Setters, toString, equals, and hashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity //map to table in database
@Table(name = "customer") //table name in database
public class Customer {
    @Id //Primary key
    private int id;
    private String name;
    private String email;
}
