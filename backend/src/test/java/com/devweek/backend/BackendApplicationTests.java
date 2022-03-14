package com.devweek.backend;

import com.devweek.backend.Controller.RegiaoController;
import com.devweek.backend.Entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {

	private final String URL = "/api/regioes";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RegiaoController regiaoController;

	// object listing
	@Test
	public void getByIdControllerTest() throws Exception {
		mockMvc.perform(get(URL+"/1"))
				.andExpect(status().isOk());
		mockMvc.perform(get(URL+"/58"))
				.andExpect(status().is4xxClientError());
	}

	@Test
	public void addNewRegiaoTest() throws Exception {
		Long id = 6L;
		Regiao newRegiao = new Regiao(id,"Noroeste", 57);

		mockMvc.perform(post(URL+"/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newRegiao)))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteByIdRedgiaoTest() throws Exception {
		//delete("/api/foo/{id}", "11")
		mockMvc.perform(delete(URL+"/delete/{id}","6")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
