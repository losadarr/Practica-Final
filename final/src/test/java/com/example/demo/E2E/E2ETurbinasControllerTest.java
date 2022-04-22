package com.example.demo.E2E;

import java.net.http.HttpHeaders;

import com.example.demo.controller.TurbinaController;
import com.example.demo.controller.TurbinaController.DataRequest;
import com.example.demo.model.Turbina;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class E2ETurbinasControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testing_processController_step1_then_ok(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
		//DataRequest dataRequest = new DataRequest("Calamardo", "38937498Q", "666666666");
        Turbina turbina = new Turbina(3L,120L,100L,50L,true);
        DataRequest dataRequest = new DataRequest(3L,23L,345L,60L,true,34L);
		HttpHeaders headers = new HttpHeaders());
		HttpEntity<TurbinaController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

		//When
		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, Turbina.class);

		//Then
		then(result.getBody()).isEqualTo("OK! Cambios realizados");
    }
}
