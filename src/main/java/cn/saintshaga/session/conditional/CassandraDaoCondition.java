package cn.saintshaga.session.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by huang on 18-9-20.
 */
public class CassandraDaoCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String enabled = context.getEnvironment().getProperty("cassandra.enabled", "false");
        return "true".equalsIgnoreCase(enabled);
    }
}
