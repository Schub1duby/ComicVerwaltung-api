package ch.raiffeisen.ComicVerwaltungapi.Comics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ComicRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final ComicMapper comicMapper;

    public ComicRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.comicMapper = new ComicMapper();
    }

    public List<Comic> getAllComics(){
        String sql = "SELECT * FROM Comics";

        return namedParameterJdbcTemplate.query(sql, comicMapper);
    }

    public List<Comic> getComicById(long id) {
        String sql = "SELECT * FROM Comics WHERE id = :id";

        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.query(sql, params, comicMapper);
    }

    public void insertNewComic(Comic comic){
        String sql = "INSERT INTO Comics (" +
                "comicTitleEn, comicTitleDe, comicReihe, volume, issue, serialNumber, publisher, cgcGrade)" +
                "VALUES (:comicTitleEn, :comicTitleDe, :comicReihe, :volume, :issue, :serialNumber, :publisher, :cgcGrade)";

        HashMap<String, String> params = new HashMap<>();
        params.put("comicTitleEn", comic.getComicTitleEn());
        params.put("comicTitleDe", comic.getComicTitleDe());
        params.put("comicReihe", comic.getComicReihe());
        params.put("volume", comic.getVolume());
        params.put("issue", comic.getIssue());
        params.put("serialNumber", comic.getSerialNumber());
        params.put("publisher", comic.getPublisher());
        params.put("cgcGrade", comic.getCgcGrade());

        namedParameterJdbcTemplate.update(sql, params);
    }

    public void updateComic(Comic comic, long id){
        String sql = "UPDATE Comics " +
                "SET id = :idNew," +
                "comicTitleEn = :comicTitleEn, " +
                    "comicTitleDe = :comicTitleDe, " +
                    "comicReihe = :comicReihe, " +
                    "volume = :volume, " +
                    "issue = :issue, " +
                    "serialNumber = :serialNumber, " +
                    "publisher = :publisher, " +
                    "cgcGrade = :cgcGrade " +
                "WHERE id = :idOld";

        HashMap<String, Object> params = new HashMap<>();
        params.put("idNew", comic.getId());
        params.put("idOld", id);
        params.put("comicTitleEn", comic.getComicTitleEn());
        params.put("comicTitleDe", comic.getComicTitleDe());
        params.put("comicReihe", comic.getComicReihe());
        params.put("volume", comic.getVolume());
        params.put("issue", comic.getIssue());
        params.put("serialNumber", comic.getSerialNumber());
        params.put("publisher", comic.getPublisher());
        params.put("cgcGrade", comic.getCgcGrade());

        namedParameterJdbcTemplate.update(sql, params);
    }

    public void deleteComicById(long id) {
        String sql = "DELETE FROM Comics WHERE id = :id";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
