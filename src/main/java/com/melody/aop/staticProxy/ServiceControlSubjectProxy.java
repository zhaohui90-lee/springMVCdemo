package com.melody.aop.staticProxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 40431
 */
public class ServiceControlSubjectProxy implements ISubject {
    private final Log logger = LogFactory.getLog(ServiceControlSubjectProxy.class);
    private ISubject subject;

    public ServiceControlSubjectProxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public String request() {
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        try {
            Date sysTime = df.parse(df.format(cal.getTime()));
            Date startTime = df.parse("00:00:00");
            Date endTime = df.parse("06:00:00");
            if (sysTime.before(startTime) && sysTime.after(endTime)){
                return null;
            }
        } catch (ParseException e) {
            logger.error(e);
        }
        String originalResult = subject.request();
        return "Proxy:" + originalResult;
    }
}
