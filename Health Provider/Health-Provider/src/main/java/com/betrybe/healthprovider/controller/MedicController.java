package com.betrybe.healthprovider.controller;

import com.betrybe.healthprovider.dto.MedicCreateDto;
import com.betrybe.healthprovider.dto.MedicDto;
import com.betrybe.healthprovider.entity.Medic;
import com.betrybe.healthprovider.service.MedicService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medics")
public class MedicController {
  private final MedicService medicService;

  @Autowired
  public MedicController(MedicService medicService) {
    this.medicService = medicService;
  }

  @GetMapping
  public ResponseEntity<List<MedicDto>> getMedics() {

    List<MedicDto> medicsDto = new ArrayList<>();
    for (Medic medic : medicService.getAllMedics()) {
      medicsDto.add(MedicDto.fromEntity(medic));
    }
    return ResponseEntity.ok(medicsDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MedicDto> getMedicById(@PathVariable Long id) {
    Medic medic = medicService.getMedicById(id);
    if (medic == null) {
      ResponseEntity.notFound();
    }
    return ResponseEntity.ok(MedicDto.fromEntity(medic));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MedicDto createMedic(@RequestBody MedicCreateDto medicCreateDto) {
    Medic medic = medicService.saveMedic(medicCreateDto.toEntity());
    return MedicDto.fromEntity(medic);
  }
}
