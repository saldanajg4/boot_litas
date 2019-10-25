package com.spring.service;

import com.spring.entity.Section;

public interface Section_Service {
    Iterable<Section> listSections();
    Section getSection(long id);
}
