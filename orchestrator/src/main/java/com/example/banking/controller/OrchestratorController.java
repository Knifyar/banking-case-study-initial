package com.example.banking.controller;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposit/")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrchestratorController {


}
