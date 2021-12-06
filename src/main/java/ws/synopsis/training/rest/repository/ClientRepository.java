package ws.synopsis.training.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.synopsis.training.rest.model.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Optional<Client> findByPhone(Integer phone);
}
