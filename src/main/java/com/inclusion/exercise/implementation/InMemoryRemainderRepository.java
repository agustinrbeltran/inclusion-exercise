package com.inclusion.exercise.implementation;

import com.inclusion.exercise.domain.RemainderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryRemainderRepository implements RemainderRepository {

  private final Map<Integer, Integer> maxRemainderMap = new HashMap<>();

  @Override
  public Integer getMax(int id) {
    return maxRemainderMap.get(id);
  }

  @Override
  public void saveMax(int id, int max) {
    maxRemainderMap.put(id, max);
  }
}
