package com.example.waveguide.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
@RestController
@RequestMapping("/waveguide")
public class WaveguideController {

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestBody List<Layer> layers) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("python", "python/waveguide_runner.py");
        Process process = builder.start();

        // Пишем JSON в stdin
        OutputStream stdin = process.getOutputStream();
        stdin.write(new ObjectMapper().writeValueAsBytes(layers));
        stdin.flush();
        stdin.close();

        // Читаем stdout
        InputStream stdout = process.getInputStream();
        String resultJson = new String(stdout.readAllBytes(), StandardCharsets.UTF_8);
        process.waitFor();

        return ResponseEntity.ok(resultJson);
    }
}
