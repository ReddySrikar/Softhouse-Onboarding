package se.example2.softhouse.Note;

import com.google.common.base.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


@Path("/note")
public class NoteResource {

    private List<Note> notes;
    private AtomicLong id;

    public NoteResource(Note defaultNote) {
        notes = new ArrayList<>();
        id = new AtomicLong();

        defaultNote.setId(id.incrementAndGet());
        notes.add(defaultNote);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getNotes(@QueryParam("id")Optional<Long> id) {

        if(id.isPresent()) {
            return notes
                    .stream()
                    .filter(o -> o.getId().equals(id.get()))
                    .collect(Collectors.toList());
        }
        return notes;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNote(Note newNote) {
        newNote.setId(id.incrementAndGet());
        notes.add(newNote);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Note getSpecificNote(@PathParam("id") Long id) {

        for(Integer i = 0; i < notes.size(); i++) {
            if(notes.get(i).getId().equals(id)) {
                return notes.get(i);
            }
        }

        return null;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateNote(Note updatedNote, @PathParam("id") Long id) {

        for(Note note:notes) {
            if(note.getId().equals(id)) {
                note.setText(updatedNote.getText());
                note.setTitle(updatedNote.getTitle());
            }
        }
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteNote(@PathParam("id") Long id) {

    	for(Integer i = 0; i < notes.size(); i++) {
            if(notes.get(i).getId().equals(id)) {
                notes.remove(notes.get(i));
                break;
            }
        }
    }
}
