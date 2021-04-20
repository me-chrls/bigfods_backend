package de.bigfods.data;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.File;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cat extends PanacheEntity {

  public String name;
  public String description;

  @ManyToOne
  public Image image;
}
