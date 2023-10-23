package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic generateTopic(){

        Map<String, String>configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);//DELETE borre mensaje. COMPACT mantiene el mas actual
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86488888");//TIEMPO DE ETENCION
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");//tamaño maximo del segmento - 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");//Tamano maximo de cada mensaje - defecto 1MB


        NewTopic newTopic = TopicBuilder.name("unProgramadorNace-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();

        return newTopic;
    }
}
