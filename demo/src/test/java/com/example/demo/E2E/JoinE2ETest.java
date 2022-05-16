package com.example.demo.E2E;

import com.example.demo.join.TurbinaGeneradorJoin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JoinE2ETest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private JdbcTemplate template;

    @Test
    public void JoinTest() {
        String query = "SELECT TURBINAS.ID, TURBINAS.ENCENDIDO, TURBINAS.CARGA, GENERADOR.ID, GENERADOR.VOLTAJE, GENERADOR.ESTADO FROM TURBINAS INNER JOIN GENERADOR ON TURBINAS.ID = GENERADOR.IDTURBINA;";
        Iterable<TurbinaGeneradorJoin> TGJoin = template.query(
                query,
                (data, rowNum) -> {
                    return new TurbinaGeneradorJoin(
                            data.getLong("TURBINA.ID"),
                            data.getLong("GENERADOR.ID"),
                            data.getBoolean("TURBINA.ENCENDIDO"),
                            data.getLong("TURBINA.CARGA"),
                            data.getLong("GENERADOR.VOLTAJE"),
                            data.getString("GENERADOR.ESTADO"));
                });

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/generador/join";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<Iterable<TurbinaGeneradorJoin>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<TurbinaGeneradorJoin>>() {
            }); // hacemos llamada

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(TGJoin);
    }
}
