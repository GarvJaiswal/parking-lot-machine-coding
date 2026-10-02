package org.example.repositories;

import org.example.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gateMap = new HashMap<>();
    private Long gateId = 0L;

    public Gate save(Gate gate){
        if(gate.getId() == null){
            gateId++;
            gate.setId(gateId);
            gateMap.put(gate.getId(), gate);
        }
        else{
            gateMap.put(gate.getId(), gate);
        }
        return gate;
    }

    public Optional<Gate> findById(Long gateId){
        if(gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }
}
