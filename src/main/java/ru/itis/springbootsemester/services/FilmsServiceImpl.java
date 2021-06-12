package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.models.Film;
import ru.itis.springbootsemester.repositories.FilmsRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.springbootsemester.dto.FilmRO.*;

@Component
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    private FilmsRepository filmsRepository;

    @Override
    public FilmRO findFilmById(Long id) {
        FilmRO filmRO = null;
        Optional<Film> optionalFilm = filmsRepository.findById(id);
        if (optionalFilm.isPresent()) {
            filmRO = from(optionalFilm.get());
        }
        return filmRO;
    }

    @Override
    public FilmRO findFilmByTitle(String title) {
        FilmRO filmRO = null;
        Optional<Film> optionalFilm = filmsRepository.findFilmByTitle(title);
        if (optionalFilm.isPresent()) {
            filmRO = from(optionalFilm.get());
        }
        return filmRO;
    }

    @Override
    public List<FilmRO> findFilmsByGenreName(String genreName) {
        return filmsRepository.findFilmsByGenreName(genreName);
    }

//    @Override
//    public List<String> findGenresByFilmTitle(String filmTitle) {
//        filmsRepository.findGenresByFilmTitle(filmTitle);
//    }

    @Override
    public List<FilmRO> findFilmsByCountryName(String countryName) {
        return filmsRepository.findFilmsByCountryName(countryName);
    }

//    @Override
//    public List<String> findCountriesByFilmTitle(String filmTitle) {
//        return null;
//    }

    @Override
    public List<FilmRO> findFilmsByYear(Short year) {
        return from(filmsRepository.findFilmsByYear(year));
    }
}
