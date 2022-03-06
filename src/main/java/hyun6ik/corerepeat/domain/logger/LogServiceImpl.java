package hyun6ik.corerepeat.domain.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService{

//    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @Override
    public void logic(String id) {
        final MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
