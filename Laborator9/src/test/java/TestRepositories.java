import Repositories.AlbumRepository;
import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;
import datatypes.Album;
import datatypes.Artist;
import datatypes.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

import java.io.FileWriter;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class provides test methods to measure the performance of the JPQL implementation
 * for AlbumRepository. It uses the Faker library to generate random test data and OpenCSV library
 * to write the results into a CSV file.
 */
public class TestRepositories {
    /**
     * This method tests the performance of the JPQL implementation of AlbumRepository
     * with a range of different numbers of albums and maximum number of genres per album.
     * It writes the results into a CSV file.
     *
     * @throws Exception if an error occurs while accessing the database or writing the CSV file
     */
    @Test
    public void mainTest() throws Exception {
        //long timeSaveAll, timeFindAll, timeDeleteAll;
        try (CSVWriter writer = new CSVWriter(new FileWriter("result.csv"))) {
            for (int i = 0; i < 30; i++) {
                var result = this.testSpeedOfJPQL(100 * i, 1 * i);
                String[] data = {Integer.toString(100 * i), Integer.toString(i * 1), Long.toString(result.get(0)), Long.toString(result.get(1)), Long.toString(result.get(2))};
                writer.writeNext(data);
            }
        }
    }

    /**
     * This method generates test data using Faker and measures the time taken to save, find and delete
     * a given number of albums with a given maximum number of genres per album using JPQL.
     * It returns a list of long integers representing the time taken in milliseconds for each operation.
     *
     * @param noOfAlbums       the number of albums to be saved, found and deleted
     * @param maxGenrePerAlbum the maximum number of genres per album
     * @return a list of long integers representing the time taken in milliseconds for each operation.
     * @throws Exception if an error occurs while accessing the database
     */
    @Test
    public List<Long> testSpeedOfJPQL(int noOfAlbums, int maxGenrePerAlbum) throws Exception {

        Faker faker = new Faker();
        SecureRandom random = new SecureRandom();
        List<Album> albums = new ArrayList<>();

        //public Album(LocalDate releaseDate, String title, Artist artist, Set<Genre> genres)
        IntStream.range(0, noOfAlbums).forEach(i -> albums.add(
                new Album(LocalDate.now(), faker.funnyName().name(), new Artist(faker.artist().name()),
                        Stream.generate(() -> new Genre(faker.music().genre())).limit(random.nextInt(maxGenrePerAlbum)).collect(Collectors.toSet()))));
        AlbumRepository albumRepository = new AlbumRepository();


        var timeSaveAll = System.currentTimeMillis();
        albumRepository.saveAll(albums);
        timeSaveAll = System.currentTimeMillis() - timeSaveAll;
        var timeFindAll = System.currentTimeMillis();
        albumRepository.findAll();
        timeFindAll = System.currentTimeMillis() - timeFindAll;
        var timeDeleteAll = System.currentTimeMillis();
        albumRepository.deleteAll();
        timeDeleteAll = System.currentTimeMillis() - timeDeleteAll;
        System.out.println("Time to save all albums: " + timeSaveAll + " ms");
        System.out.println("Time to find all albums: " + timeFindAll + " ms");
        System.out.println("Time to delete all albums: " + timeDeleteAll + " ms");
        return List.of(timeSaveAll, timeFindAll, timeDeleteAll);
    }
}
