package com.example.NettPotek;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "costumer")
public class  Costumer{

    @Id
    @GeneratedValue

    private long id ;
    private String name ;
    private String lastname ;
    private String telephone ;

    public Costumer() {
    }

    public Costumer(String name, String lastname, String telephone) {
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
    }
}


