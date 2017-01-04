package app.servicesImpl;

import app.dao.CourseDao;
import app.domain.Course;
import app.domain.Resource;
import app.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public void save(Course course) {
        this.courseDao.save(course);
    }

    @Override
    public Iterable<Course> findAll() {
        return this.courseDao.findAll();
    }

    @Override
    public String getCoursesAndTheirResources() {
        List<Object[]> data = this.courseDao.getCoursesAndTheirResources() ;

        StringBuilder result = new StringBuilder();
        for (Object[] courseAndResource : data) {
            String courseName = String.valueOf(courseAndResource[0]);
            String courseDescription = String.valueOf(courseAndResource[1]);
            Resource resource = (Resource) courseAndResource[2];

            result.append(courseName + " -> " + courseDescription + System.lineSeparator());
            result.append(resource.toString());
        }

        return result.toString();
    }

    @Override
    public String coursesWithMoreThanFiveResources() {
        List<Object[]> queryData = this.courseDao.coursesWithMoreThanFiveResources();

        StringBuilder result = new StringBuilder();
        for (Object[] data : queryData) {
            String courseName = String.valueOf(data[0]);
            Long resourcesCount = (Long) data[1];

            result.append(
                    "Course name: " + courseName + ", Resources count: " + resourcesCount + System.lineSeparator());
        }

        return result.toString();
    }

    @Override
    public String coursesAndStudents(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String inputTimeSql = simpleDateFormat.format(date);

        List<Object[]> queryData = this.courseDao.coursesAndStudents(inputTimeSql);

        StringBuilder result = new StringBuilder();
        for (Object[] data : queryData) {
            String courseName = String.valueOf(data[0]);
            Date startDate = (Date) data[1];
            Date endDate = (Date) data[2];
            Date duration = (Date) data[3];
            Long studentsCount = (Long) data[4];

            result.append(courseName + ", ");
            result.append(startDate + ", ");
            result.append(endDate + ", ");
            result.append(duration + ", ");
            result.append(studentsCount + System.lineSeparator());
        }

        return result.toString();
    }
}