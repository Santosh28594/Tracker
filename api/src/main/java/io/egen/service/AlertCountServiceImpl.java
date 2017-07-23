package io.egen.service;

import io.egen.entity.AlertCount;

import io.egen.repository.AlertCountRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class AlertCountServiceImpl implements AlertCountService {



    @Autowired
    AlertCountRepository alertCountRepository;

    Date newDate = new Date();
    public List<AlertCount> getAlertCount() {



            return alertCountRepository.getAlertCount();
        }
    }

