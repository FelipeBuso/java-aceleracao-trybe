package com.betrybe.healthprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.betrybe.healthprovider.entity.Medic;
import com.betrybe.healthprovider.exception.MedicNotFoundException;
import com.betrybe.healthprovider.repository.MedicFakeRepository;
import com.betrybe.healthprovider.service.MedicService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class MedicServiceTest {

  @Autowired MedicService medicService;

  @MockitoBean MedicFakeRepository medicRepositoryMock;

  @Test
  @DisplayName("Deve retornar excessão")
  public void TestGetMedicSucces() {
    Medic mockMedic = new Medic(1L, "Kirk", "Engenheiro", "123456789-00");

    Mockito.when(medicRepositoryMock.getMedic(any())).thenReturn(Optional.of(mockMedic));

    Long id = mockMedic.getId();

    Medic medic = medicService.getMedicById(id);

    assertNotNull(medic);
    assertEquals(id, medic.getId());
    assertEquals(mockMedic.getName(), medic.getName());
    assertEquals(mockMedic.getSpecialty(), medic.getSpecialty());
    assertEquals(mockMedic.getCpf(), medic.getCpf());

    Mockito.verify(medicRepositoryMock).getMedic(eq(id));
  }

  @Test
  @DisplayName("Deve retornar objeto correto quando id for passado")
  public void TestGetMedicNotFound() {

    Mockito.when(medicRepositoryMock.getMedic(any())).thenReturn(Optional.empty());

    assertThrows(MedicNotFoundException.class, () -> medicService.getMedicById(99L));
  }
}
