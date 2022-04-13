package com.railway.office.sevice;
import com.railway.office.model.Timetable;
import java.util.List;

public interface TimetableService {
    List<Timetable> allTimetable();
    void add(Timetable timetable);
    void delete(Timetable timetable);
    void edit(Timetable timetable);
    Timetable getById(int id);
}
