package com.pmu.course.service.impl;

import com.pmu.course.model.Partant;
import com.pmu.course.repository.PartantRepository;
import com.pmu.course.service.PartantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartantServiceImpl implements PartantService {
    private final PartantRepository partantRepository;

    @Override
    public Partant create(Partant partant) {
        log.info("Enregistrement de la course: {}",partant.getId());
        return partantRepository.save(partant);
    }

    @Override
    public List<Partant> list(int limit) {
        log.info("Liste des partants existants");
        return partantRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Partant update(Partant partant) {
        log.info("modification du partant: {}",partant.getId());
        return partantRepository.save(partant);
    }

    @Override
    public boolean delete(UUID id) {
        log.info("suppression de partant: {}",id);
        partantRepository.deleteById(id);
        return true;
    }

    @Override
    public Partant get(UUID id) {
        log.info("recherche du partant: {}",id);
        return partantRepository.findById(id).get();
    }
}
