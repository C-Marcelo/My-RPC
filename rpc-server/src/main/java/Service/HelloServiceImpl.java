package Service;

import com.myk.HelloObject;
import com.myk.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author myk
 */
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String Hello(HelloObject object) {
        logger.info("接收到：{}", object.getMessage());
        return "这是调用的返回值，id=" + object.getId();
    }
}
