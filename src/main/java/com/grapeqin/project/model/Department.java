package com.grapeqin.project.model;

import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

/** Department */
@Data
@Builder
public class Department {
  @Id private Integer departmentId;

  private String departmentName;
}
