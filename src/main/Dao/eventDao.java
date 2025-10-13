package Dao;

import java.util.List;
import model.event;

public interface eventDao {

  void addevent(event event);

  void deleteEvent(int eventId);

  event getEventById(int eventId);

  List<event> getAllEvents();

  void updateEvent(event event);
}
