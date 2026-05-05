package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Section;
import com.pfe.SuperMarketManager.Repository.SectionRepository;
import com.pfe.SuperMarketManager.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public long getSectionCount() {
        return sectionRepository.count();
    }

    @Override
    public void addSection(Section section) {
        sectionRepository.save(section);
    }

    @Override
    public void editSection(Section section) {
        Section existingSection = sectionRepository.findById(section.getId())
                .orElseThrow(()-> new RuntimeException("Section not found"));
        existingSection.setName(section.getName());
        existingSection.setDescription(section.getDescription());

        sectionRepository.save(existingSection);
    }

    @Override
    public void deleteSection(Section section) {
        if (section.getProducts() != null) return;
        sectionRepository.delete(section);
    }

    @Override
    public Section getSection(String sectionName) {
        return sectionRepository.findByName(sectionName);
    }

}

