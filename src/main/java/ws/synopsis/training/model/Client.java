package ws.synopsis.training.model;

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

    @Column(name = "clientName", length = 100)
    private String name;

    @Column(name = "clientLastName", length = 100)
    private String lastName;

    @Column(name = "clientPhone", unique = true)
    private Integer phone;

    @Column(name = "client_password")
    private String word;

}
