package com.railway.office.dao;

import com.railway.office.model.Timetable;
import java.util.List;

public interface TimetableDAO {
    List<Timetable> allTimetable();
    void add(Timetable timetable);
    void delete(Timetable timetable);
    void edit(Timetable timetable);
    Timetable getById(int id);
}