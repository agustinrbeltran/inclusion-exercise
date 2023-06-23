package com.inclusion.exercise.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributesException;
import java.util.Objects;

class RemainderParamsTest {

  @Test
  void given_X_Y_N_when_get_id_then_not_null_id_is_returned() throws InvalidAttributesException {

    var remainderParams = new RemainderParams(30, 20, 300);
    Assertions.assertNotNull(remainderParams.getId());
    Assertions.assertEquals(Objects.hash(30, 20, 300), remainderParams.getId());

  }

  @Test
  void given_X_less_than_2_when_instantiating_then_exception_is_thrown() {


    var exception = Assertions.assertThrows(
        RemainderInvalidArgument.class,
        () -> {
          new RemainderParams(1, 20, 300);
        }
    );

    Assertions.assertEquals("Invalid x value: 1", exception.getMessage());


  }

}
