package com.br.projectmongo.services;

import com.br.projectmongo.domain.User;
import com.br.projectmongo.dto.UserDTO;
import com.br.projectmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }
    public User update(User user){
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO dto){
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getEmail()
        );
    }
}