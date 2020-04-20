package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CuriosityStorage {

    private static List<Curiosity> curiosities = new ArrayList<>();

    public Curiosity create(Curiosity curiosity) {

        curiosities.add(curiosity);
        curiosities.sort(Comparator.comparingInt(Curiosity::getId));
        return curiosity;
    }

    public List<Curiosity> list() {
        return curiosities;
    }

    public Curiosity edit(Curiosity curiosityToEdit, Curiosity curiosityUpdated) {
        curiosityToEdit.setDescription(curiosityUpdated.getDescription());
        curiosityToEdit.setCategory(curiosityUpdated.getCategory());

        return curiosityToEdit;
    }

    public Curiosity search(int id) {
        for (Curiosity curiosity : curiosities) {
            if (curiosity.getId() == id) {
                return curiosity;
            }
        }
        return null;
    }

    public boolean delete(Curiosity curiosityToDelete) {
        curiosities.remove(curiosityToDelete);
        return true;
    }

    public List<User> getUsers(Curiosity curiosity) {
        return curiosity.getUsers();
    }
}
