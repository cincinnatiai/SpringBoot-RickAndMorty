package com.rickmorty.characterapi.dto;

public class CharacterDTO {

    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private Origin origin;
    private Location location;
    private String gender;
    private String image;

    public static class Origin {
        private String name;
        private String url;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public void setUrl(){
            this.url = url;
        }

        public String getUrl(){
            return url;
        }
    }

    public static class Location{
        private String name;
        private String url;

        public String getName(){
            return name;

        }
        private void setName(String name){
            this.name = name;
        }

        public String getUrl(){
            return url;
        }

        public void serUrl(String url){
            this.url = url;
        }
    }

    public Origin getOrigin(){
        return origin;
    }

    public void setOrigin(Origin origin){
        this.origin = origin;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
