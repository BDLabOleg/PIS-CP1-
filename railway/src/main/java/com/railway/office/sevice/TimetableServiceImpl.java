package com.railway.office.sevice;

import com.railway.office.dao.TimetableDAO;
import com.railway.office.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    private TimetableDAO timetableDAO;

    @Autowired
    public void setTimetableDAO(TimetableDAO timetableDAO) {
        this.timetableDAO = timetableDAO;
    }

    @Override
    public List<Timetable> allTimetable() {
        return timetableDAO.allTimetable();
    }

    @Override
    public void add(Timetable timetable) {timetableDAO.add(timetable); }

    @Override
    public void delete(Timetable timetable) {
        timetableDAO.delete(timetable);
    }

    @Override
    public void edit(Timetable timetable) {
        timetableDAO.edit(timetable);
    }

    @Override
    public Timetable getById(int id) {
        return timetableDAO.getById(id);
    }

}
