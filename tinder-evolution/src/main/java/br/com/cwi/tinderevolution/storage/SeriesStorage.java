package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static br.com.cwi.tinderevolution.domain.user.UserDTO.transformList;

@Repository
public class SeriesStorage {

    private static final List<Series> seriesList = new ArrayList<>();

    public Series create(Series series) {

        seriesList.add(series);
        seriesList.sort(Comparator.comparingInt(Series::getId));
        return series;
    }

    public List<Series> list() {
        return seriesList;
    }

    public Series edit(Series seriesToEdit, Series seriesUpdated) {
        seriesToEdit.setName(seriesUpdated.getName());
        seriesToEdit.setDirector(seriesUpdated.getDirector());
        seriesToEdit.setReleaseDate(seriesUpdated.getReleaseDate());
        seriesToEdit.setSeasonQty(seriesUpdated.getSeasonQty());
        seriesToEdit.setEpisodesQty(seriesUpdated.getEpisodesQty());
        seriesToEdit.setSeriesGenre(seriesUpdated.getSeriesGenre());
        seriesToEdit.setStoryline(seriesUpdated.getStoryline());

        return seriesToEdit;

    }

    public Series search(int id) {
        for (Series series : seriesList) {
            if (series.getId() == id) {
                return series;
            }
        }
        return null;
    }

    public boolean delete(Series seriesToDelete) {
        seriesList.remove(seriesToDelete);
        return true;
    }

    public List<UserDTO> getUsers(Series series) {
        return transformList(series.getUsers());
    }

}
