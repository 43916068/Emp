package com.ability.emp.admin.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ability.emp.admin.entity.AdminSystemParamEntity;
import com.ability.emp.admin.entity.AdminTaskEntity;
import com.ability.emp.admin.server.AdminSystemParamService;
import com.ability.emp.admin.server.AdminTaskService;
import com.ability.emp.util.DataChangeUtil;
import com.ability.emp.util.UUIDUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



/**
 * 任务
 * @author Devin
 * @since 2018-4-3
 *
 */
@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/admin/task")
public class AdminTaskListAction {
	
	
	@Resource
	private AdminTaskService adminTaskService;
	@Resource
	private AdminSystemParamService adminSystemParamService;
	
	ObjectMapper objectMapper = new ObjectMapper();  
	
	
	/**
	 * 返回首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("")
	public String listPage(HttpServletRequest request,HttpServletResponse response){
		return "tasklist";
	}
	
	/**
	 * 返回数据
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/queryAll")
	@ResponseBody
	public String queryAll(int pageSize,int pageNumber,String taskname) throws JsonProcessingException{
		//第一个参数当前页码，第二个参数每页条数
		PageHelper.startPage(pageNumber,pageSize);  
		List<AdminTaskEntity> data = adminTaskService.queryAll(taskname);
		//SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		/**
		 * 日期转换为String类型
		 */
		/*if(data!=null && data.size()>0){
			for(int i=0;i<data.size();i++){
				data.get(i).setStartStringDate(sf.format(data.get(i).getStartDate()!=null?data.get(i).getStartDate():""));
				data.get(i).setEndStringDate(sf.format(data.get(i).getEndDate()!=null?data.get(i).getEndDate():""));
			}
		}*/
		
		Map<String,Object> map = new HashMap<String,Object>();
		PageInfo<AdminTaskEntity> page = new PageInfo<>(data);
		map.put("total",page.getTotal());
		map.put("rows", data);
		return objectMapper.writeValueAsString(map);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addTask(AdminTaskEntity taskEntity) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		taskEntity.setId(UUIDUtil.generateUUID());		
		if(taskEntity.getStartStringDate()!=null&&taskEntity.getStartStringDate()!="")
			taskEntity.setStartDate(sdf.parse(taskEntity.getStartStringDate()));
		if(taskEntity.getEndStringDate()!=null&&taskEntity.getEndStringDate()!="")
			taskEntity.setEndDate(sdf.parse(taskEntity.getEndStringDate()));
		taskEntity.setDel("0");
		adminTaskService.insert(taskEntity);  
		return "tasklist";
	}
	
	@RequestMapping(value = "/taskedit/{id}")
	@ResponseBody
	public String queryTaskById(@PathVariable("id") String id) throws Exception {
		List<AdminTaskEntity> task = adminTaskService.queryTaskById(id);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		if(task!=null && task.size()>0){
			for(int i=0;i<task.size();i++){
				task.get(i).setStartStringDate(sf.format(task.get(i).getStartDate()!=null?task.get(i).getStartDate():""));
				task.get(i).setEndStringDate(sf.format(task.get(i).getEndDate()!=null?task.get(i).getEndDate():""));
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("task", task);
		return objectMapper.writeValueAsString(map);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String updateTask(AdminTaskEntity taskEntity) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		if(taskEntity.getStartStringDate()!=null&&taskEntity.getStartStringDate()!="")
			taskEntity.setStartDate(sdf.parse(taskEntity.getStartStringDate()));
		if(taskEntity.getEndStringDate()!=null&&taskEntity.getEndStringDate()!="")
			taskEntity.setEndDate(sdf.parse(taskEntity.getEndStringDate()));
		adminTaskService.update(taskEntity); 
		return "tasklist";
	}
	
	@RequestMapping("/queryRootSysParam")
	@ResponseBody
	public String queryRootSysParam() throws Exception {
		AdminSystemParamEntity aspe = new AdminSystemParamEntity();
		List<AdminSystemParamEntity> rootSysParam=adminSystemParamService.queryAll(aspe);
		return dataRootChange(rootSysParam);
	}
	
	@RequestMapping("/queryNodeSysParam")
	@ResponseBody
	public String queryNodeSysParam(AdminSystemParamEntity aspe) throws Exception {
		List<AdminSystemParamEntity> nodeSysParam=adminSystemParamService.queryChild(aspe);
		return dataNodeChange(nodeSysParam);
	}
	
	private String dataRootChange(List<AdminSystemParamEntity> list) throws JsonProcessingException{
		List<DataChangeUtil> changeAfter = new ArrayList<DataChangeUtil>();
		for(int i=0;i<list.size();i++){
			DataChangeUtil dcu = new DataChangeUtil();
			dcu.setId(list.get(i).getId());
			dcu.setText(list.get(i).getParentName());
			dcu.setNodes(new ArrayList<DataChangeUtil>());
			changeAfter.add(dcu);
		}
		return objectMapper.writeValueAsString(changeAfter);
	}
	
	private String dataNodeChange(List<AdminSystemParamEntity> list) throws JsonProcessingException{
		List<AdminSystemParamEntity> rootSysParam=adminSystemParamService.queryAll(new AdminSystemParamEntity());
		List<DataChangeUtil> changeAfter = new ArrayList<DataChangeUtil>();
		
		List<DataChangeUtil> changeAfter2 = new ArrayList<DataChangeUtil>();
		for(int i=0;i<rootSysParam.size();i++){
			DataChangeUtil dcu = new DataChangeUtil();
			dcu.setId(rootSysParam.get(i).getId());
			dcu.setText(rootSysParam.get(i).getParentName());
			for(int k=0;k<list.size();k++){
				if(rootSysParam.get(i).getId().equals(list.get(i).getParentValue())){
					DataChangeUtil dcu2 = new DataChangeUtil();
					dcu2.setId(list.get(i).getId());
					dcu2.setText(list.get(i).getChildName());
					dcu2.setNodes(new ArrayList<DataChangeUtil>());
					changeAfter2.add(dcu2);
				}
			}
			dcu.setNodes(changeAfter2);
			changeAfter.add(dcu);
		}
		return objectMapper.writeValueAsString(changeAfter);
	}
}
