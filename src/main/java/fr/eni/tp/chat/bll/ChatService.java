package fr.eni.tp.chat.bll;

import fr.eni.tp.chat.bo.Chat;

import java.util.List;

public interface ChatService {

    public Chat trouverChat(int idChat);


    List<Chat> trouverChats();

    void addChat(Chat chat);

    void removeChat(int idChat);

    void updateChat(Chat chat);

}
