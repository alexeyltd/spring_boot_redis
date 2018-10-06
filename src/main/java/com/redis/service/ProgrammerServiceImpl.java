package com.redis.service;

import com.redis.model.Programmer;
import com.redis.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    private final ProgrammerRepository programmerRepository;

    @Autowired
    public ProgrammerServiceImpl(ProgrammerRepository programmerRepository) {
        this.programmerRepository = programmerRepository;
    }

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        programmerRepository.setProgrammerAsString(idKey, programmer);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return programmerRepository.getProgrammerAsString(idKey);
    }

    @Override
    public void addProgrammersAsList(Programmer programmer) {
        programmerRepository.addProgrammersAsList(programmer);
    }

    @Override
    public List<Programmer> getProgrammersListMembers() {
        return programmerRepository.getProgrammersListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return programmerRepository.getProgrammersListCount();
    }

    @Override
    public void addProgrammersAsSet(Programmer... programmer) {
        programmerRepository.addProgrammersAsSet(programmer);
    }

    @Override
    public Set<Programmer> getProgrammersSetMembers() {
        return programmerRepository.getProgrammersSetMembers();
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return programmerRepository.isSetMember(programmer);
    }

    @Override
    public void saveHash(Programmer programmer) {
        programmerRepository.saveHash(programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        programmerRepository.updateHash(programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllHash() {
        return programmerRepository.findAllHash();
    }

    @Override
    public Programmer findHash(int id) {
        return programmerRepository.findHash(id);
    }

    @Override
    public void deleteHash(int id) {
        programmerRepository.deleteHash(id);
    }
}
