package com.ready.SteadyGo.controllers;


import com.ready.SteadyGo.models.Speaker;
import com.ready.SteadyGo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return  speakerRepository.getById(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public  Speaker create(@RequestBody final  Speaker speaker) {
        return  speakerRepository.saveAndFlush(speaker);
    }

    @GetMapping
    public List<Speaker> list(){
        return  speakerRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void  delete(@PathVariable Long id) {
        //TODO: Check children records before deleting
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker  update(@PathVariable Long id, @RequestBody  Speaker session) {
        //TODO: Add validation that all attributes are passed, else return 400
        Speaker existingSession = speakerRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "speaker_id");
        return speakerRepository.saveAndFlush(session);
    }

}
