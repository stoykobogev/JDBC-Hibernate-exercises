package org.softuni.kayzerwatches.repositories;

import org.softuni.kayzerwatches.entities.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource
public interface WatchRepository extends JpaRepository<Watch, String> {

    List<Watch> findTop4ByOrderByViewsDesc();
}
