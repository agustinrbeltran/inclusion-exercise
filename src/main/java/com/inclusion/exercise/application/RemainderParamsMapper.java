package com.inclusion.exercise.application;

import com.inclusion.exercise.domain.RemainderParams;
import com.inclusion.exercise.implementation.RemainderParamsDTO;
import java.util.List;

public class RemainderParamsMapper {

  public static RemainderParams toEntity(RemainderParamsDTO dto) {
    return new RemainderParams(dto.x, dto.y, dto.n);
  }

  public static RemainderParamsDTO toDTO(RemainderParams entity) {
    return new RemainderParamsDTO(entity.getId(), entity.getX(), entity.getY(), entity.getN(), entity.getMaxRemainder());
  }

  public static List<RemainderParams> toEntities(List<RemainderParamsDTO> dtos) {
    return dtos.stream().map(RemainderParamsMapper::toEntity).toList();
  }

}
