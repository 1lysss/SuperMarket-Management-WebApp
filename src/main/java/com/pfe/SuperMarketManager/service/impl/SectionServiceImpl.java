package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Section;
import com.pfe.SuperMarketManager.Repository.SectionRepository;
import com.pfe.SuperMarketManager.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

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
    public void deleteSection(Integer id) {
        sectionRepository.deleteById(id);
    }

    @Override
    public void updateSection(Section section) {
        sectionRepository.save(section);
    }

    @Override
    public Optional<Section> getSectionById(Integer id) {
        return sectionRepository.findById(id);
    }

    @Override
    public void saveImage(MultipartFile image, Section section) throws IOException {
        if (image != null && !image.isEmpty()) {
            String filename = StringUtils.cleanPath(image.getOriginalFilename());
            Path uploadDir = Paths.get("uploads/images/sections");
            Files.createDirectories(uploadDir);
            Files.copy(image.getInputStream(), uploadDir.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
            section.setImagePath("/images/sections/" + filename);
        }
    }
}

