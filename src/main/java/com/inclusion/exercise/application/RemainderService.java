package com.inclusion.exercise.application;

import com.inclusion.exercise.domain.RemainderParams;
import com.inclusion.exercise.domain.RemainderRepository;
import com.inclusion.exercise.implementation.RemainderParamsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemainderService {

  private final RemainderRepository repository;


  public RemainderService(RemainderRepository repository) {
    this.repository = repository;
  }

  public List<Integer> getMax(List<RemainderParamsDTO> remainderParamsDTOs) {

    var remainderParamsList = RemainderParamsMapper.toEntities(remainderParamsDTOs);

    return remainderParamsList.stream().map(entity -> {

      var maxRemainder = repository.getMax(entity.getId());

      if (maxRemainder != null) {
        return maxRemainder;
      }

      maxRemainder = getMaxRemainder(entity);
      repository.saveMax(entity.getId(), maxRemainder);
      return maxRemainder;

    }).toList();

  }


  private int getMaxRemainder(RemainderParams remainderParams) {

    for (int k = remainderParams.getN(); k >= 0; k--) {
      if (k % remainderParams.getX() == remainderParams.getY()) {
        return k;
      }
    }
    return 0;

  }


}
