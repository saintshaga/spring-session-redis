package cn.saintshaga.session.response;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Created by huang on 18-9-30.
 */
@Data
@Builder
public class Response {
    private Map<String, ?> models;

    private String viewId;
}
