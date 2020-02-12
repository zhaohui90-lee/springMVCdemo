package com.melody.aop.staic_aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServiceControlRequestProxy implements IRequestable {
    private final Log logger = LogFactory.getLog(ServiceControlRequestProxy.class);
    private IRequestable requestable;

    public ServiceControlRequestProxy(IRequestable requestable) {
        this.requestable = requestable;
    }

    @Override
    public void request() {
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        try {
            Date sysTime = df.parse(df.format(cal.getTime()));
            Date startTime = df.parse("00:00:00");
            Date endTime = df.parse("06:00:00");
            if (sysTime.before(startTime) && sysTime.after(endTime)){
                return;
            }
        } catch (ParseException e) {
            logger.error(e);
        }
        requestable.request();
    }
}
