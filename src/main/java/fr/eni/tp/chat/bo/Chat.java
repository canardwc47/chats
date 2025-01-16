package fr.eni.tp.chat.bo;

public class Chat {
    private int idChat;
    private String nom;
    private String couleur;
    private double poids;

    public Chat(int idChat, String nom, String couleur, double poids) {
        this.idChat = idChat;
        this.nom = nom;
        this.couleur = couleur;
        this.poids = poids;
    }

    public Chat() {
    this.poids = 0.0;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "idChat=" + idChat +
                ", nom='" + nom + '\'' +
                ", couleur='" + couleur + '\'' +
                ", poids=" + poids +
                '}';
    }
}
