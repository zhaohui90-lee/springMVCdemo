package perform;

import com.melody.pojo.concert.Performance;
import com.melody.config.ConcertConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class PianoPerformanceAnnoTest {

    @Autowired
    private Performance performance;

    @Test
    public void perform() {
        performance.perform();
    }
}