package models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")//para que en BD se guarde como users, y que "user" suele ser una palabra reservada
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)//con esto le decimos a la BD que genere ella la id (tipo identity)
private Long id;

@NotBlank
private String name;

@Email
private String mail;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<Event> events = new HashSet<>();//prohibe que hayan repetidos y borrar un evento no afectara a los demas

    public void addEvent(Event event) {
        this.events.add(event);
        event.setUser(this);
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
        event.setUser(null);
    }
}
