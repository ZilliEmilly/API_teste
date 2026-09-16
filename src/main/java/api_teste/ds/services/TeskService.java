//Pacote onde esta a classe do srviço no projeto
package api_teste.ds.services;

//importa List da biblioteca padrão do java para manipular coleçoes de objetos
import java.util.List;
import java.util.List;
//importa Optional, usada para tratar valores que podem nao estar presentes (evitar NullExceptPointer)
import java.util.Optional;

//importa a anotaçao de Spring para a injeçao automatica de dependencias
import org.springframework.beans.factory.annotation.Autowired;
//importa a anotaça que define esssa  classe como um componente de serviços gerado pelo Spring
import org.springframework.stereotype.Service;
//importa a anotaçao para gerenciar transicoes no banco de dados (garante atomicidade na operacao)
import org.springframework.transaction.annotation.Transactional;

//importa o models.Task
import api_teste.ds.models.Task;
//importa o models.User
import api_teste.ds.models.User;
//importa ainterface do repositorio responsavel pelas operaçoes no banco de dados
import api_teste.ds.repositories.TaskRepository;


//anotaçao que indica para o Spring que essa classe contem as regras de negocio
@Service
public class TeskService {

//injeta automaticamente  a instancia do Taskrepository gerenciado pelo Spring
@Autowired
private TaskRepository taskRepository;

//injeta automaticamente a instancia ou UserServico para validar o usuario
@Autowired
private UserService UserService;

//metodo para buscar task apartir do ID
/**
 * @param Id
 * @return
 */
public Task findById(Long Id){
    //executa a busca no banco, retorna um Optional contendo ou nao a Task
    Optional<api_teste.ds.models.Task> task = this.taskRepository.findById(Id);

    return task.orElseThrow(()-> new RuntimeException(
        "Tarefas nao encontrada! Id:"+ Id + ",Tipo" + Task.class.getName()

    ));
}

//metodo para buscar todas as tarefas vinculadas a um determinado usuario
public List<Task> findByUserId(Long UserId){
    
    //chama o UserService para garantir que o usuario existe no banco(lançar exeçao se nao existir)
     this.userServiceserService.findById(UserId);

     //executa a busca customizada no repositorio filtrado pelo id do usuario
     List<Tesk> tasks = this.teskRepository.findByUserId(UserId);

     //retorna a lista de tarefas
     return tasks;
    
     //garante que criaçao ocorra dentro de uma transaçao de banco de dados(rolback automatico se falhar)
     @Transactional 
     public Task create(api_teste.ds.models.Task obj){

        //valida se o usuario informa no objeto realmente existe no banco e recupera seus dados
        User user = this.userService.finByid(obj.getuser().getId());

        //define o ID como null para garantir que o JPA realize uma inserçao(INSERT) e nao atualizaçao
        obj.setId(id:null);

        //associa a entidade user completa e validada a tarefa
        obj.setUser(user);

        //salva a nova tarefa no banco de dados e atualiza 'obj' com o ID gerado
        obj = this.taskRepository.save(obj);


        //retorna a tarefa salva
        return obj;

     }

     //Garante que a atualizaçao ocorra dentro de transiçao isolada no banco
     @Transactional
     public Task update(api_teste.ds.models.Task obj){
        //reaproveita o findByID para verificar a atafera a ser atualizada existe realmente 
        api_teste.ds.models.Task newObj = findById(obj.getId());

        //atualiza apenas o campo descriçao do objeto persistindo com o novo valor
        newObj.setDescription(obj.getDescription());

        //salva a alteraçao no banco de dados e retorna o objetivo atualizado
        return this.taskRepository.save(newObj);


     }

     public void delete(Long Id){

        fineById(Id);

        try{

            this.taskRepository.deleteById(Id);
        } catch(Exeption e)[
            throw new RuntimeException(massage: "nao e possivel excluir pois nao ha tarefas relacionadas");
        ]
     }
}

    
}
