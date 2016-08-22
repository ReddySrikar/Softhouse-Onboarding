package se.example2.softhouse.Note;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxs on 2016-08-16.
 */
public class Note {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String text;

    public Note(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
       
    public Note() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
