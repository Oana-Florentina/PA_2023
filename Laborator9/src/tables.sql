CREATE TABLE genres
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128)
);
CREATE TABLE artists
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128)
);
CREATE TABLE genres_albums
(
    id_album INT,
    id_genre INT

);
CREATE TABLE ALBUMS
(
    id           SERIAL PRIMARY KEY,
    release_date DATE,
    title        VARCHAR(128),
    artists      INT,
    CONSTRAINT fk_artists FOREIGN KEY (artists) REFERENCES artists (id)
);
create TABLE PLAYLIST
(
    id            SERIAL PRIMARY KEY,
    name          varchar(128),
    Creation_date DATE
);

create TABLE PLAYLIST_ALBUMS
(
    id_playlist INT,
    id_album    INT
);