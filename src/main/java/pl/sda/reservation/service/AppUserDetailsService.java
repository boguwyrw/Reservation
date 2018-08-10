package pl.sda.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.reservation.model.AppUser;
import pl.sda.reservation.repository.AppUserRepositiry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepositiry appUserRepositiry;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> user = appUserRepositiry.findByUsername(username);
        if(user.isPresent()){
            AppUser appUser = user.get();

            return new User(appUser.getUsername(), appUser.getPassword(), getRolesForUser(appUser.getUsername()));
        }
        return null;
    }

    private Collection<? extends GrantedAuthority> getRolesForUser(String username) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(username.equals("admin")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }
}
