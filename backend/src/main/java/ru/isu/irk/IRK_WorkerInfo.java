package ru.isu.irk;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ru.isu.irk.model.IRK_Worker;

public class IRK_WorkerInfo implements UserDetails{
    private IRK_Worker irkWorker;
    
    public IRK_WorkerInfo(IRK_Worker irkWorker){
        this.irkWorker=irkWorker;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(irkWorker.getRole().split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    
    public Integer getId() {
        return this.irkWorker.getId();
    }
    
    @Override
    public String getPassword() {
        return this.irkWorker.getPassword();
    }

    @Override
    public String getUsername() {
        return this.irkWorker.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
        
}
