package Dao;

import java.util.*;
import model.Note;

public interface NoteDao {

  void addNote(Note note);

  void deleteNote(int NoteId);

  Note getNotebyId(int id);

  void updateNote(Note note);

  List<Note> getAllNote();
}
