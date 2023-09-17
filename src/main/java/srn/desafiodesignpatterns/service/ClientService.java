package srn.desafiodesignpatterns.service;

import srn.desafiodesignpatterns.model.Client;
import java.util.Optional;

public interface ClientService {
    Iterable<Client> getAll();
    Optional<Client> findById(Long id);
    void save(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
