package org.example.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectRepositoryTest {

    @Test
    void returnSubjects() throws Exception{
        var subjectList = SubjectRepository.returnSubjects();
        var firstObj = subjectList.getFirst();
        assertNotNull(firstObj.getSubject_name());
    }
}