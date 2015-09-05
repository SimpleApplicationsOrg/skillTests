package org.simpleapplications.skills;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Skill {

  @GraphId
  private Long id;
  private String code;
  private String name;
  private SkillLevel level;

  public Skill() {
  }

  public Skill(String code, String name, SkillLevel level) {
    validateCode(code);
    validateName(name);
    validateLevel(level);

    this.code = code;
    this.name = name;
    this.level = level;
  }

  public Skill(String code, String name, String level) {
    this(code, name, SkillLevel.valueOf(level));
  }

  private void validateLevel(SkillLevel level) {
    if (level == null) {
      throw new IllegalArgumentException("Level can not be null");
    }
  }

  private void validateName(String name) {
    if (StringUtils.isEmpty(name)) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
  }

  private void validateCode(String code) {
    if (StringUtils.isEmpty(code)) {
      throw new IllegalArgumentException("Code can not be null or empty");
    }
  }

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  public SkillLevel getLevel() {
    return this.level;
  }

  public Long getId() {
    return this.id;
  }

}
