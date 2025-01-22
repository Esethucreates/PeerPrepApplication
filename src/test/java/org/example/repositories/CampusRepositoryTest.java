package org.example.repositories;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CampusRepositoryTest {

    @Test
    void returnCampuses() throws Exception {
        var campusList = CampusRepository.returnCampuses();
        assertNotNull(campusList.getFirst());
    }
}