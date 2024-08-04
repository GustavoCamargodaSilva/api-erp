package com.api.estoquerp.controller;

import com.api.estoquerp.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/filiais")
public class FilialController {

    @Autowired
    private FilialService filialService;


}
