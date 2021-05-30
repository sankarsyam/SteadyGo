package com.ready.SteadyGo.controllers;

import com.ready.SteadyGo.models.Session;
import com.ready.SteadyGo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
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

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void  delete(@PathVariable Long id) {
        //TODO: Check children records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session  update(@PathVariable Long id, @RequestBody  Session session) {
        //TODO: Add validation that all attributes are passed, else return 400
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(session);
    }

}
