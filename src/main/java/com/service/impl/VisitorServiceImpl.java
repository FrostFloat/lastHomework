package com.service.impl;

import com.dao.VisitorDao;
import com.service.VisitorServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorServiceI {
    @Autowired
    VisitorDao visitorDao;
}
