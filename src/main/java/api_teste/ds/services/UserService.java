//declara o caminho onde a classe esta dentro do codigo
package api_teste.ds.services;


//importa Optional, usada para tratar valores que podem nao estar presentes (evitar NullExceptPointer)
import java.util.Optional;

//importa a anotaçao de Spring para a injeçao automatica de dependencias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
//importa a anotaça que define esssa  classe como um componente de serviços gerado pelo Spring
import org.springframework.stereotype.Service;
//importa a anotaçao para gerenciar transicoes no banco de dados (garante atomicidade na operacao)
import org.springframework.transaction.annotation.Transactional;


//importa o models.Task
import api_teste.ds.models.Task;
//importa ainterface do repositorio responsavel pelas operaçoes no banco de dados
import api_teste.ds.repositories.TaskRepository;
import api_teste.ds.repositories.User;
//importa a interface do repositorio responsavel pelas operacoes no banco de dados
 import api_teste.ds.repositories.UserRepository;



//anotacao que indica no Spring que essa classe contem as regras de negocios da entidade user
@Service 
public class UserService {

    @Autowired 
    private UserRepository userRepository;

    @Autowired 
    private TaskRepository taskRepository;

    public void findById(Long Id){

        Optional<User> user = this.userRepository.findById(Id);

  
        return user.orElseThrow(()-> new RuntimeException(
            "Usuario nao encontrada! Id:"+ Id + ",Tipo" + Task.class.getName()
    
        ));
    }

    @Transactional 
    public User create(User obj){

        obj.setId(null);

        obj.this.userRepository.save(obj);

        this.taskRepository.saveAll(obj.getClass);

        return obj;
    }

    @Transactional 

    public User update(User obj){

        User newObj = findById(obj.getId())
    }
    
}
