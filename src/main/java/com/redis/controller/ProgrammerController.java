package com.redis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.model.Programmer;
import com.redis.service.ProgrammerService;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
public class ProgrammerController {

    private final ProgrammerService programmerService;

    @Autowired
    public ProgrammerController(ProgrammerService programmerService) {
        this.programmerService = programmerService;
    }

    @PostMapping("/programmer-string")
    public ResponseEntity<?> addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), mapper.writeValueAsString(programmer));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/programmer-string/{id}")
    public ResponseEntity<?> getProgrammer(@PathVariable String id) {
        String programmerAsString = programmerService.getProgrammerAsString(id);
        return new ResponseEntity<>(programmerAsString, HttpStatus.OK);
    }

    @PostMapping("/programmers-list")
    public ResponseEntity<?> addProgrammersToList(@RequestBody Programmer programmer) {
        programmerService.addProgrammersAsList(programmer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/programmers-list")
    public ResponseEntity<?> getProgrammersListMembers() {
        List<Programmer> programmersListMembers = programmerService.getProgrammersListMembers();
        return new ResponseEntity<>(programmersListMembers, HttpStatus.OK);
    }

    @GetMapping("/programmers-list/count")
    public ResponseEntity<?> getProgrammersListCount() {
        Long programmersListCount = programmerService.getProgrammersListCount();
        return new ResponseEntity<>(programmersListCount, HttpStatus.OK);
    }

    @PostMapping("/programmer-set")
    public ResponseEntity<?> addProgrammersAsSet(Programmer... programmer) {
        programmerService.addProgrammersAsSet(programmer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/programmer-set/memebrs")
    public ResponseEntity<?> getProgrammersSetMembers() {
        Set<Programmer> programmersSetMembers = programmerService.getProgrammersSetMembers();
        return new ResponseEntity<>(programmersSetMembers, HttpStatus.OK);
    }

    @PostMapping("/programmer-set/isMember")
    public ResponseEntity<?> isSetMember(@RequestBody Programmer programmer) {
        boolean setMember = programmerService.isSetMember(programmer);
        return new ResponseEntity<>(setMember, HttpStatus.OK);
    }

    @PostMapping("/programmer-hash/save")
    public ResponseEntity<?> saveHash(@RequestBody Programmer programmer) {
        programmerService.saveHash(programmer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/programmer-hash/update")
    public ResponseEntity<?> updateHash(@RequestBody Programmer programmer) {
        programmerService.updateHash(programmer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/programmer-hash")
    public ResponseEntity<?> findAllHash() {
        Map<Integer, Programmer> allHash = programmerService.findAllHash();
        return new ResponseEntity<>(allHash, HttpStatus.OK);
    }

    @GetMapping("/programmer-hash/{id}")
    public ResponseEntity<?> findAllHash(@PathVariable Integer id) {
        Programmer hash = programmerService.findHash(id);
        return new ResponseEntity<>(hash, HttpStatus.OK);
    }

    @DeleteMapping("/programmer-hash/{id}")
    public ResponseEntity<?> deleteHash(@PathVariable Integer id) {
        programmerService.deleteHash(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

 }
