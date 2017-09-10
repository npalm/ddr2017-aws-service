package ofouro.demo.aws.web;

import com.netflix.appinfo.AmazonInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(method = RequestMethod.GET)
    public Info getInfo() {

        AmazonInfo amazonInfo = AmazonInfo.Builder.newBuilder().autoBuild("test");
        final String az = amazonInfo.get(AmazonInfo.MetaDataKey.availabilityZone);
        logger.info(String.format("Availability zone: %s", az));

        return new Info(az);
    }

}
