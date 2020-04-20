package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MusicStorage {

    private static final List<Music> musics = new ArrayList<>();

    public Music create(Music music) {

        musics.add(music);
        musics.sort(Comparator.comparingInt(Music::getId));

        return music;
    }

    public List<Music> list() {
        return musics;
    }

    public Music edit(Music musicToEdit, Music musicUpdated) {
        musicToEdit.setTitle(musicUpdated.getTitle());
        musicToEdit.setArtist(musicUpdated.getArtist());
        musicToEdit.setReleaseDate(musicUpdated.getReleaseDate());
        musicToEdit.setMusicGenre(musicUpdated.getMusicGenre());

        return musicToEdit;
    }

    public Music search(int id) {
        for (Music music : musics) {
            if (music.getId() == id) {
                return music;
            }
        }
        return null;
    }

    public boolean delete(Music musicToDelete) {
        musics.remove(musicToDelete);
        return true;
    }

    public List<User> getUsers(Music music) {
        return music.getUsers();
    }

}
