/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.javaee.commons.utils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author koduki
 */
@Named
@Singleton
public class ApplicationLogger {

    Logger appLogger = LogManager.getLogger("application");
    Logger errorLogger = LogManager.getLogger("error");

    @Inject
    RequestIdGenerator requestIdGenerator;

    public void info(String tag, String... params) {
        this.appLogger.info(buildMessage(tag, params));
    }

    public String time(String className, String methodName, long tournaround) {
        String message = buildMessage("time",
                "ClassName:" + className,
                "MethodName:" + methodName,
                "Turnaround(ms):" + tournaround);
        this.appLogger.info(message);
        return message;
    }

    public String access(String uri, String ip, String userAgent, long tournaround) {
        String message = buildMessage("access",
                "URI:" + uri,
                "IP:" + ip,
                "UserAgent:" + userAgent,
                "Turnaround(ms):" + tournaround);
        this.appLogger.info(message);
        return message;
    }

    public String error(Exception exception) {
        String message = buildMessage("error");
        this.errorLogger.error(message, exception);
        return message;
    }

    String buildMessage(String tag, String... params) {
        StringBuilder sb = new StringBuilder();
        sb.append("tag:");
        sb.append(tag);
        sb.append("\t");
        sb.append("request-id:");
        sb.append(requestIdGenerator.getId());
        sb.append("\t");
        for (String param : params) {
            sb.append(param);
            sb.append("\t");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }
}
