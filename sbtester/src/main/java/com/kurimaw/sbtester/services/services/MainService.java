package com.kurimaw.sbtester.services.services;

import com.kurimaw.sbtester.managers.OsManager;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    OsService osService = OsManager.getOsService("Windows");

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        osService.whatIsMyOs();
    }
}
