package com.example.product.option;

import com.example.product.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @PostMapping("/options/save")
    public ResponseEntity<?> save(@RequestBody OptionResponse.FindByProductIdDTO optionDTO){
        Option saveProduct = optionService.save(optionDTO);
        ApiUtils.ApiResult<?> apiResult = ApiUtils.success(saveProduct);
        return ResponseEntity.ok(apiResult);
    }


    /**
     * @param id
     * id에 관련된 설명
     *
     * @return ResponseEntity
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


    // 옵션 업데이트


    @DeleteMapping("/delete/{id}/options/{optionId}")
    public ResponseEntity<?> delete(@PathVariable Long id, @PathVariable Long optionId){
        optionService.delete(id, optionId);

        ApiUtils.ApiResult<?> apiResult = ApiUtils.success("success");
        return ResponseEntity.ok(apiResult);
    }

}
