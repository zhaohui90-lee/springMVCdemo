package perform;

import com.melody.pojo.concert.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/concert.xml")
public class PianoPerformanceTest {

    @Autowired
    private Performance performance;

    @Test
    public void perform() {
        performance.perform();
    }
}