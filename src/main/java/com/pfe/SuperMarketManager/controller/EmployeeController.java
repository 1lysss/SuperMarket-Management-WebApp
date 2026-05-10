package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeController {

    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /* GET MAPPINGS */


    @GetMapping("/")
    public String showDashboard(Model model){
        return "pages/admin/dashboard";
    }

    @GetMapping("/admin/addEmployee")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "pages/admin/employee_form";
    }

    @GetMapping("/admin/employee_list")
    public String showEmployeeList(Model model) {
        model.addAttribute("getAllEmployees",      employeeService.getAllEmployees());
        model.addAttribute("getAdminCount",        employeeService.getAdminCount());
        model.addAttribute("getStockManagerCount", employeeService.getStockManagerCount());
        model.addAttribute("getCashierCount",      employeeService.getCashierCount());
        return "pages/admin/employee_list";
    }

    @GetMapping("/admin/logs")
    public String showLogs(Model model) {

        // TODO

        return "pages/admin/logs";
    }

    @GetMapping("/admin/sections")
    public String showSections(Model model) {

        // TODO

        return "pages/admin/sections";
    }

    @GetMapping("/admin/supplyRequests")
    public String showSupplyRequests(Model model) {

        // TODO

        return "";
    }

    @GetMapping("/admin/editEmployee/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        // fetch employee by id and add to model
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        // return the same form page
        return "pages/admin/employee_form";
    }


    /* POST MAPPINGS */
    // !READ: return should be a controller route not HTML file path!!!

    @PostMapping("/admin/addEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,@RequestParam("confirmPassword") String confirmPassword) {

        if (!employee.getPassword().equals(confirmPassword)) return "pages/admin/employee_form";
        else    employeeService.saveEmployee(employee);
        return "redirect:/admin/employee_list";
    }

    @PostMapping("/admin/editEmployee/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return "redirect:/admin/employee_list";
    }

    @PostMapping("/admin/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/admin/employee_list";
    }
}


