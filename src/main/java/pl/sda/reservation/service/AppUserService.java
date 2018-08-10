package pl.sda.reservation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.reservation.model.AppUser;
import pl.sda.reservation.model.RegisterAppUserDTO;
import pl.sda.reservation.repository.AppUserRepositiry;

import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AppUserRepositiry appUserRepositiry;

    public boolean registerUser(RegisterAppUserDTO dto){
        // 1. czy istnieje uzytkownik o takim usename
        Optional<AppUser> appUser = appUserRepositiry.findByUsername(dto.getUsername());
        if(appUser.isPresent()){
            // istnieje
            return false;
        }
        AppUser newUser = new AppUser(dto.getUsername(), bCryptPasswordEncoder.encode(dto.getPassword()));
        appUserRepositiry.save(newUser);
        return true;
    }

}
