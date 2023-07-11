package ch.raiffeisen.ComicVerwaltungapi.Comics;


import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComicMapper implements RowMapper<Comic> {

    @Override
    public Comic mapRow(ResultSet rs, int rowNum) throws SQLException {

        int id = rs.getInt("id");
        String comicTitleEn = rs.getString("comicTitleEn");
        String comicTitleDe = rs.getString("comicTitleDe");
        String comicReihe = rs.getString("comicReihe");
        String volume = rs.getString("volume");
        String issue = rs.getString("issue");
        String serialNumber = rs.getString("serialNumber");
        String publisher = rs.getString("publisher");
        String cgcGrade = rs.getString("cgcGrade");

        Comic comic = new Comic();
        comic.setId(id);
        comic.setComicTitleEn(comicTitleEn);
        comic.setComicTitleDe(comicTitleDe);
        comic.setComicReihe(comicReihe);
        comic.setVolume(volume);
        comic.setIssue(issue);
        comic.setPublisher(publisher);
        comic.setCgcGrade(cgcGrade);

        return comic;
    }
}
