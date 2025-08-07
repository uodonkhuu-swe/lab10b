package edu.miu.mystudentmgmtapp.service.impl;

import edu.miu.mystudentmgmtapp.model.Classroom;
import edu.miu.mystudentmgmtapp.repository.ClassroomRepository;
import edu.miu.mystudentmgmtapp.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private ClassroomRepository classroomRepository;

    @Autowired
    public void setClassroomRepository(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom addClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }
}
