package com.example.product.option;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OptionService {

    private final OptionRepository optionRepository;

    // 옵션 개별 상품 검색
    public List<OptionResponse.FindByProductIdDTO> findByPorductId(Long id) {

        List<Option> optionList = optionRepository.findByProductId(id);

        List<OptionResponse.FindByProductIdDTO> optionResponses =
                optionList.stream().map(OptionResponse.FindByProductIdDTO::new)
                        .collect(Collectors.toList());

        return optionResponses;
    }


    // 옵션 전체 상품 검색
    public List<OptionResponse.FindAllDTO> findAll() {
        List<Option> optionList = optionRepository.findAll();

        List<OptionResponse.FindAllDTO> findAllDTOS =
                optionList.stream().map(OptionResponse.FindAllDTO::new)// optionResponse에 들어갈 new 생성
                        .collect(Collectors.toList());

        return findAllDTOS;
    }



}
