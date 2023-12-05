package com.example.product.option;

import com.example.product.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    /**
     * @param id
     * id에 관련된 설명
     *
     * @return
     * 반환값에 관련된 설명
     *
     * OptionResponse.FindByProductIdDTO
     * 리스트로 반환.
     */

    @GetMapping("/products/{id}/options")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        List<OptionResponse.FindByProductIdDTO> optionResponses =
                optionService.findByPorductId(id);

        ApiUtils.ApiResult<?> apiResult =
                ApiUtils.success(optionResponses);

        return ResponseEntity.ok(apiResult);
    }


    @GetMapping("/options")
    public ResponseEntity<?> findAll() {

        List<OptionResponse.FindAllDTO> optionResponses =
                optionService.findAll();

        ApiUtils.ApiResult<?> apiResult = ApiUtils.success(optionResponses);

        return ResponseEntity.ok(apiResult);
    }

}
