import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.milovanov.dao.impl.UserDaoImpl;
import ru.milovanov.dao.interfaces.UserDao;
import ru.milovanov.dao.objects.User;

public class TestUserRepo {
    private EmbeddedDatabase db;
    private JdbcTemplate jdbcTemplate;
    private UserDao uRepo;
    @Before
    public void setUp(){
        db=new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        jdbcTemplate = new JdbcTemplate(db);

        uRepo= new UserDaoImpl(jdbcTemplate);
    }
    @Test
    public void testGetAll(){
        Assert.assertNotNull(uRepo.getAll());
        Assert.assertEquals(1,uRepo.getAll().size());
    }
    @Test
    public void testGetOne(){
        Assert.assertNotNull(uRepo.getOne("admin"));
        Assert.assertNull(uRepo.getOne("no-exist"));
    }
    @Test
    public void testCreate(){
        User user=new User("me","1535");
        Assert.assertEquals(user,uRepo.create(user));
    }
    @Test
    public void testUpdate(){
        User user=uRepo.getOne("admin");
        user.setPassword("qwerty");
        Assert.assertEquals(user,uRepo.update(user));
    }
    @Test
    public void testDelete(){
        //Assert.assertNotNull(uRepo.getOne("me"));
        User user=new User("me","qwerty");
        uRepo.create(user);
        uRepo.delete(user.getUsername());
        Assert.assertNull(uRepo.getOne(user.getUsername()));
    }
    @After
    public void tearDown(){
        db.shutdown();
    }
}
