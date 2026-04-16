package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.Model.Section;
import java.util.List;

public interface SectionService {
    public List<Section> getAllSections();
    public long getSectionCount();

}
