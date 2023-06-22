package com.inclusion.exercise.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class RequiredRemainderController {


  @PostMapping("solution")
  public List<Integer> findSolution(@RequestBody List<RequiredRemainder> requiredRemainders) {
    return requiredRemainders.stream().map(RequiredRemainder::getMaxRemainder).toList();
  }


}

