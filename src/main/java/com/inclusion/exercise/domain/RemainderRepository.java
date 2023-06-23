package com.inclusion.exercise.domain;

public interface RemainderRepository {

  RemainderParams getById(int id);

  void save(RemainderParams remainderParams);

}
