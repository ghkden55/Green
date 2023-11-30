package DAO;

import DTO.MealkitDTO;
import OBJ.Mealkit;

import java.util.List;

public interface MealkitDAO {


    public void createTable();

    public void create(MealkitDTO mealkitDTO);

    public List<Mealkit> findAll();
  
    public Mealkit findById(Long ID);

    public List<Mealkit> findbyCategory(String mealCategory);

    public List<Mealkit> findbyName(String mealName);

    public List<Mealkit> findbyPrice(int mealPrice);

    public void updateAll(MealkitDTO mealkitDTO);

    public void updateName(MealkitDTO mealkitDTO);

    public void updateCategory(MealkitDTO mealkitDTO);

    public void updatePrice(MealkitDTO mealkitDTO);

    public void updateInfo(MealkitDTO mealkitDTO);

    public void delete(Long MealID);

}
