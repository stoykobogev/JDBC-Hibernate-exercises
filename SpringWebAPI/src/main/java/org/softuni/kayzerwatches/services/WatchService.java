package org.softuni.kayzerwatches.services;

import org.softuni.kayzerwatches.entities.Watch;

import java.util.List;

public interface WatchService {

    List<Watch> getTopFourDesc();

    List<Watch> getAll();

    Watch getById(String id);

    void saveWatch(Watch watch);
}
