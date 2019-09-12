package de.heroes.hub.microservice.test.rest.item;

public class GreetingResponseItem {

    private final long id;
    private final String content;

    public GreetingResponseItem(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}