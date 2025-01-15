package fr.eni.tp.chat.dal;

import fr.eni.tp.chat.bo.Chat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatDAOBouchon implements ChatDAO {

    // Solution temporaire - gestion d'une liste de formateur locale
    private static List<Chat> lstChat;

    public ChatDAOBouchon() {
        lstChat = new ArrayList<Chat>();
        lstChat.add(new Chat(1, "Pitchoune", "Roux", 3.5 ));
        lstChat.add(new Chat(2,"Bubule", "Blanc", 6.2));
        // Ajout d’un formateur pour différencier les bouchons des couches DAL et BLL
        lstChat.add(new Chat(3, "Nala", "Marron", 2.1));
        // Pour que le cas par défaut fonctionne : coach@campus-eni.fr
        lstChat.add(new Chat(4, "Mistrigri", "Gris",  5.3));
    }


    @Override
    public void create(Chat chat) {
        lstChat.add(chat);

    }

    @Override
    public List<Chat> findAll() {
        return lstChat;
    }



    @Override
    public Chat read(int idChat) {
        return lstChat.stream().filter( item -> item.getIdChat() == (idChat)).findAny().orElse(null);
    }

    @Override
    public void update(Chat chat) {
        Chat item = read(chat.getIdChat());
        if (item != null) {
            item.setNom(chat.getNom());
            item.setCouleur(chat.getCouleur());
        }

    }

    @Override
    public void delete(int idChat) {
        lstChat.remove(read(idChat));

    }
}
