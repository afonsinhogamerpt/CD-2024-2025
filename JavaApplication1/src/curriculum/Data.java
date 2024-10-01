/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum;

/**
 *
 * @author afonsorgcosta
 */
public class Data{
        private String nome;
        private int media;
        private String eventos;
        private String contactos;
        private int id;

        public Data(String nome, int  media, String eventos, String contactos, int id) {
            this.nome = nome;
            this.media = media;
            this.eventos = eventos;
            this.contactos = contactos;
            this.id = id;
        }
        
        public Data(){
            this.nome = "";
            this.media = 0;
            this.eventos = "";
            this.contactos = "";
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getMedia() {
            return media;
        }

        public void setMedia(int media) {
            this.media = media;
        }

        public String getEventos() {
            return eventos;
        }

        public void setEventos(String eventos) {
            this.eventos = eventos;
        }

        public String getContactos() {
            return contactos;
        }

        public void setContactos(String contactos) {
            this.contactos = contactos;
        }
        
        @Override
        public String toString() {
            return "Data{" + "nome=" + nome + ", media=" + media + ", eventos=" + eventos + ", contactos=" + contactos + ", id=" + id + '}';
        }
        
}
        
