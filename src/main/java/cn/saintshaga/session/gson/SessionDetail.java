package cn.saintshaga.session.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;
import lombok.Builder;
import lombok.Data;

/**
 * Created by huang on 18-9-21.
 */
@Data
@Builder
public class SessionDetail {

    @Since(1.0)
    private String name;
    @Since(1.0)
    private String tenantId;
    @Since(1.1)
    private String newProperty;

    public static void main(String[] args) {
        SessionDetail ver1 = SessionDetail.builder().name("ver1").tenantId("maiw1").build();
        SessionDetail ver2 = SessionDetail.builder().name("ver2").tenantId("maiw2").newProperty("asdf").build();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setVersion(1.0);
        Gson gson1 = gsonBuilder.create();
        Gson gson2 = new Gson();
        String result1 = gson1.toJson(ver1);
        String result2 = gson2.toJson(ver2);
        System.out.println(result1);
        System.out.println(result2);
        SessionDetail newDeserializeOld = gson2.fromJson(result1, SessionDetail.class);
        SessionDetail oldDeserializeNew = gson1.fromJson(result2, SessionDetail.class);
        System.out.println(newDeserializeOld);
        System.out.println(oldDeserializeNew);

    }
}

