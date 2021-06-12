package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.models.Film;

import java.util.List;
import java.util.Optional;

public interface FilmsRepository extends JpaRepository<Film, Long> {

    Optional<Film> findFilmByTitle(String title);

    @Query(nativeQuery = true,
            value = "select f.*,g.name genre_name, c.name country_name " +
                    "from film f " +
                    "join films_genres fg on f.id = fg.film_id " +
                    "join genre g on fg.genre_id = g.id " +
                    "join films_countries fc on f.id = fc.film_id " +
                    "join country c on fc.country_id = c.id where " +
                    "g.name = :genreName")
    List<FilmRO> findFilmsByGenreName(String genreName);

    @Query(nativeQuery = true,
            value = "select f.*,g.name genre_name, c.name country_name " +
                    "from film f " +
                    "join films_genres fg on f.id = fg.film_id " +
                    "join genre g on fg.genre_id = g.id " +
                    "join films_countries fc on f.id = fc.film_id " +
                    "join country c on fc.country_id = c.id where " +
                    "c.name = :countryName")
    List<FilmRO> findFilmsByCountryName(String countryName);

    @Query(nativeQuery = true,
            value = "select f.*,g.name genre_name, c.name country_name " +
                    "from film f " +
                    "join films_genres fg on f.id = fg.film_id " +
                    "join genre g on fg.genre_id = g.id " +
                    "join films_countries fc on f.id = fc.film_id " +
                    "join country c on fc.country_id = c.id " +
                    "where f.title = :filmTitle")
    List<FilmRO> findGenresByFilmTitle(String filmTitle);

//    List<Film> findFilmsByCountriesContains(List<Country> countries);

    @Query(nativeQuery = true,
            value = "select f.*,g.name genre_name, c.name country_name " +
                    "from film f join films_genres fg on f.id = fg.film_id " +
                    "join genre g on fg.genre_id = g.id " +
                    "join films_countries fc on f.id = fc.film_id " +
                    "join country c on fc.country_id = c.id " +
                    "where f.title = :filmTitle")
    List<FilmRO> findCountriesByFilmTitle(String filmTitle);

//    @Query(nativeQuery = true,
//            value = "select * from film where year = :year")
//    List<Film> findFilmsByYear(Short year);

    List<Film> findFilmsByYear(Short year);

}
