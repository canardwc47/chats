package fr.eni.tp.chat.dal;

import fr.eni.tp.chat.bo.Chat;

import java.util.List;

public interface ChatDAO {
    void create(Chat chat);

    List<Chat> findAll();

    Chat read(int idChat);
    void update(Chat chat);

    void delete(int idChat);
}
