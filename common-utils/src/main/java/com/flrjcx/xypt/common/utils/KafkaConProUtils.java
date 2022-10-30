package com.flrjcx.xypt.common.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * kafka生产者
 *
 * @author Flrjcx
 */
@Slf4j
@Component
public class KafkaConProUtils {
//    @Resource
//    private KafkaConfig kafkaConfig;

    public void kafkaProducer(String topic){
//        1. 创建连接kafka的配置文件
        Properties props = new Properties();
        props.put("bootstrap.servers", "1.117.162.124:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

//        2. 创建生产者
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);

//        3. 发送数据到指定的topic,异步发送
        asyncSendMsg(kafkaProducer);

//        4. 关闭
        kafkaProducer.close();
    }

    //    带回调函数异步方式
    public void asyncSendMsg(KafkaProducer<String, String> kafkaProducer){
            kafkaProducer.send(new ProducerRecord<String, String>("topic", "key" , "value"), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        System.out.println("发送消息出现异常");
                        e.printStackTrace();
                    } else {
                        String topic = recordMetadata.topic();
                        int partition = recordMetadata.partition();
                        long offset = recordMetadata.offset();
                        System.out.println("消息发送到 kafka 中" + topic + "的主题,第" + partition + "分区," +
                                "第" + offset + "条数据");
                    }
                }
            });
        kafkaProducer.close();
    }

//    //初始化线程池
//    public static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
//            Runtime.getRuntime().availableProcessors(),
//            Runtime.getRuntime().availableProcessors() * 5,
//            60,
//            TimeUnit.SECONDS,
//            //缓存线程
//            new LinkedBlockingQueue<>(20),
//            //直接报异常不执行这个线程
//            new ThreadPoolExecutor.AbortPolicy()
//    );
//
//    //发送消息方法
//    public void send(String message) throws Throwable {
//        try {
//
//            EXECUTOR.execute(() -> {
//                log.info("用户操作日志消息内容：" + message);
//                kafkaConfig.kafkaTemplate().send("LOG", message).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//                    @Override
//                    public void onFailure(Throwable ex) {
//                        log.error("发送消息失败：" + ex.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(SendResult<String, Object> result) {
//                        log.info("发送消息成功");
//                    }
//                });
//            });
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//
//    }
//
//    //监听kafka消费
//    @KafkaListener(topics = "LOG", containerFactory = "kafkaListenerContainerFactory")
//    public void consumer() {
//        try {
//            //转换为自己的log实体类
//        } catch (Exception e) {
//            log.error("日志插入失败");
//            e.printStackTrace();
//        }
//    }


}
