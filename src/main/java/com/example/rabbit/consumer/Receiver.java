package com.example.rabbit.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Component
@Slf4j
public class Receiver implements ChannelAwareMessageListener {


//    @RabbitListener(queues = "ehr.queue")
//    @RabbitHandler
//    public void batchApprovalFromDreamCenter(ApprovalMsgVo vo) {
//        List<String> businessIds = vo.getBusinessIds();
//        List<Long> insIds = businessIds.stream().map(Long::parseLong).collect(Collectors.toList());
//        List<ApprovalInfo> approvalInfos = oaBpmService.queryApprovalList(insIds);
//        if (CollectionUtils.isEmpty(approvalInfos)) {
//            log.warn("流程ID为{}的申请列表里没有需要更新状态的申请记录", insIds);
//        }
//        BatchApprovalDto batchApprovalDto = new BatchApprovalDto();
//        ApprovalResultDto approvalResultDto = new ApprovalResultDto();
//        approvalResultDto.setResult(String.valueOf(vo.getApprovalStatus()));
//        List<BaseApprovalDto> baseApprovalDtos = approvalInfos.stream().map(info -> {
//                    BaseApprovalDto baseApprovalDto = new BaseApprovalDto();
//                    baseApprovalDto.setTodoId(info.getTodoId());
//                    baseApprovalDto.setInsId(info.getInsId());
//                    baseApprovalDto.setSeqNum(info.getSeqNumber());
//                    return baseApprovalDto;
//                }
//        ).collect(Collectors.toList());
//        log.info("待更新状态的申请列表的申请流水号为{}",
//                baseApprovalDtos.stream().map(BaseApprovalDto::getSeqNum).collect(Collectors.toList()));
//        batchApprovalDto.setApprovalResultDto(approvalResultDto);
//        batchApprovalDto.setBaseApprovalDtos(baseApprovalDtos);
//        batchApprovalAo.batchApproval(batchApprovalDto);
//    }

    @Override
    public void onMessage(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try
        {
            if ("ehr.queue".equals(message.getMessageProperties().getConsumerQueue()))
            {
                System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                System.out.println("接收消息: " + new String(message.getBody(), StandardCharsets.UTF_8));
                System.out.println("执行queue_name中的消息的业务处理流程......");
            }
            /**
             * 确认消息，参数说明：
             * long deliveryTag：唯一标识 ID。
             * boolean multiple：是否批处理，当该参数为 true 时，
             * 则可以一次性确认 deliveryTag 小于等于传入值的所有消息。
             */
            channel.basicAck(deliveryTag, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();

            /**
             * 拒绝消息，参数说明：
             * long deliveryTag：唯一标识 ID。
             * boolean requeue：如果 requeue 参数设置为 true，
             * 则 RabbitMQ 会重新将这条消息存入队列，以便发送给下一个订阅的消费者；
             * 如果 requeue 参数设置为 false，则 RabbitMQ 立即会还把消息从队列中移除，
             * 而不会把它发送给新的消费者。
             */
            channel.basicReject(deliveryTag, false);
        }
    }
}
