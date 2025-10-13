package Dao;

import java.util.*;
import model.Note;

public interface NoteDao {

  void addNote(Note note);

  void deleteTask(int NoteId);

  Note getNotebyId(int id);

  List<Note> getAllNote();
}
