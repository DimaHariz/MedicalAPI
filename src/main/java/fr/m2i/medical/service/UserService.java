package fr.m2i.medical.service;

import fr.m2i.medical.entities.UserEntity;
import fr.m2i.medical.entities.VilleEntity;
import fr.m2i.medical.repository.UserRepository;
import fr.m2i.medical.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InvalidObjectException;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private UserRepository ur;

    //@Autowired
    private PasswordEncoder encoder = new PasswordEncoder() {
        @Override
        public String encode(CharSequence rawPassword) {
            return ""+ rawPassword;
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return false;
        }
    };

    public UserService(UserRepository ur ){
        this.ur = ur;
    }

    public Iterable<UserEntity> findAll(  ) {
        return ur.findAll();
    }

    public void addUser(UserEntity u) {
        u.setPassword(encoder.encode(u.getPassword()));
        ur.save(u);
    }

    public UserEntity findUser(int id) {
        return ur.findById(id).get();
    }

    public void editUser( int id , UserEntity u) throws NoSuchElementException {

        try{
            UserEntity uExistant = ur.findById(id).get();

            uExistant.setEmail( u.getEmail() );
            uExistant.setName( u.getName() );
            uExistant.setUsername( u.getUsername() );
            uExistant.setRoles( u.getRoles() );

            if( u.getPassword().length() > 0 ){
                uExistant.setPassword( encoder.encode( u.getPassword() ) );
            }

            ur.save( uExistant );

        }catch ( NoSuchElementException e ){
            throw e;
        }
    }

    public void editProfil( int id , UserEntity u) throws NoSuchElementException {
        try{
            UserEntity uExistant = ur.findById(id).get();

            uExistant.setEmail( u.getEmail() );
            uExistant.setName( u.getName() );
            uExistant.setUsername( u.getUsername() );
            uExistant.setPhotouser( u.getPhotouser() );

            ur.save( uExistant );

        }catch ( NoSuchElementException e ){
            throw e;
        }
    }

    public void delete(int id) {
        ur.deleteById(id);
    }

}