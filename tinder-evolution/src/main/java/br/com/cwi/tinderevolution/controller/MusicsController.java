package br.com.cwi.tinderevolution.controller;


import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.management.MusicManagement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/musics")
public class MusicsController {

    @Autowired
    private MusicManagement management;

    @GetMapping
    private List<Music> list() {
        return management.list();
    }

    @GetMapping("/{id}")
    private Music search(@PathVariable("id") int id) {
        return management.search(id);
    }

    @PostMapping
    private void create(@RequestBody Music music) {
        management.create(music);
    }

    @PutMapping("{id}")
    private Music edit(@PathVariable int id, @RequestBody Music music) {
        return management.edit(id, music);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }

    //get users by music id
    @GetMapping("{id}/users")
    public List<UserDTO> getUsers(@PathVariable("id") int id){
        //created a UserDTO class to handle the JSON serialization as necessary
        return management.getUsers(id);
    }
}

