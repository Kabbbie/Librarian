import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.milovanov.dao.impl.BookDaoImpl;
import ru.milovanov.dao.interfaces.BookDao;
import ru.milovanov.dao.objects.Book;

public class TestBookRepo {
    private EmbeddedDatabase db;
    private JdbcTemplate jdbcTemplate;
    private BookDao bRepo;
    @Before
    public void setUp(){
        db=new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        jdbcTemplate = new JdbcTemplate(db);

        bRepo= new BookDaoImpl(jdbcTemplate);
    }
    @Test
    public void testFindAll(){
        Assert.assertNotNull(bRepo.getAll());
        Assert.assertEquals(5,bRepo.getAll().size());
    }
    @Test
    public void testFindOne(){
        Assert.assertNotNull(bRepo.getOneByIsbn("2"));
        Assert.assertNull(bRepo.getOneByIsbn("15"));
    }
    @Test
    public void testCreate(){
        Book book=new Book("2212","misha","karas`",null);
        Assert.assertEquals(book,bRepo.create(book));
    }
    @Test
    public void testUpdate(){
        Book book=bRepo.getOneByIsbn("2");
        book.setUsername("admin");
        //System.out.println(book);
        Assert.assertEquals(book,bRepo.update(book));
    }
    @Test
    public void testDelete(){
        Book book=new Book("2212","misha","karas`",null);
        bRepo.create(book);
        bRepo.delete(book.getIsbn());
        Assert.assertNull(bRepo.getOneByIsbn(book.getIsbn()));
    }
    @After
    public void tearDown(){
        db.shutdown();
    }
}
