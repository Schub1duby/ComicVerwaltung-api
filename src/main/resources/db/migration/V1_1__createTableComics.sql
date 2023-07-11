CREATE TABLE Comics (
    id                  INT                 PRIMARY KEY         AUTO_INCREMENT,
    comicTitleEn        VARCHAR(255),
    comicTitleDe        VARCHAR(255),
    comicReihe          VARCHAR(255),
    volume              VARCHAR(10),
    issue               VARCHAR(20),
    serialNumber        VARCHAR(15),
    publisher           VARCHAR(255),
    cgcGrade            VARCHAR(40)
);