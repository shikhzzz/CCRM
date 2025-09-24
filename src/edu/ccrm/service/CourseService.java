package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseService {
    private List<Course> courses = new java.util.ArrayList<>();

    // ... (methods to add/list courses)

    public List<Course> searchCourses(Predicate<Course> predicate) {
        return courses.stream()
                      .filter(predicate)
                      .collect(Collectors.toList());
    }
}