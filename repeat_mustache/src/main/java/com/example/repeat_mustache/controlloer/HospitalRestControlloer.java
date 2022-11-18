package com.example.repeat_mustache.controlloer;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import com.example.repeat_mustache.domain.entity.Hospital;
import com.example.repeat_mustache.repository.HospitalRepository;
import com.example.repeat_mustache.service.HospitalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
//@RestController return 이 res,response여야 하는
@RequestMapping("/api/v1/hospitals") //
public class HospitalRestControlloer {

//    private final HospitalRepository hospitalRepository; // 의존성 주입 좋지 못한 관계 -> 레이어드 아키텍쳐로 리팩토
//
//    public HospitalRestControlloer(HospitalRepository hospitalRepository) {
//        this.hospitalRepository = hospitalRepository;
//    }
    private final HospitalService hospitalService;
    public HospitalRestControlloer(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        HospitalResponse hospitalRes = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalRes);
    }

    @GetMapping("")
    public String list(Model model, @PageableDefault(size = 10, sort = "id") Pageable pageable) {
//        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        Page<Hospital> hospitals = hospitalService.getHospitalList(pageable);
        model.addAttribute("hospitals", hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "hospitals/list";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String keyword, @PageableDefault(size = 10, sort = "id")Pageable pageable){
        Page<Hospital> searchList = hospitalService.findHospitalList(keyword,pageable);
        System.out.println(keyword);
        model.addAttribute("searchList",searchList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("keyword",keyword );
        return "hospitals/search";
    }
}
