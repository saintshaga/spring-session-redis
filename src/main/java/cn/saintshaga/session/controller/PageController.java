package cn.saintshaga.session.controller;

import cn.saintshaga.session.response.Response;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by huang on 18-9-30.
 */
@Controller
public class PageController {
    @RequestMapping("response")
    public Response testReturnType() {
        Map<String, String> model = Maps.newHashMap();
        model.put("hello", "world");
        return Response.builder().viewId("hello world").models(model).build();

    }

}
