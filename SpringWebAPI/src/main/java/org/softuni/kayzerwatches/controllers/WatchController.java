package org.softuni.kayzerwatches.controllers;

import org.softuni.kayzerwatches.entities.Watch;
import org.softuni.kayzerwatches.services.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watches")
@CrossOrigin(origins = "*", exposedHeaders = "Content-Type")
public class WatchController {

    private final WatchService watchService;

    @Autowired
    public WatchController(WatchService watchService) {
        this.watchService = watchService;
    }

    @GetMapping("/top")
    public List<Watch> getTopFourWatches() {
        return this.watchService.getTopFourDesc();
    }

    @GetMapping("/all")
    public List<Watch> getAll() {return this.watchService.getAll(); }

    @GetMapping("/details")
    public Watch getDetails(@RequestParam("id") String id) {
        Watch watch = this.watchService.getById(id);
        return watch;
    }

    @PostMapping("/add")
    public void postAdd(Watch watch) {
        this.watchService.saveWatch(watch);
    }
}
