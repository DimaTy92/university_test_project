package com.example.demo.controller;

import com.example.demo.entity.dto.Response;
import com.example.demo.parser.BracketsValueParser;
import com.example.demo.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class LectorController {
    private final BracketsValueParser parser;
    private final LectorService lectorService;

    public Response<String> createGlobalSearch(String incomingMessage) {
        String searcherName = parser.parserValueInBrackets(incomingMessage).trim();
        List<String> listOfSearcherLectors = lectorService.getLectorsFromGlobal(searcherName);
        String responseMessage = String.join(",", listOfSearcherLectors);
        return new Response<>(responseMessage);
    }
}
