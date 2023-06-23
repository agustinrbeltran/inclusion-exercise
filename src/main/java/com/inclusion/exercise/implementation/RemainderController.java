package com.inclusion.exercise.implementation;

import com.inclusion.exercise.application.RemainderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/remainder")
public class RemainderController {

  private final RemainderService service;

  public RemainderController(RemainderService service){
    this.service = service;
  }

  @PostMapping
  public List<RemainderParamsDTO> create(@RequestBody List<RemainderParamsDTO> remainderParamsDTOs) {
    return service.create(remainderParamsDTOs);
  }

  @GetMapping("/{id}")
  @ResponseBody
  public RemainderParamsDTO getById(@PathVariable Integer id) {
    var result = service.getById(id);
    if(result == null)
      throw new RemainderNotFoundException();
    return result;
  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "remainder not found")
  public static class RemainderNotFoundException extends RuntimeException {
  }

}

