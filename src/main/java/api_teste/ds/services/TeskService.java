package api_teste.ds.services;


import java.util.list;;
import java.util.Optional;

import org.springframework.beans.factores.annotation.Autowired;
import org.springframework.stereotype.services;
import org.springframework.annotation.Transaction.annotation.Transactional;

import api_teste_models.ds.models.Task;
import api_teste.ds.models.User;
import api_teste.ds.repositories.TaskRepository;

@Service
public class TeskService {


@Autowired
private TaskRepository taskRepository;
@Autowired
private UserService UserService;
    
}
