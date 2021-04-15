package br.com.freeanki.services;

import br.com.freeanki.models.User;
import br.com.freeanki.repositories.UserRepository;
import br.com.freeanki.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User insert(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    public User findById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found id " + id));
    }

    public User update(UUID id, User user) {
        User updateUser = findById(id);
        updateData(updateUser, user);
        return userRepository.save(updateUser);
    }

    private void updateData(User updateUser, User user) {
        updateUser.setDecks(user.getDecks());
        updateUser.setName(user.getName());
        updateUser.setPassword(user.getPassword());
    }
}
