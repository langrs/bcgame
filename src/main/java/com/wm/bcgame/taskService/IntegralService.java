package com.wm.bcgame.taskService;

import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.comm.DateUtil;
import com.wm.bcgame.dto.integral.TaskInfoDao;
import com.wm.bcgame.dto.integral.TaskNoiceDao;
import com.wm.bcgame.model.SysTask;
import com.wm.bcgame.model.UserTask;
import com.wm.bcgame.service.SysTaskService;
import com.wm.bcgame.service.UserTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LZM
 * @description
 * @date 13:54 2018/9/21
 * @mondified
 **/
@Service
public class IntegralService {
	private static final Logger logger = LoggerFactory.getLogger(IntegralService.class);

	@Resource
	SysTaskService sysTaskService;
	@Resource
	UserTaskService userTaskService;

	//获取每日积分任务
	public List<TaskInfoDao> getDailyTask(Long userId) {
		List<TaskInfoDao> taskInfoDaos = new ArrayList<>();
		QueryMap queryMap = new QueryMap();
		queryMap.put("disabled",0);
//		任务类型0每日任务 1成长任务
		queryMap.put("taskType",0);
		List<SysTask> sysTasks = sysTaskService.getList(queryMap);
		for(SysTask sysTask:sysTasks){
			TaskInfoDao taskInfoDao = new TaskInfoDao();
			taskInfoDao.setId(sysTask.getId());
			taskInfoDao.setTaskName(sysTask.getTaskName());
			taskInfoDao.setReward(Double.valueOf(sysTask.getTaskReward()));
			taskInfoDao.setRewardType(sysTask.getRewardType());
//			设置任务状态
//			taskInfoDao.setTaskStatus();
		}
		return taskInfoDaos;
	}

	//获取成长积分任务
	public List<TaskInfoDao> getGrowupTask(Long userId) {
		List<TaskInfoDao> taskInfoDaos = new ArrayList<>();

		return taskInfoDaos;
	}

	//获取积分公告
	public List<TaskNoiceDao> getTaskNotice() {
		List<TaskNoiceDao> taskNoiceDaos = new ArrayList<>();

		return taskNoiceDaos;
	}

	//	1.获取积分任务的奖励（如果每日积分
	public UserTask getReward(Long userId, Long taskId) {
		UserTask userTask = new UserTask();
//		每日积分奖励--登录2款游戏
		if(taskId == 1){
			userTask = getRewardByGameTimes(userId,taskId);
		}
		return userTask;
	}

	//1.1获取每日积分任务奖励--每日登陆2款游戏
	public UserTask getRewardByGameTimes(Long userId, Long taskId) {
		UserTask rtn = new UserTask();
		//		当天日期
		Date today = new Date();
		QueryMap queryMap = new QueryMap();
		queryMap.put("disabled",0);
		queryMap.put("userId",userId);
		queryMap.put("taskId",taskId);
		queryMap.put("taskDate", DateUtil.getTodayStr(today));
		UserTask userTask = userTaskService.getOne(queryMap);
		if (userTask != null){
			rtn.setTaskStatus(BaseConstant.TASK_STATUS_FINNISH);
		}else{
//			判断是否满足每日积分任务的条件
//			1.获取当天的登录游戏记录条数

		}
		return rtn;
	}

	//1.2获取每日在线半小时积分奖励
	public UserTask getRewardByOnlineTime(Long userId, Long taskId) {
		UserTask userTask = new UserTask();

		return userTask;
	}

	//	1.3获取成长任务累计签到积分奖励
	public UserTask getRewardBySignIn(Long userId, Long taskId) {
		UserTask userTask = new UserTask();

		return userTask;
	}//	1.4获取成长任务累计兑换代币积分奖励

	public UserTask getRewardByExchangeCoin(Long userId, Long taskId) {
		UserTask userTask = new UserTask();

		return userTask;
	}

}
