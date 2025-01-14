package ru.isu.irk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.isu.irk.IRK_WorkerInfo;
import ru.isu.irk.model.IRK_Worker;
import ru.isu.irk.repository.IRK_WorkerRepository;

@Service
public class IRK_WorkerInfoService implements UserDetailsService {

    @Autowired
    private IRK_WorkerRepository repository;

    @Override
    public IRK_WorkerInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<IRK_Worker> irkWorker = repository.findByUsername(username);
        return irkWorker.map(IRK_WorkerInfo::new)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    }
}