package com.redis.service;

import com.redis.model.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerService {
    void setProgrammerAsString(String idKey, String programmer);
    String getProgrammerAsString(String idKey);
    void addProgrammersAsList(Programmer programmer);
    List<Programmer> getProgrammersListMembers();
    Long getProgrammersListCount();
    void addProgrammersAsSet(Programmer... programmer);
    Set<Programmer> getProgrammersSetMembers();
    boolean isSetMember(Programmer programmer);
    void saveHash(Programmer programmer);
    void updateHash(Programmer programmer);
    Map<Integer, Programmer> findAllHash();
    Programmer findHash(int id);
    void deleteHash(int id);
}
