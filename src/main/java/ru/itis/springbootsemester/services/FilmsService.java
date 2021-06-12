package ru.itis.springbootsemester.services;

import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.models.Film;

import java.util.List;

public interface FilmsService {
    FilmRO findFilmById(Long filmId);
    FilmRO findFilmByTitle(String title);
    List<FilmRO> findFilmsByGenreName(String genreName);
//    List<String> findGenresByFilmTitle(String filmTitle);
    List<FilmRO> findFilmsByCountryName(String countryName);
//    List<String> findCountriesByFilmTitle(String filmTitle);
    List<FilmRO> findFilmsByYear(Short year);
}
