package com.orca.bookclub.services;

import java.util.Optional;

import com.orca.bookclub.models.LoginUser;
import com.orca.bookclub.models.User;
import com.orca.bookclub.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

//import com.authentication.models.LoginUser;
//import com.authentication.models.User;
//import com.authentication.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    // TO-DO: Write register and login methods!
    public User register(User user, BindingResult result) {
        // setting a potential user and finding the email
        Optional<User> potentialUser = userRepository.findByEmail(user.getEmail());
        // checking if the var potential user exists or not
        if(potentialUser.isPresent()){
            result.rejectValue("email","Matches", "account already exist");
        }
        // checking if password is true and equal to the confirmed.
        if(!user.getPassword().equals(user.getConfirm())){
            result.rejectValue("password","matches","Invalid credentials");
        }
        if(result.hasErrors()){
            return null;
        }
        // settting hashed to be the result of the Bcrypt.hashpw function
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);

    }
    public User login(LoginUser logininUser, BindingResult result) {
        Optional<User> potentialUser = userRepository.findByEmail(logininUser.getEmail());
        if(!potentialUser.isPresent()){
            result.rejectValue("email","No Email","User does not exist.");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(logininUser.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
            return null;
        }
        if (result.hasErrors()){
            return null;
        }
        else{
            return user;
        }

    }

    public User findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }
}
