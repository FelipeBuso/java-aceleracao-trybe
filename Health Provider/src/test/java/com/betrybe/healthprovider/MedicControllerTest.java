package com.betrybe.healthprovider;

import static org.mockito.ArgumentMatchers.any;

import com.betrybe.healthprovider.entity.Medic;
import com.betrybe.healthprovider.exception.MedicNotFoundException;
import com.betrybe.healthprovider.service.MedicService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicControllerTest {

  @Autowired MockMvc mockMvc;

  @MockitoBean MedicService medicServiceMock;

  @Test
  @DisplayName("Teste do controller")
  public void testGetMedicController() throws Exception {
    Medic mockMedic = new Medic(1L, "Kirk", "Engenheiro", "123456789-00");

    Mockito.when(medicServiceMock.getMedicById(any())).thenReturn(mockMedic);

    Long id = mockMedic.getId();

    String url = "/medics/%s".formatted(id);

    mockMvc
        .perform(get(url))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(id))
        .andExpect(jsonPath("$.name").value(mockMedic.getName()))
        .andExpect(jsonPath("$.specialty").value(mockMedic.getSpecialty()))
        .andExpect(jsonPath("$.cpf").doesNotExist());
    Mockito.verify(medicServiceMock).getMedicById(id);
  }

  @Test
  @DisplayName("Teste do controller exception")
  public void testGetMedicControllerNotFound() throws Exception {

    Mockito.when(medicServiceMock.getMedicById(any())).thenThrow(new MedicNotFoundException());

    String url = "/medics/999";

    mockMvc
        .perform(get(url))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Pessoa médica não encontrada"));
  }
}
