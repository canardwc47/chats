package fr.eni.tp.chat.controllers;


import fr.eni.tp.chat.bll.ChatService;
import fr.eni.tp.chat.bo.Chat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/chats")

public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("chats",chatService.trouverChats());
        return "leschats";
    }


    @GetMapping("/detail")
    public String detail(@RequestParam(name = "idChat") int idChat,Model model){
        var chat=chatService.trouverChat(idChat);
        if (chat==null)
            return "redirect:/chats";
        System.out.println(chat);

        model.addAttribute("chat",chat);
        System.out.println(model);
        return "unchat";
    }
    @GetMapping("/creer")
    public String newChat(Model model) {
        model.addAttribute("chat", new Chat());
        return "view-chat-create";
    }

    @PostMapping("/creer")
    public String saveNewChat(@ModelAttribute Chat chat , Model model) {

        chatService.addChat(chat);
        model.addAttribute("chats",chatService.trouverChats());
        System.out.println(chat);
        return "leschats";
    }

    @GetMapping("/modif")
    public String updateChat(@RequestParam(name = "idChat") int idChat,Model model) {
        model.addAttribute("chat", chatService.trouverChat(idChat));
        return "view-chat-update";
    }

    @PostMapping("/modif")
    public String saveUpdateChat(@ModelAttribute Chat chat) {

        chatService.updateChat(chat);
        System.out.println(chat);
        return "redirect:/chats";
    }
    @GetMapping("/delete")
    public String deleteChat(@RequestParam(name = "idChat") int idChat,Model model) {
        chatService.removeChat(idChat);
        return "redirect:/chats";
    }

    @PostMapping("/delete")
    public String saveDeleteChat(@ModelAttribute Chat chat) {

        chatService.updateChat(chat);
        System.out.println(chat);
        return "redirect:/chats";
    }
}
