package lk.ijse.hibernate.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok annotations
@Data // Lombok annotation to generate Getters, Setters, toString, equals, and hashCode
@AllArgsConstructor
@NoArgsConstructor

//JPA annotations
@Entity //map to table in database
@Table(name = "customer") //set database table name

public class Customer { //defualt table name is class name (customer)
    @Id //Primary key
    //@GeneratedValue(strategy = GenerationType.AUTO) //Auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY) //manual increment
    //@GeneratedValue(strategy = GenerationType.UUID) //create unique id
    private int id;
    private String name;

    @Column(name = "customerEmail", nullable = false) //set column name
    //nullable = false means this column cannot be null
    //nullable = true means this column can be null
    private String email;

    @Column(nullable = false)
    private int phone;

    @Transient //this field will not be saved in the database
    private String cardNumber;

    @Lob //Large data or binary data
    private String discription;

    //image - byte[] -> base64 encoded string

    @Embedded
    private CustomerFullName fullName;
}
