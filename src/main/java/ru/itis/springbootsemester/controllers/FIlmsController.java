package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.dto.UserDto;
import ru.itis.springbootsemester.security.details.UserDetailsImpl;
import ru.itis.springbootsemester.services.FilmsService;
import ru.itis.springbootsemester.services.UsersService;

import javax.annotation.security.PermitAll;

@Controller
public class FIlmsController {

    @Autowired
    private FilmsService filmsService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/films")
    public String getFilmsPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = null;
        if (userDetails != null) {
            String email = userDetails.getUsername();
            user = usersService.getUserByEmail(email);
        }
        model.addAttribute("user", user);
        return "films_page";
    }

    @PermitAll
    @GetMapping("/films/{film-id}")
    @ResponseBody
    public ResponseEntity<FilmRO> getFilmByTitle(@PathVariable("film-id") Long filmId) {
        return ResponseEntity.ok(filmsService.findFilmById(filmId));
    }
}
