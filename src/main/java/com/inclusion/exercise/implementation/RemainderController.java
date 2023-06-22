package com.inclusion.exercise.implementation;

import com.inclusion.exercise.application.RemainderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/remainder")
public class RemainderController {

  private final RemainderService service;

  public RemainderController(RemainderService service){
    this.service = service;
  }

  @PostMapping("/max")
  public List<Integer> getMax(@RequestBody List<RemainderParamsDTO> remainderParamsDTOs) {
    return service.getMax(remainderParamsDTOs);
  }

}

