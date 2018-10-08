package com.wm.bcgame.taskService;

import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.comm.DateUtil;
import com.wm.bcgame.dto.integral.TaskInfoDto;
import com.wm.bcgame.dto.integral.TaskNoiceDto;
import com.wm.bcgame.model.SysTask;
import com.wm.bcgame.model.UserTask;
import com.wm.bcgame.service.SysTaskService;
import com.wm.bcgame.service.UserHistoryService;
import com.wm.bcgame.service.UserTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Resource
	UserHistoryService userHistoryService;

	//获取每日积分任务
	public List<TaskInfoDto> getDailyTask(Long userId) {
		List<TaskInfoDto> taskInfoDaos = new ArrayList<>();
		QueryMap queryMap = new QueryMap();
		queryMap.put("disabled",0);
//		任务类型0每日任务 1成长任务
		queryMap.put("taskType",0);
		List<SysTask> sysTasks = sysTaskService.getList(queryMap);
		for(SysTask sysTask:sysTasks){
			TaskInfoDto taskInfoDao = new TaskInfoDto();
			taskInfoDao.setId(sysTask.getId());
			taskInfoDao.setTaskName(sysTask.getTaskName());
			taskInfoDao.setReward(Double.valueOf(sysTask.getTaskReward()));
			taskInfoDao.setRewardType(sysTask.getRewardType());
//			设置任务状态
//			1.如果是每日登录游戏奖励任务
//			taskInfoDao.setTaskStatus();
		}
		return taskInfoDaos;
	}

	//获取成长积分任务
	public List<TaskInfoDto> getGrowupTask(Long userId) {
		List<TaskInfoDto> taskInfoDaos = new ArrayList<>();

		return taskInfoDaos;
	}

	//获取积分公告
	public List<TaskNoiceDto> getTaskNotice() {
		List<TaskNoiceDto> taskNoiceDaos = new ArrayList<>();

		return taskNoiceDaos;
	}

	//	1.获取积分任务的奖励(在查询和扣除
	public TaskInfoDto getRewardStatus(Long userId, Long taskId) {
		TaskInfoDto taskInfoDto = new TaskInfoDto();
//		每日积分奖励--登录2款游戏
		if(taskId == 1){
			taskInfoDto = getRewardByGameTimes(userId,taskId);
		}
		return taskInfoDto;
	}



	//1.1获取每日积分任务奖励--每日登陆2款游戏
	public TaskInfoDto getRewardByGameTimes(Long userId, Long taskId) {
		TaskInfoDto rtn = new TaskInfoDto();
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
//			2.如果游戏记录条数大于2的话返回可以得到积分奖励
//			3.否则不能获取积分奖励
			queryMap.clear();
			queryMap.put("userId",userId);
			queryMap.put("startDate",DateUtil.getTodayStr(today));
			queryMap.put("endDate",DateUtil.getNextDayStr(today));
			Integer counts = userHistoryService.getDailyGameCount(queryMap);
			if(counts >=2){
				rtn.setTaskStatus(BaseConstant.TASK_STATUS_READY);
			}else{
				rtn.setTaskStatus(BaseConstant.TASK_STATUS_NOT_READY);
			}
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
