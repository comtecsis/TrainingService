package ws.synopsis.training.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.synopsis.training.model.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Optional<Client> findByPhone(Integer phone);
    public List<Client> findByLastName(String lastName);
    public List<Client> findByname(String name);
}
