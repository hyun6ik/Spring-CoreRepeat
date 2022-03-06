package hyun6ik.corerepeat.interfaces.logger;

import hyun6ik.corerepeat.domain.logger.LogService;
import hyun6ik.corerepeat.domain.logger.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class MyLoggerController {

    private final LogService logService;
    //    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @GetMapping("log-demo")
    public String logDemo(HttpServletRequest request) {
        final MyLogger myLogger = myLoggerProvider.getObject();
        final String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logService.logic("testId");
        return "OK";

    }
}
