package com.neckandelbows.service;


import com.neckandelbows.domain.labels.ClassicLabel;

public interface ClassicLabelService {

    void create(ClassicLabel classicLabel);

    ClassicLabel findById(Long id);
}
