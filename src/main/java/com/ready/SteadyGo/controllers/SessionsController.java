package com.ready.SteadyGo.controllers;

import com.ready.SteadyGo.models.Session;
import com.ready.SteadyGo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return  sessionRepository.getById(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public  Session create(@RequestBody final  Session session) {
        return  sessionRepository.saveAndFlush(session);
    }

    @GetMapping
    public List<Session> list(){
        return  sessionRepository.findAll();
    }

}
