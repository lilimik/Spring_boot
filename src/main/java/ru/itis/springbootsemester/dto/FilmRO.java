package ru.itis.springbootsemester.dto;

import lombok.*;
import ru.itis.springbootsemester.models.Film;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FilmRO {
    private Long id;
    private String title;
    private Long boxOffice;
    private Long budget;
    private String description;
    private String poster_storage_name;
    private Short year;
    private List<String> countryList;
    private List<String> genresList;

    public static FilmRO from(Film film) {
        FilmRO filmRO = FilmRO.builder()
                .id(film.getId())
                .title(film.getTitle())
                .boxOffice(film.getBoxOffice())
                .budget(film.getBudget())
                .description(film.getDescription())
                .poster_storage_name(film.getPoster_storage_name())
                .year(film.getYear())
                .build();

        film.getGenres().forEach(genre -> filmRO.genresList.add(genre.getName()));
        film.getCountries().forEach(country -> filmRO.genresList.add(country.getName()));
        return filmRO;
    }

    public static List<FilmRO> from(List<Film> films) {
        return films.stream().map(FilmRO::from).collect(Collectors.toList());
    }
}
