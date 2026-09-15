package api_teste.ds.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Importação da entidade User
import api_teste.api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Método de busca customizado por convenção do Spring Data JPA (Derived Query).
     * O Spring gera automaticamente a consulta SQL correspondente:
     * SELECT * FROM users WHERE username = ?
     */
    User findByUsername(String username);
}