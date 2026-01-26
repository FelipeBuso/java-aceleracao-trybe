package com.betrybe.healthprovider.service;

import com.betrybe.healthprovider.dto.MedicDto;
import com.betrybe.healthprovider.entity.Medic;
import com.betrybe.healthprovider.repository.MedicFakeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicService {
  private final MedicFakeRepository medicFakeRepository;

  @Autowired
  public MedicService(MedicFakeRepository medicFakeRepository) {
    this.medicFakeRepository = medicFakeRepository;
  }

  public List<Medic> getAllMedics() {
    return medicFakeRepository.getAllMedics();
  }

  public Medic getMedicById(Long id) {
    Medic medic = medicFakeRepository.getMedic(id);
    if (medic == null) {
      return null;
    }
    return medic;
  }

  public Medic saveMedic(Medic medic) {
    return medicFakeRepository.saveMedic(medic);
  }
}
