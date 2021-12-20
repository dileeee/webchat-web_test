package com.wechat.web.aggregator;

import com.wechat.web.model.Member;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc
 */
public class MemberAggregator implements ArgumentsAggregator {

	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
		Member member = new Member();
		member.setUserName(accessor.getString(0));
		member.setEnglishName(accessor.getString(1));
		member.setAcctId(accessor.getString(2));
		member.setPhone(accessor.getString(3));
		member.setTelephone(accessor.getString(4));
		member.setMail(accessor.getString(5));
		member.setAddress(accessor.getString(6));
		member.setTitle(accessor.getString(7));

		return member;
	}
}
