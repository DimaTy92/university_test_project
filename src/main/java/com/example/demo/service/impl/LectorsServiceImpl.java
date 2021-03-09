package com.example.demo.service.impl;

import com.example.demo.entity.Lector;
import com.example.demo.entity.repository.LectorRepository;
import com.example.demo.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectorsServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;

    @Override
    public List<String> getLectorsFromGlobal(String searcherName) {
        List<Lector> lectorsList = lectorRepository.globalSearchByPattern(searcherName);
        return lectorsList.stream()
                .map(lector -> lector.getFirstName() + " " + lector.getLastName())
                .collect(Collectors.toList());
    }
}
