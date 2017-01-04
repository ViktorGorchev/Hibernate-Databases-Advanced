package app.servicesImpl;

import app.dao.HomeworkDao;
import app.domain.Homework;
import app.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService{

    @Autowired
    private HomeworkDao homeworkDao;

    @Override
    public void save(Homework homework) {
        this.homeworkDao.save(homework);
    }

    @Override
    public Iterable<Homework> findAll() {
        return this.homeworkDao.findAll();
    }

    @Override
    public String studentsAndTheirHomework() {
        List<Object[]> data = this.homeworkDao.getStudentsAndTheirHomework();

        StringBuilder result = new StringBuilder();
        for (Object[] homework : data) {
            String studentName = String.valueOf(homework[0]);
            String homeworkContent = String.valueOf(homework[1]);
            String homeworkContentType = String.valueOf(homework[2]);

            result.append(studentName + " - ");
            result.append(homeworkContent + ", ");
            result.append(homeworkContentType + System.lineSeparator());
        }

        return result.toString();
    }
}
