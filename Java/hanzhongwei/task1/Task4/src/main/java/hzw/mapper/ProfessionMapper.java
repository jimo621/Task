package hzw.mapper;

import hzw.model.Profession;

import java.util.List;

public interface ProfessionMapper {
    Profession findByIdProfession(int id);

    List<Profession> findByListProfession();
}
