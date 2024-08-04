package com.api.estoquerp.service;

import com.api.estoquerp.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;
}
