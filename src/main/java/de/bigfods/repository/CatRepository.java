package de.bigfods.repository;

import de.bigfods.data.Cat;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatRepository implements PanacheRepository<Cat> {

  public List<Cat> findAllCats(){
    return findAll().list();
  }
}
