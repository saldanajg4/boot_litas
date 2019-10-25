package com.spring.service;

import com.spring.entity.Section;
import com.spring.exception.Section_NotFound_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Section_Service_Impl implements Section_Service {
    @Autowired
    private Section_Repository section_repository;

    @Override
    public Iterable<Section> listSections() {
        return this.section_repository.findAll();
    }

    @Override
    public Section getSection(long id) {
        try {
            Optional<Section> optionalSection = section_repository.findById(id);

            if (optionalSection.isPresent())
                return optionalSection.get();
            else
                throw new Section_NotFound_Exception("Section Not Found");
        }
        catch(Exception ex){
            throw new Section_NotFound_Exception("Section Not Found" + ex);
        }
    }
}
