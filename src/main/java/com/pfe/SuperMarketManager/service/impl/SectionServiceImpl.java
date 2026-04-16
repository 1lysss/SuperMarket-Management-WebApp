package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Section;
import com.pfe.SuperMarketManager.Repository.SectionRepository;
import com.pfe.SuperMarketManager.service.SectionService;
import lombok.RequiredArgsConstructor;
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
}
