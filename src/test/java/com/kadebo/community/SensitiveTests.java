package com.kadebo.community;

import com.kadebo.community.util.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void setSensitiveFilter() {
        String text = "这里可以(赌)博，这里可以吸+毒，这里可以嫖娼，这里可打--架";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
