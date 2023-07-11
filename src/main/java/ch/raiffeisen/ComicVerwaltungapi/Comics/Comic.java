package ch.raiffeisen.ComicVerwaltungapi.Comics;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comic {
    private long id;
    private String comicTitleEn;
    private String comicTitleDe;
    private String comicReihe;
    private String volume;
    private String issue;
    private String serialNumber;
    private String publisher;
    private String cgcGrade;
}
