package app.servicesImpl;

import app.dao.StudentDao;
import app.domain.Student;
import app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void save(Student student) {
        this.studentDao.save(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return this.studentDao.findAll();
    }

    @Override
    public Long count() {
        return this.studentDao.count();
    }

    @Override
    public String studentCoursesData() {
        List<Object[]> queryData = this.studentDao.studentCoursesData();

        StringBuilder result = new StringBuilder();
        for (Object[] data : queryData) {
            String studentName = String.valueOf(data[0]);
            Long coursesCount = (Long) data[1];
            BigDecimal totalPrice = new BigDecimal(String.valueOf(data[2]));
            BigDecimal averagePrice = new BigDecimal(String.valueOf(data[3]));

            result.append(
                    studentName + ", "
                    + coursesCount + ", "
                    + totalPrice + ", "
                    + averagePrice
                    + System.lineSeparator()
            );
        }

        return result.toString();
    }
}
