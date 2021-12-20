package com.wechat.web.annotation;

import com.wechat.web.aggregator.MemberAggregator;
import org.junit.jupiter.params.aggregator.AggregateWith;

import java.lang.annotation.*;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc 将csv数据转换为Member实体类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(MemberAggregator.class)
public @interface CsvToMember {
}
