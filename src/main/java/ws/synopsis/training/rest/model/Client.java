package ws.synopsis.training.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CLIENT")
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId")
    private Long idClient;

    @Column(name = "clientName")
    private String name;

    @Column(name = "clientLastName")
    private String lastName;

    @Column(name = "clientPhone", unique = true)
    private Integer phone;
}
