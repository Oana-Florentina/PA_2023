CREATE TABLE artists
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE genres
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE albums
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    artist_name VARCHAR(255) NOT NULL,
    year        INTEGER      NOT NULL
);

CREATE TABLE album_genres
(
    album_id INTEGER NOT NULL REFERENCES albums (id),
    genre_id INTEGER NOT NULL REFERENCES genres (id),
    PRIMARY KEY (album_id, genre_id)
);

CREATE TABLE playlists
(
    id                 SERIAL PRIMARY KEY,
    name               VARCHAR(255) NOT NULL,
    creation_timestamp TIMESTAMP    NOT NULL
);

CREATE TABLE playlist_albums
(
    playlist_id INTEGER,
    album_id    INTEGER,
    PRIMARY KEY (playlist_id, album_id),
    FOREIGN KEY (playlist_id) REFERENCES playlists (id) ON DELETE CASCADE,
    FOREIGN KEY (album_id) REFERENCES albums (id) ON DELETE CASCADE
);
