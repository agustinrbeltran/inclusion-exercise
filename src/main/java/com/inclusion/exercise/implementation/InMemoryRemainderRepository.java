package com.inclusion.exercise.implementation;

import com.inclusion.exercise.domain.RemainderParams;
import com.inclusion.exercise.domain.RemainderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryRemainderRepository implements RemainderRepository {

  private final Map<Integer, RemainderParams> maxRemainderMap = new HashMap<>();

  @Override
  public RemainderParams getById(int id) {
    return maxRemainderMap.get(id);
  }

  @Override
  public void save(RemainderParams remainderParams) {
    maxRemainderMap.put(remainderParams.getId(), remainderParams);
  }

}
