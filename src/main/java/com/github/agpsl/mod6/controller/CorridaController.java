package com.github.agpsl.mod6.controller;

import com.github.agpsl.mod6.entity.Corrida;
import com.github.agpsl.mod6.service.CorridaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/corrida")
public class CorridaController {
    @Autowired
    CorridaService corridaService;

    // Create
    @Operation(
            summary = "Cria uma nova corrida",
            description = "Cria uma nova corrida"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Operação bem sucedida")
            }
    )
    @PostMapping
    public ResponseEntity<Corrida> saveCorrida(@RequestBody Corrida corrida) {
        return new ResponseEntity<>(corridaService.save(corrida), HttpStatus.CREATED);
    }

    // Read
    @Operation(
            summary = "Retorna todas corridas",
            description = "Retorna todas corridas registradas no banco de dados"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Operação bem sucedida")
            }
    )
    @GetMapping
    public ResponseEntity<List<Corrida>> getAll() {
        List<Corrida> corridas = corridaService.getAll();
        if (!corridas.isEmpty()) {
            return new ResponseEntity<>(corridas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Retorna uma corrida",
            description = "Retorna uma corrida com ID fornecido na URL"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
                    @ApiResponse(responseCode = "404", description = "Corrida não encontrada")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Corrida> getById(@PathVariable Integer id) {
        Corrida corrida = corridaService.getById(id);
        if (corrida != null) {
            return new ResponseEntity<>(corrida, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @Operation(
            summary = "Atualiza uma corrida",
            description = "Atualiza os dados de um ou mais campos em uma corrida"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
                    @ApiResponse(responseCode = "404", description = "Corrida não encontrada")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Corrida> updateCorrida(@PathVariable Integer id, @RequestBody Corrida corrida) {
        Corrida corridaAtualizada = corridaService.update(id, corrida);
        if (corridaAtualizada != null) {
            return new ResponseEntity<>(corridaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @Operation(
            summary = "Exclui uma corrida",
            description = "Exclui uma corrida do banco de dados"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
                    @ApiResponse(responseCode = "404", description = "Corrida não encontrada")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategoria(@PathVariable Integer id) {
        if (corridaService.deleteCorrida(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}
