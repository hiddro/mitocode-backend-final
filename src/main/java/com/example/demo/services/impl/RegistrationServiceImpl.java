package com.example.demo.services.impl;

import com.example.demo.models.entities.Registration;
import com.example.demo.repository.GENERICRepositories;
import com.example.demo.repository.RegistrationRepositories;
import com.example.demo.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl extends CRUDServiceImpl<Registration, Integer> implements RegistrationService {

    @Autowired
    private RegistrationRepositories registrationRepositories;

    @Override
    protected GENERICRepositories<Registration, Integer> getRepo() {
        return registrationRepositories;
    }
}
