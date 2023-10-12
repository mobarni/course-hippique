package com.pmu.course.service;

import com.pmu.course.model.Partant;

import java.util.List;
import java.util.UUID;

public interface PartantService {
    Partant create(Partant partant);
    List<Partant> list(int limit);
    Partant update(Partant partant);
    boolean delete(UUID id);
    Partant get(UUID id);
}
