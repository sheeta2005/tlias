package com.sheeta1998.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class HaveStudent extends RuntimeException {
  public HaveStudent(String message) {
    super(message);
  }
}
