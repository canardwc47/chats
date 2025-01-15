package fr.eni.tp.chat.bll;

import fr.eni.tp.chat.bo.Chat;
import fr.eni.tp.chat.dal.ChatDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private ChatDAO chatDAO;

    public ChatServiceImpl(ChatDAO chatDAO) { this.chatDAO = chatDAO; }

    @Override
    public Chat trouverChat(int idChat) {
        return chatDAO.read(idChat);
    }


    @Override
    public List<Chat>  trouverChats() {
        return chatDAO.findAll();
    }

    @Override
    public void addChat(Chat chat) {
        Chat chatAvecIdIdentique = chatDAO.read(chat.getIdChat());
        if (chatAvecIdIdentique == null) {
            chatDAO.create(chat);
        }

    }
}
