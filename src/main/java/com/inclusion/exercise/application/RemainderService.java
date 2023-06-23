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

  public List<RemainderParamsDTO> create(List<RemainderParamsDTO> remainderParamsDTOs) {

    var remainderParamsList = RemainderParamsMapper.toEntities(remainderParamsDTOs);

    return remainderParamsList.stream().map(entity -> {

      var remainderParams = repository.getById(entity.getId());

      if (remainderParams != null && remainderParams.getMaxRemainder() != null) {
        return RemainderParamsMapper.toDTO(remainderParams);
      }

      entity.setMaxRemainder(getMaxRemainder(entity));
      repository.save(entity);
      return RemainderParamsMapper.toDTO(entity);

    }).toList();

  }

  public RemainderParamsDTO getById(int id) {
    var result = repository.getById(id);
    if (result == null) return null;
    return RemainderParamsMapper.toDTO(result);
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
