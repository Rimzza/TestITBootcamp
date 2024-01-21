package com.nikita.testtask.contollers;



import com.nikita.testtask.models.User;
import com.nikita.testtask.roles.Role;
import com.nikita.testtask.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("users", userService.findAllSorted());
        return "users/showAll";
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model){
        model.addAttribute("roles", Role.values());
        return "users/new";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.findOne(id));
        return "users/show";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id")int id, Model model){
        model.addAttribute("user", userService.findOne(id));
        return "users/edit";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        userService.save(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") int id,@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/edit";
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }




}
