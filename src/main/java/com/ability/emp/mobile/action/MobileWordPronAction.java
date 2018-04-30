package com.ability.emp.mobile.action;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ability.emp.util.speechsynthesis.SpeechUtil;

/**
 * 单词发音
 * @author Devin
 * @since 2018-3-23
 *
 */
@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/mobile/word")
public class MobileWordPronAction {
	
	
	@RequestMapping(value="/pronunciation/{word}",method=RequestMethod.GET )
	@ResponseBody
	public String pronunciation(@PathVariable("word") String word) throws Exception {
		String pronaddress = SpeechUtil.convert(word);
	    return pronaddress;
	}

}
