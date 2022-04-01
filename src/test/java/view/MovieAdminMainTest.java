package view;

import generate.Movie;
import model.BaseDao;
import model.MovieDAO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import util.Config;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MovieAdminMainTest {

    static int id = 0;
    MovieDAO movieDAO;

    @Test
    @Order(1)
    public void configTest() {


        System.out.println(Config.getValue("url"));
        assertNotNull(Config.getValue("url"));
        assertNotNull(Config.getValue("user"));
        assertNotNull(Config.getValue("pwd"));

    }

    /**
     * �����������ݿ⹦��
     */
    @Test
    @Order(2)
    public void BaseDaoTest() {
        BaseDao baseDao = new BaseDao();

        assertNotNull(baseDao.connection);

    }

    /**
     * ����Movie������ɾ�Ĳ鹦��
     */
    @Test
    @Order(3)
    public void MovieDAOAddTest() {
        movieDAO = new MovieDAO();
        Movie movie = new Movie("���Ա���", "���Է���", "�����ӱ���", "���Խ���", "�������", "2020-01-01", "0", "0", "0");
        assertTrue(movieDAO.add(movie));


    }

    @Test
    @Order(4)
    public void BaseDaoSelectTest() {
        BaseDao baseDao = new BaseDao();

        String sql = "select id from movie order by id desc limit 1";
        ResultSet rs = baseDao.executeQuery(sql, null);
        try {
            if (rs.next())
                System.out.println("��ѯ�����һ��idΪ" + rs.getInt(1));
            MovieAdminMainTest.id = rs.getInt(1);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }
    }


    /**
     * ����MovieDaoɾ������
     */
    @Test
    @Order(5)
    public void MovieDAODelTest() {
        assertNotEquals(0, MovieAdminMainTest.id);
        movieDAO = new MovieDAO();
        assertTrue(movieDAO.del(MovieAdminMainTest.id));
    }

}