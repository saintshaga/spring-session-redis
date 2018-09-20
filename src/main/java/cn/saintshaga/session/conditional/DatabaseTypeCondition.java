package cn.saintshaga.session.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Created by huang on 18-9-20.
 */
public class DatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(DatabaseType.class.getName());
        String value = (String) attributes.get("value");
        String type = context.getEnvironment().getProperty("database.type", "cassandra");
        return value != null && value.equalsIgnoreCase(type);
    }
}
