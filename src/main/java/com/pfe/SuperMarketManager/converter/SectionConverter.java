package com.pfe.SuperMarketManager.converter;

import com.pfe.SuperMarketManager.Model.Section;
import com.pfe.SuperMarketManager.service.SectionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SectionConverter implements Converter<String, Section> {
    private final SectionService sectionService;
    public SectionConverter(SectionService sectionService) {
        this.sectionService = sectionService;
    }
    @Override
    public Section convert(String id) {
        return sectionService.getSectionById(Integer.parseInt(id))
                .orElseThrow(() -> new RuntimeException("Section not found"));
    }
}