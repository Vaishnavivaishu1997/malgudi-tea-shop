package com.vaishnavi.malgudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaishnavi.malgudi.entity.Settings;

public interface SettingsRepository
extends JpaRepository<Settings, Long> {

}