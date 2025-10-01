package org.example.baitap5.controller;


import org.example.baitap5.entity.CauThu;
import org.example.baitap5.service.ICauThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cauthu")
public class CauThuController {

    @Autowired
    private ICauThuService cauThuService;


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("cauthuList", cauThuService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("cauThu", new CauThu()); // modelAttribute
        return "add";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("cauThu") CauThu cauThu,
                      RedirectAttributes redirectAttributes) {
        cauThuService.addCauThu(cauThu);
        redirectAttributes.addFlashAttribute("mess", "Thêm cầu thủ thành công!");
        return "redirect:/cauthu/list";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        CauThu cauThu = cauThuService.findById(id);
        model.addAttribute("cauThu", cauThu);
        return "edit";
    }



    @PostMapping("/edit")
    public String update(@ModelAttribute("cauThu") CauThu cauThu,
                         RedirectAttributes redirectAttributes) {
        cauThuService.updateCauThu(cauThu);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật cầu thủ thành công!");
        return "redirect:/cauthu/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        cauThuService.deleteCauThu(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa cầu thủ thành công!");
        return "redirect:/cauthu/list";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable (name="id")int id, Model model) {
        CauThu cauThu = cauThuService.findById(id);
        model.addAttribute("cauThu", cauThu);
        return "details";
    }
}
