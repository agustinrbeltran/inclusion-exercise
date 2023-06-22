package com.inclusion.exercise.application;

import com.inclusion.exercise.domain.RemainderParams;
import com.inclusion.exercise.implementation.RemainderParamsDTO;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

public class RemainderParamsMapper {

  public static RemainderParams toEntity(RemainderParamsDTO dto) throws InvalidAttributesException {
    return new RemainderParams(dto.x, dto.y, dto.n);
  }

  public static RemainderParamsDTO toDTO(RemainderParams entity) {
    return new RemainderParamsDTO(entity.getX(), entity.getY(), entity.getN());
  }

  public static List<RemainderParams> toEntities(List<RemainderParamsDTO> dtos)  {
    return dtos.stream().map(dto -> {
      try {
        return toEntity(dto);
      } catch (InvalidAttributesException e) {
        throw new RuntimeException(e);
      }
    }).toList();
  }

}
