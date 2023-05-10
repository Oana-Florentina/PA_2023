package org.entrypoint;

import Repositories.AlbumRepository;
import Repositories.PlaylistRepository;
import datatypes.Album;
import datatypes.Artist;
import datatypes.Genre;
import datatypes.Playlist;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new PlaylistRepository().findById(26520));
    }
}