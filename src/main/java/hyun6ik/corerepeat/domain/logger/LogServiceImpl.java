package hyun6ik.corerepeat.domain.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService{

    private final MyLogger myLogger;

    @Override
    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
