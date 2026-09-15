package api_teste.ds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tarefas02.api.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // =========================================================================
    // Opção 1: Derived Query Method (Padrão e Recomendado pelo Spring Data JPA)
    // O Spring gera o SQL automaticamente a partir do nome do método.
    // =========================================================================
    List<Task> findByUser_Id(Long id);

    /*
    // =========================================================================
    // Opção 2: Consulta JPQL (Java Persistence Query Language)
    // Utiliza a anotação @Query referenciando a ENTIDADE (Task) e o objeto (user.id).
    // =========================================================================
    @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    List<Task> findByUser_IdJPQL(@Param("id") Long id);
    */

    /*
    // =========================================================================
    // Opção 3: Consulta SQL Nativa (Native Query)
    // Escreve SQL puro diretamente para o banco MySQL (usa a TABELA task e a COLUNA user_id).
    // =========================================================================
    @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
    List<Task> findByUser_IdSQL(@Param("id") Long id);
    */
}