package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Section;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SectionService {
    List<Section> getAllSections();
    long getSectionCount();

    // CRUD

    void addSection(Section section);
    void deleteSection(Integer id);
    void updateSection(Section section);
    Optional<Section> getSectionById(Integer id);
    void saveImage(MultipartFile image, Section section) throws IOException;
}
