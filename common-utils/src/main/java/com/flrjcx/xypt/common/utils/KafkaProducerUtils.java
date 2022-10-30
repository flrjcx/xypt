package com.flrjcx.xypt.common.utils;

import com.flrjcx.xypt.common.config.KafkaProducerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * kafka生产者
 *
 * @author Flrjcx
 */
@Slf4j
@Component
public class KafkaProducerUtils {

    @Resource
    private KafkaProducerConfig kafkaConfig;
    /**
     * 异步发送消息
     *
     * @param topic:指定主题
     * @param key:key
     * @param value:发送内容(先转成json字符串在发送)
     */
    public void asyncSendMsg(String topic,String key,String value){
        KafkaProducer<String, String> kafkaProducer = kafkaConfig.kafka();
        kafkaProducer.send(new ProducerRecord<String, String>(topic, key , value), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        log.error("Kafka发送消息出现异常topic:"+topic+"key:"+key);
                        e.printStackTrace();
                    } else {
                        String topic = recordMetadata.topic();
                        int partition = recordMetadata.partition();
                        long offset = recordMetadata.offset();
                        log.info("消息发送到 kafka 中" + topic + "的主题,第" + partition + "分区," +
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
