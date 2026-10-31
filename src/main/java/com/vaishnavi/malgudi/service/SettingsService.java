package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaishnavi.malgudi.entity.Settings;
import com.vaishnavi.malgudi.repository.SettingsRepository;

@Service
public class SettingsService {

    @Autowired
    private SettingsRepository repository;

    public Settings save(Settings settings) {
        return repository.save(settings);
    }

    public List<Settings> getAll() {
        return repository.findAll();
    }

    public Settings getById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}