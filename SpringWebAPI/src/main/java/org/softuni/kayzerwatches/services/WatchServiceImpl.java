package org.softuni.kayzerwatches.services;

import org.softuni.kayzerwatches.entities.Watch;
import org.softuni.kayzerwatches.repositories.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchServiceImpl implements WatchService {

    private final WatchRepository watchRepository;

    @Autowired
    public WatchServiceImpl(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @Override
    public List<Watch> getTopFourDesc() {
        return this.watchRepository.findTop4ByOrderByViewsDesc();
    }

    @Override
    public List<Watch> getAll() {
        return this.watchRepository.findAll();
    }

    @Override
    public Watch getById(String id) {
        return this.watchRepository.findById(id).orElse(null);
    }

    @Override
    public void saveWatch(Watch watch) {
        this.watchRepository.saveAndFlush(watch);
    }
}
