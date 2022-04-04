package com.example.tmp.monopro.service;

import com.example.tmp.monopro.entity.Status;
import com.example.tmp.monopro.repo.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class StatusServiceImpl implements   StatusService  {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(StatusServiceImpl.class.getName());

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> getStatusList() {
        return statusRepository.findAll();
    }

    @Override
    public List<Status> getOrderedStatusList(int limit) {
        return entityManager.createQuery("SELECT s FROM  Status  s where s.processed=false or s.mailsend=false ORDER BY s.statusid",
                Status.class).setMaxResults(limit).getResultList();
    }



    @Override
    public String saveStatus(Status status) {
        statusRepository.save(status);
        LOGGER.log(Level.INFO, "status-saved {0}.", status.getStatusid());
        return "success" ;
    }

    @Override
    public String deleteStatus(Status status) {
        statusRepository.delete(status);
        LOGGER.log(Level.INFO, "status-deleted {0}.", status.getStatusid());
        return "success" ;
    }

    @Override
    public Optional<Status> getStatusByID(int statusid) {
        return statusRepository.findById(statusid);
    }


}
