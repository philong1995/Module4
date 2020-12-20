package com.codegym.controller.contract;

import com.codegym.entity.contract.AttachService;
import com.codegym.entity.contract.Contract;
import com.codegym.entity.contract.ContractDetail;
import com.codegym.service.contract.AttachServiceService;
import com.codegym.service.contract.ContractDetailService;
import com.codegym.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;

    @Autowired
    ContractService contractService;

    @Autowired
    AttachServiceService attachServiceService;

    @ModelAttribute("contract")
    List<Contract> contracts(){
        return contractService.findAll();
    }

    @ModelAttribute("attach")
    List<AttachService> attachServices(){
        return attachServiceService.findAll();
    }

    @GetMapping("/contract-detail")
    public ModelAndView listAttachService() {
        List<ContractDetail> contractDetails = contractDetailService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contract/contract_detail");
        modelAndView.addObject("contractDetail", contractDetails);
        return modelAndView;
    }

    @GetMapping("/contract/create-detail")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/contract/create_detail");
        modelAndView.addObject("contractDetail", new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/contract/create-detail")
    public String createContractDetail(Model model, @Valid @ModelAttribute ContractDetail contractDetail,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDetails", this.contractService.findAll());
            return "contract/create_detail";
        }
        this.contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/contract-detail";
    }
}
